


import pygame


class Switch():
  def __init__(self, 
      x = 0, y = 0, width = 70, height = 40,
      background_color = (204,204,204), background_color_active = (33,150,243),

      handle_width = 40, handle_height = None, handle_padding = 5,
      handle_color = (250,250,250) , handle_hover_color = None,

      body_radius = 0, handle_radius = None,
      id=None, status=0, speed=300):
    
    # Important values
    self.type = "switch"
    self.id = id


    self.status = 0 # On(1) or Off(0)
    self.speed = speed

    # Location and size of bidy
    self.x = x
    self.y = y
    self.width = width
    self.height= height

    # Loaction and size of handle
    self.handle_x = x
    self.handle_y = y
    self.handle_padding = handle_padding
    self.handle_width = handle_width
    self.handle_height = handle_height
    if handle_height == None:
      self.handle_height = height


    # Color and shape of body
    self.background_color = background_color
    self.background_color_active = background_color_active
    self.body_radius = body_radius


    # Color and shape of handle
    self.handle_color = handle_color
    self.handle_hover_color = handle_hover_color
    self.handle_radius = handle_radius
    if handle_radius == None:
      self.handle_radius = self.body_radius

    # Other
    self.hover = False      # If we are hovering the handle
    self.clicked_down = False    # check if handle has been clicked
    self.first_time_load = True # Runs some spesific logic upon first run(that cant be done while initializing)
    self.change = False
    self.can_switch = True
    self.hover_sendback = False




  def run(self, screen, mouse, dt, key_event):

    self.triggered = False


    # If main body has been moved since creation we use this to center handle.
    # We also use this to center based on start percent different than 0
    if self.first_time_load == True:
      self.center()
      self.first_time_load = False


    # Checks if the cursor goes within the button 
    # AND is not already clicked; Hover test is then True
    if self.hover_check(mouse) == True:
      self.hover_sendback = True
      # If the mouse is NOT clicked when we begin hovering
      if mouse[1][0] == False:
        self.hover = True

    else:
      # Reset tests
      self.hover = False
      self.clicked_down = False
      self.hover_sendback = False


    # If we are within the button and click the mouse
    # Click test is now true
    if self.hover == True and mouse[1][0] == True:
      self.clicked_down = True

    # Once we are within a button and release AFTER having clicked
    # we run the logic and reset the tests
    if self.clicked_down == True and mouse[1][0] == False:
      self.hover = False
      self.clicked_down = False
      self.change = True
      self.can_switch = False

    # When we are hover AND have clicked the handle, this happens:
    if self.change == True:
      self.move_handle(dt) # Moves the handle

    # Draw everything(bar, fill, handle)
    self.draw(screen)

    return {"hover":self.hover_sendback, "triggered":self.triggered, "id":self.id, "content":self.status, "type":self.type}
  

  # Drawing the slider
  def draw(self, screen):
    if self.status == 1:
      pygame.draw.rect(screen, self.background_color_active, (self.x, self.y, self.width, self.height), border_radius=self.body_radius)  
    else:
      pygame.draw.rect(screen, self.background_color, (self.x, self.y, self.width, self.height), border_radius=self.body_radius)  
    

    if self.status == 1:
      pygame.draw.rect(screen, self.background_color_active, (self.handle_x, self.handle_y, self.handle_width, self.handle_height), border_radius=self.handle_radius)
    else:
      pygame.draw.rect(screen, self.background_color, (self.handle_x, self.handle_y, self.handle_width, self.handle_height), border_radius=self.handle_radius)

    pygame.draw.rect(screen, self.handle_color, (self.handle_x+self.handle_padding, self.handle_y+self.handle_padding, 
                                          self.handle_width-self.handle_padding*2, self.handle_height-self.handle_padding*2), border_radius=self.handle_radius)

  # Moving the handle
  def move_handle(self, dt):
    if self.status == 0:
      if self.handle_x + self.handle_width < self.x + self.width:
        self.handle_x += self.speed * dt
      if self.handle_x + self.handle_width >= self.x + self.width:
        self.handle_x = self.x + self.width - self.handle_width
        self.change = False
        self.status = 1
        self.triggered = True
        self.hover_sendback = True

        
    elif self.status == 1:
      if self.handle_x > self.x:
        self.handle_x -= self.speed * dt 
      if self.handle_x <= self.x:
        self.handle_x = self.x
        self.change = False
        self.status = 0
        self.triggered = True
        self.hover_sendback = True



  # Checks if the mouse hovers the handle
  def hover_check(self, mouse):
    if mouse[0][1] >= self.y and mouse[0][1] <= self.y + self.height:
      if mouse[0][0] >= self.x and mouse[0][0] <= self.x + self.width:
        return True



  # Centers handle upon first load
  def center(self):
    
    # Center vertically:
    self.handle_y = self.y + ((self.height - self.handle_height) / 2)

    # Horizontially
    if self.status == 0:
      self.handle_x = self.x
    if self.status == 1:
      self.handle_x = self.x + self.width - self.handle_width


