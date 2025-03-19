
# Import pygame reletated things
import pygame, sys
import tkinter
import tkinter.filedialog

class Screen():
  def __init__(self,
               width=500, height=500, FPS=60, 
               background_color = (255,255,255),
               title="Application", show_fps=True,
               content=[], resizable=False, center_items = False, direction = 1
               ):


    # Pygame stuff
    pygame.init()                 
    pygame.font.init()  


    # Set a blank icon (or transparent icon)
    # Set a blank (transparent) icon
    white_icon = pygame.Surface((1, 1), pygame.SRCALPHA)
    white_icon.fill((255, 255, 255, 255))  # RGBA value for white
    pygame.display.set_icon(white_icon)
          
    self.cursor = [False, None]   # When to change the cursor to a pointer (False=Arrow)
    self.key_event = None         # key pressed
    self.pressed = False

    # If testing, and we dont want something to happen,
    # and we show FPS in title.
    self.show_fps = show_fps
    self.title = title

    # Screen size
    self.width = width
    self.height = height
    self.FPS = FPS

    # Resize variables
    self.minimun_screen_width = 200
    self.minimun_screen_heigth = 150
    self.resizeable = resizable

    # If we center items on the screen
    self.center_items = center_items
    self.direction = direction

    # Background color
    self.background_color = background_color


    # Makes the app screen and internal clock
    if self.resizeable == False:
      self.screen = pygame.display.set_mode((self.width, self.height)) 
    if self.resizeable == True:
      self.screen = pygame.display.set_mode((self.width, self.height), pygame.RESIZABLE) 

    self.clock = pygame.time.Clock()

    # All items we are going to draw onto the screen goes here (must be class)
    self.content = content

    self.triggered = False

    if self.center_items == True:
      self.center()

  # Runs the app
  def run(self):

    # Reset last pressed key
    self.key_event = None

    # Reset Triggered
    self.triggered = False

    # This loop runs everytime pygame catches
    # an event. Such as, keypress, exit, mousewheel.
    for event in pygame.event.get(): 

      # What happens if we exit the app
      if event.type == pygame.QUIT:   
        pygame.quit()
        sys.exit()

      if event.type == pygame.VIDEORESIZE:
        self.resize_logic(event)

      if event.type == pygame.KEYDOWN:
        if event != self.key_event:
          self.key_event = event
          #self.pressed = True

     # if event.type == pygame.KEYUP and self.pressed == True:
      #  self.pressed = False
      
        
    # Gather basic data
    self.dt = self.clock.tick(self.FPS) / 1000   # Delta time. Used for smooth animations
    self.mouse = [pygame.mouse.get_pos(),  # Mouse position and pressed-state.
              pygame.mouse.get_pressed()]
    

    # Turns pointer cursor back to arrow
    # All clickable elements will, if hovered over,
    # make the cursor True. Which later will change
    # the cursor into a finger(the 'its clickable' icon)
    self.cursor = [False, None]
    

    # Background color of app
    self.screen.fill(self.background_color)

    # Packet contains: [Hover, Clicked, item-id, content]
    packet = [False, False, None, None]
    for item in self.content:

      # We draw each element we have in the app
      packet = item.run(self.screen, self.mouse, self.dt, self.key_event)

      # If we are hovering an element in the box
      if packet["hover"] == True:
        self.cursor[0] = True
        if packet["type"] == "input":
          self.cursor[1] = "text"

      
      # If we are clicking an element in the box
      if packet["triggered"] == True:
            #print(f"Clicked {packet}")
            self.triggered = True
            self.value = packet


    # This code decides which mouse cursor we will display,
    # an arrow or pointer. Cursor is true if we are hovering something.
    if self.cursor[0] == True:
      if self.cursor[1] == "text":
        pygame.mouse.set_cursor(pygame.SYSTEM_CURSOR_IBEAM)
      else:
        pygame.mouse.set_cursor(pygame.SYSTEM_CURSOR_HAND)
    elif self.cursor[0] == False:	
      pygame.mouse.set_cursor(pygame.SYSTEM_CURSOR_ARROW)


    # Update screen and clock
    self.clock.tick(self.FPS) # Default FPS Limit: 60

    # Checks which caption to set it the window-banner
    # If testing is true we want to display FPS.
    if self.show_fps == True:
      pygame.display.set_caption(self.title + "     -     FPS (" + str(int(self.clock.get_fps())) + ")")
    if self.show_fps == False:
      pygame.display.set_caption(self.title)


    # Updates the app window
    pygame.display.update()

  # Adds other moduls (eks. buttons) into the screen
  def add(self, *args):
    for item in args:
      self.content.append(item)
    if self.center_items == True:
      self.center()

  # When centering content, this should happen
  def center(self):
    if self.content != []:
      if self.direction in [0, "hor", "horizontal"]:
        self.center_items_horizontally()
      if self.direction in [1, "vert", "vertical"]:
        self.center_items_vertically()

      # Centers internal pieces of things
      for item in self.content:
        item.center()

  # Centers the items in a horizontal row
  def center_items_horizontally(self):

    # We need to find out the width of all items.
    total_width = 0
    for item in self.content:
      total_width += item.width
    
    # We find available space
    space_available = self.width - total_width

    space_between_x = space_available / (len(self.content)+1)
      
    # Then we change the x-value of the items
    for index in range(len(self.content)):
      if index == 0:
        self.content[index].x = 0 + space_between_x
      else:
        self.content[index].x = self.content[index-1].x + self.content[index-1].width + space_between_x

    # Then we find Y value
    for index in range(len(self.content)):
      self.content[index].y = 0 + (self.height - self.content[index].height) / 2
      if self.content[index].type == "flexbox":
        self.content[index].center()

  # Centers the items in a vertical row
  def center_items_vertically(self):

    # We need to find out the height of all items.
    total_height = 0
    for item in self.content:
      total_height += item.height

    # We find available space
    space_available = self.height - total_height

    space_between_y = space_available / (len(self.content)+1)    
    
    # Then we change the x-value of the items
    for index in range(len(self.content)):
      if index == 0:
        self.content[index].y = 0 + space_between_y
      else:
        self.content[index].y = self.content[index-1].y + self.content[index-1].height + space_between_y

    # Then we find the X value
    for index in range(len(self.content)):
      self.content[index].x = 0 + (self.width - self.content[index].width) / 2
      if self.content[index].type == "flexbox":
        self.content[index].center()

  # The logic for screen resizing if enabled
  def resize_logic(self, event):
    
    # Set new screen size
    self.width, self.height = event.w, event.h
    
    # See if its too small
    if self.width < self.minimun_screen_width:
      self.width = self.minimun_screen_width
    if self.height < self.minimun_screen_heigth:
      self.height = self.minimun_screen_heigth

    # Resize the window
    self.screen = pygame.display.set_mode((self.width, self.height), pygame.RESIZABLE)

    if self.center_items == True:
      self.center()

    print(f"Resized window to: {self.width}x{self.height}")

  # Creates a txt file with text
  def write_file(self, filename="text_file.txt", content=""):
    try:
      file = open((filename), "w")
      file.write(str(content))
      file.close()
    except Exception as e:
      return e
    
  # Reads a txt file and returns a string
  def read_file(self, filename="text_file.txt"):
    try:
      with open(filename, "r") as file: 
          contents = file.read()  
      return contents  
    except Exception as e:
      return e

  # Opens windows file handlerer and returns the path to the file you choose
  def prompt_file(self):
      #Create a Tk file dialog and cleanup when finished
      top = tkinter.Tk()
      top.withdraw()  # hide window
      file_name = tkinter.filedialog.askopenfilename(parent=top)
      top.destroy()
      return file_name
  
  def exit(self):
    pygame.quit()
    sys.exit()