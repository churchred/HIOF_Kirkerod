import pygame


class Letter():
  def __init__(self,
               x=0, y=0, width=0, height=0,
               color=(0,0,0), font = "Arial", font_size=16, text="A"):
    
    self.x = x
    self.y = y

    self.width = width
    self.height = height

    self.font = font
    self.font_size = font_size
    self.color = color
    self.text = text
    self.password = "*"
    
    self.make_text()

  def run(self, screen):
    screen.blit(self.text_element, (self.x,self.y))

  def make_text(self):
    # Making the text and getting it's size
    self.myfont = pygame.font.SysFont(self.font, self.font_size)

    # Makes the text element
    self.text_element = self.myfont.render(self.text, 1, (self.color))

    # Get size of text element
    self.width, self.height = self.text_element.get_width(), self.text_element.get_height()




class Input():
  def __init__(self,
               x = 0, y = 0, width = 200, height = 40,
               background_color = (255,255,255), text_color = (0, 0, 0), border_color = (0, 0, 0), ghost_text_color=(150,150,150),
               font = "Arial", font_size = 20, text = "", ghost_text = None, limit=None, character_limit = None, padding = 10,
               max_number = None, min_number = None, disabled = False,
               border_radius = 0, border_width = 1, password = False, id=None):
    
    # Type of item this is
    self.type = "input"
    self.id = id
    self.disabled = disabled

    # Basic variables
    self.x = x
    self.y = y
    self.width = width
    self.height = height

    # Border
    self.border_radius = border_radius
    self.border_width = border_width

    # Color of box
    self.background_color = background_color
    self.border_color = border_color
    self.text_color = text_color
    self.ghost_text_color = ghost_text_color

    # Blinking line at the end
    self.blink_width = 1
    self.blink_height = int(self.height * 0.8)
    self.blink_speed_decrease = 500   # How quickly the line at the end blinks
    self.blink_color = self.text_color
    self.blink_visisble = False

    self.blink_speed = 150
    self.blink_speed_counter = 0


    # Text
    self.text = text
    self.text_array = []
    self.font = font
    self.font_size = font_size     
    self.ghost_text = ghost_text   # Text printed when input field is empty
    self.padding = padding         # PAdding on the left side of the text


    # Important info
    self.password = password                # If password is True, hide text ***
    self.limit = limit                      # limit to text or numbers
    self.character_limit = character_limit  # Character length limit (default:None)
    self.active = False                     # Can we currelty write?
    self.max_number = max_number
    self.min_number = min_number

    self.hover = False         # Are we hovering?
    self.clicked_down = False  # Have we clicked?
    self.hold_down = False     #
    self.triggered = False     # If this is true, we send back info to the main loop
    self.content = None        # What we send back to the main loop(will contain text)
    self.forced = False

    



  def run(self, screen, mouse, dt=1, key_event = None):

    if self.disabled == True:
      self.active = False
      self.draw(screen, dt)
      return {"hover": False, "triggered":False, "id":self.id, "content":self.content, "type":self.type}

    # This is to keep track of hovering anything 
    # and need to change cursor, and if we clicked anything
    self.triggered = False

    # Checks if the cursor goes within the button 
    # AND is not already clicked; Hover test is then True
    if self.hover_check(mouse) == True:
      # If the mouse is NOT clicked when we begin hovering
      if mouse[1][0] == False:
        self.hover = True
    else:
      self.hover = False
      self.clicked_down = False

    # Disables the input when we click somewhere outside it
    if self.hover == False and mouse[1][0] == True:
      self.active = False
      self.blink_visisble = 0
      self.blink_speed_counter = 0


    # If we are within the button and click the mouse
    # Click test is now true
    if self.hover == True and mouse[1][0] == True:
      self.clicked_down = True
      self.hold_down = True

    # Once we are within a button and release AFTER having clicked
    # we run the logic and reset the tests
    if self.clicked_down == True and mouse[1][0] == False:
      self.hover = False
      self.clicked_down = False
      self.active = True

    # The blinker is blinking when the input is active
    if self.active == True:
      self.blinker(dt)

    # When we are active AND press a key, we run this logic
    if self.active == True and key_event != None:
      self.write(key_event)
      
    # Draw all elements
    self.draw(screen, dt)
     
    return {"hover": self.hover_check(mouse), "triggered":self.triggered, "id":self.id, "content":self.content, "type":self.type}
  

  def draw(self, screen, dt):

    # Draws the border
    pygame.draw.rect(screen, self.border_color, (self.x, self.y, self.width, self.height), border_radius=self.border_radius)

    # Draws the inisde of the input
    pygame.draw.rect(screen, self.background_color, (self.x+self.border_width, self.y+self.border_width, 
																				self.width-self.border_width*2, self.height-self.border_width*2), border_radius=self.border_radius)
    

    self.text_width = 0
    
    for item in self.text_array:
      item.x = self.x + self.text_width + self.padding
      item.y = self.y + self.height/2 - item.height/2
      self.text_width += item.width
      item.run(screen)


    # If the blinker should be visible, we draw it.
    if self.blink_visisble == True:
      pygame.draw.rect(screen, self.blink_color, (self.x+self.text_width+self.padding, self.y+self.height*0.1, self.blink_width, self.blink_height))


  # Function for writing text
  def write(self, event):
    
    # If we press backspace, we delete last character in the string
    if event.key == pygame.K_BACKSPACE:
        self.text_array = self.text_array[:-1]  
    else:
      # We add the pressed symbol onto the text string IF there is room
      if self.text_width+self.padding*2 < self.width:
        # If there are no limits
        if self.limit == None:
          letter = Letter(font=self.font, font_size=self.font_size, color=self.text_color, text=event.unicode)
          self.text_array.append(letter)
        elif self.limit == "numbers":
          if event.unicode.isdigit():
            if len(self.text_array) == 0 and event.unicode == "0":
              return
            else:
              letter = Letter(font=self.font, font_size=self.font_size, color=self.text_color, text=event.unicode)
              self.text_array.append(letter)
            
            # Check if higher or lower than min/max
            self.check_size()

  def check_size(self):
    number = ''.join(str(str(item.text)) for item in self.text_array)
    
    if self.max_number != None:
      if int(number) > self.max_number:
        number = self.max_number
        self.set_text(number)
    if self.min_number != None:
      if int(number) < self.min_number:
        number = self.min_number
        self.set_text(number)

  def set_text(self, text):
    self.text_array = []
    for letter in str(text):
      l = Letter(font=self.font, font_size=self.font_size, color=self.text_color, text=letter)
      self.text_array.append(l)

    

  # logic for the blinking thing that indicates you can write
  def blinker(self, dt):

    # Decrease the counter by set amount using delta time to even it out no matter the FPS
    self.blink_speed_counter -= self.blink_speed_decrease*dt

    # If its less than zero, we switch it from visisble to invisisble or the otherway around
    # and we reset the counter.
    if self.blink_speed_counter < 0:
      self.blink_speed_counter = self.blink_speed
      if self.blink_visisble == True:
        self.blink_visisble = False
      else:
        self.blink_visisble = True

  # Checks if the mouse hovers the handle
  def hover_check(self, mouse):
    if mouse[0][1] >= self.y and mouse[0][1] <= self.y + self.height:
      if mouse[0][0] >= self.x and mouse[0][0] <= self.x + self.width:
        return True
    return False

  # Centers internal items when main item is moved in a flexbox centering
  def center(self):
    pass

  # If you need this to acitvate by code(i.e button press) just call this function to force a trigger.
  def reset(self):
    self.triggered = True
    self.content = ''.join(str(str(item.text)) for item in self.text_array)
    self.text_array = []
  