import pygame




class Flexbox():
  def __init__(self,
               x = 0, y = 0, width = 300, height = 300,
               border_radius = 0, background_color = (50,50,50),
               direction = 1, id = None,
               border_color = (0,0,0), border_width = 0,
               contents = None, disabled=False):
    
    # Type of item this is
    self.type = "flexbox"
    self.id = id
    
    # Basic variables
    self.x = x
    self.y = y
    self.width = width
    self.height = height
    self.border_radius = border_radius

    # Border variables
    self.border_color = border_color
    self.border_width = border_width


    # Wether or not things are centered x and y.
    self.direction = direction

    # Color of box
    self.background_color = background_color

    # The things we have inside the box
    self.contents = contents
    if self.contents == None:
      self.contents = []


    # Can we see/interact with it?
    self.disabled = disabled

    # Centers the items
    self.center()


  def center(self):
    if self.contents != []:
      if self.direction in [0, "hor", "horizontal"]:
        self.center_items_horizontally()
      if self.direction in [1, "vert", "vertical"]:
        self.center_items_vertically()

      # Centers internal pieces of things
      for item in self.contents:
        item.center()

  # Centers the items in a horizontal row
  def center_items_horizontally(self):

    # We need to find out the width of all items.
    total_width = 0
    for item in self.contents:
      total_width += item.width
    
    # We find available space
    space_available = self.width - total_width

    space_between_x = space_available / (len(self.contents)+1)
      
    # Then we change the x-value of the items
    for index in range(len(self.contents)):
      if index == 0:
        self.contents[index].x = self.x + space_between_x
      else:
        self.contents[index].x = self.contents[index-1].x + self.contents[index-1].width + space_between_x

    # Then we find Y value
    for index in range(len(self.contents)):
      self.contents[index].y = self.y + (self.height - self.contents[index].height) / 2
      if self.contents[index].type == "flexbox":
        self.contents[index].center()

  # Centers the items in a vertical row
  def center_items_vertically(self):

    # We need to find out the height of all items.
    total_height = 0
    for item in self.contents:
      total_height += item.height

    # We find available space
    space_available = self.height - total_height

    space_between_y = space_available / (len(self.contents)+1)    
    
    # Then we change the x-value of the items
    for index in range(len(self.contents)):
      if index == 0:
        self.contents[index].y = self.y + space_between_y
      else:
        self.contents[index].y = self.contents[index-1].y + self.contents[index-1].height + space_between_y

    # Then we find the X value
    for index in range(len(self.contents)):
      self.contents[index].x = self.x + (self.width - self.contents[index].width) / 2
      if self.contents[index].type == "flexbox":
        self.contents[index].center()


  def run(self, screen, mouse, dt, key_event):

    # This is to keep track of hovering anything 
    # and need to change cursor, and if we clicked anything
    package = {"hover":False, "triggered":False, "id":None, "content":None, "type":self.type}

    if self.disabled == False:
      
      # Making the card on which to place the buttons  
      pygame.draw.rect(screen, self.border_color, (self.x, self.y, self.width, self.height), border_radius=self.border_radius) 

      pygame.draw.rect(screen, self.background_color, (self.x+self.border_width, self.y+self.border_width, 
                                            self.width-self.border_width*2, self.height-self.border_width*2), border_radius=self.border_radius) 

      for item in self.contents:
        packet_temp = item.run(screen, mouse, dt, key_event)
        if(packet_temp["type"] == "input" and packet_temp["triggered"] == True):
          package = packet_temp
        elif packet_temp["hover"] == True or packet_temp["triggered"] == True:
          package = packet_temp


    return package
  

  def add(self, *args):
    for item in args:
      self.contents.append(item)
    self.center()