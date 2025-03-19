import pygame


class Button():
  def __init__(self, 
               x=0, y=0, width=100, height=30,

               background_color=(33,150,243), hover_color = (200,200,200), text_color = (0,0,0), 

               border_width = 1, border_color = (0,0,0), border_radius = 0, disabled_color = (100,100,100),
               
               click_color = None, text_hover_color = None, border_hover_color = False, visible = True,

               font = 'Arial', font_size = 16, click_sink = 1, disabled = False, bold_text = False,
               
               text = "Button", id=None, content = [None]):


    # Important info
    self.text = text                 # Text to show on button  
    self.id = id                     # Info that is sent back when clicked
    self.content = content           # What is returned when clicked
    self.disabled = disabled
    self.visible = visible

    # Type of item this is
    self.type = "button"

    # Size of button elements
    self.width = width
    self.height = height

    # Other important values
    self.sink = 0                  # Current sink value (Not sinked yet)
    self.click_sink = click_sink     # How far down the button sinks when clicked
    self.cut_off_width_top = 0     # How much of the button top we CANT click on 
    self.cut_off_width_bottom = 0  # How much of the button buttom we CANT click on

    # Coordinates
    self.x = x
    self.y = y
    self.scroll_index_y = 0 # How far has it scrolled in Y-direction
    self.scroll_index_x = 0 # How far has it scrolled in X-direction


    # Colors of button elements
    self.background_color = background_color
    self.hover_color = hover_color
    self.border_color = border_color
    self.border_radius = border_radius
    self.border_width = border_width
    self.disabled_color = disabled_color

    # Text variabels
    self.font = font
    self.font_size = font_size
    self.text_color = text_color
    self.bold_text = bold_text

    # Sets the color of the text and if it changes on hover or not.
    if text_hover_color != None:
        self.text_hover_color = text_hover_color
    else:
        self.text_hover_color = text_color

    # Sets the color of the border and if it changes on hover or not.
    if border_hover_color != None:
        self.border_hover_color = border_hover_color
    else:
        self.border_hover_color = border_color

    # Sets the color of the button when clicked, if applicable
    if click_color != None:
      self.click_color = click_color
    else:
      self.click_color = self.hover_color

    # Makes the text
    self.update_text()

    # Activation checks
    self.test_hover = False
    self.test_click = False

    
  
  
  def run(self, screen, mouse, dt, key_event):
    
    # Information sent back to main app
    # Do we hover the button, have we clicked the button
    # Hover, Clicked, button-id, content, type of object
    package = {"hover":False, "triggered":False, "id":self.id, "content":self.content, "type":self.type}

    if self.visible == False:
      return package

    if self.disabled == True:
      self.draw_rect(screen, self.disabled_color, self.border_color)
      self.print_text(screen)
      return package


    # Checks if the cursor goes within the button 
    # AND is not already clicked; Hover test is then True
    if self.check_cursor(mouse) == True:
      package["hover"] = True
      # If the mouse is NOT clicked when we begin hovering
      if mouse[1][0] == False:
        self.test_hover = True
        
    else:
      # Reset tests
      self.test_hover = False
      self.test_click = False
      package["hover"] = False



    # If we are within the button and click the mouse
    # Click test is now true
    if self.test_hover == True and mouse[1][0] == True:
      self.test_click = True

    # Adds a "sinking" effect when button is clicked
    if self.test_click == True:
      self.sink = self.click_sink
    else:
      self.sink = 0

    # Draw the button
    if self.test_click == True:
      self.draw_rect(screen, self.click_color, self.border_color)
    elif self.test_hover == True:
      self.draw_rect(screen, self.hover_color, self.border_color)
    else:
      self.draw_rect(screen, self.background_color, self.border_color)

    # Once we are within a button and release AFTER having clicked
    # we run the logic and reset the tests
    if self.test_click == True and mouse[1][0] == False:
      self.test_hover = False
      self.test_click = False
      package["triggered"] = True

    # Prints the text ontop of the button
    self.print_text(screen)

    return package

  def check_cursor(self, mouse):
    if mouse[0][0] > self.x+self.scroll_index_x and mouse[0][0] < self.x+self.scroll_index_x + self.width:
      if mouse[0][1] > self.y+self.scroll_index_y+self.cut_off_width_top and mouse[0][1] < self.y+self.height+self.scroll_index_y-self.cut_off_width_bottom:
        return True
      

  def print_text(self, screen):
    if self.test_hover == True:
      screen.blit(self.text_element_hover, (self.x+self.scroll_index_x+self.width/2-self.text_width/2, self.sink+self.y+self.scroll_index_y+(self.height/2)-(self.text_height)/2))
    else:
      screen.blit(self.text_element, (self.x+self.scroll_index_x+self.width/2-self.text_width/2, self.sink+self.y+self.scroll_index_y+(self.height/2)-(self.text_height)/2))


  # Draws the button
  def draw_rect(self, screen, color, bord_col):
    pygame.draw.rect(screen, bord_col, (self.x+self.scroll_index_x, self.y+self.sink+self.scroll_index_y, 
                                          self.width, self.height), border_radius=self.border_radius)

    pygame.draw.rect(screen, color, (self.x+self.scroll_index_x+self.border_width, self.y+self.border_width+self.sink+self.scroll_index_y, 
																				self.width-self.border_width*2, self.height-self.border_width*2), border_radius=self.border_radius)
    

  # Creates the text on the button and centers it
  def update_text(self, text=None):

    if text == None:
      text = self.text

    # Making the text and getting it's size
    self.myfont = pygame.font.SysFont(self.font, self.font_size)

    self.myfont.set_bold(self.bold_text)

    
    # Makes the text element
    self.text_element = self.myfont.render(text, 1, (self.text_color))
    self.text_element_hover = self.myfont.render(text, 1, (self.text_hover_color))

    # Get size of text element
    self.text_width, self.text_height = self.text_element.get_width(), self.text_element.get_height()

    # center text inside the button
    self.text_centered = (self.x + self.scroll_index_x + (self.width)/2 - self.text_width/2, 
                          self.y + self.sink + self.scroll_index_y + (self.height/2)-(self.text_height)/2)
    

  # Unused for now, but needed
  def center(self):
    pass