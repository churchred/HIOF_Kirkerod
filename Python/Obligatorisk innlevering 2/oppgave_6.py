#
#
#  Oppgave 6 – Pakkeliste 
#
#     Du skal lage et lite program som gjør det mulig 
#     å lage en pakkeliste for når du skal ut og reise. 
# 
#     Programmet skal først skrive ut hvilke valg brukeren har for listeoperasjoner, 
#     i form av kommandoer: En for å legge til noe, en for å slette noe, og en for å skrive ut hele listen. 
# 
#     Brukeren skal deretter kunne skrive en input for å velge hvilken kommando som skal tas i bruk. 
# 
#     Programmet skal gå i en evig løkke frem til brukeren avslutter det med en egen kommando for dette. 
# 
#     Du velger selv hva kommandoene skal være (F.eks. enkeltbokstaver eller ord).
#
#


import os, time

# A list of colors to use in command window
# Example: print(RED + "Hey" + RESET), makes "Hey" in red color. 
# While print(RED + "Hey") makes not only "hey" red, but also EVERY print after
LINE = '\033[4m'
RESET  = '\33[0m'

# Variables for the different frame lines
hor_line = '\u2500'           
vert_line = '\u2502'
bottom_left_corner = '\u2514'
upper_left_corner = '\u250C'
bottom_right_corner = '\u2518'
upper_right_corner = '\u2510' 

# Screen size variables
WIDTH = 50
HEIGHT = 35

# Changes the size of the cmd window
cmd = 'mode ' + str(WIDTH) + ", " + str(HEIGHT)
os.system(cmd)


class Liste():
  def __init__(self):
    
    # Size
    self.width = 35
    self.height = 22

    self.name = "The List:"   # Name at the top of the list.

    # Lists
    self.content = []          # A list with all the content
    self.pagified_content = [] # A list with all the pages, with content, each page with no more than max_content number of elements

    self.max_content = 21      # Max number of items per page in the list
    self.max_chars = 40        # Remove 6 becuase we always print "x) "

    # Pages
    self.pages = 1
    self.current_page = 1
    
    # If the app is running or not
    self.running = True

    # Checks if we just added a new element (used to switch to new page when one is created)
    self.just_added_element = False
    

  def draw_list(self):

    # We make the start of the top line
    top_frame_line = upper_left_corner
    bottom_frame_line = bottom_left_corner

    # Finds the biggest element in the list
    for index, items in enumerate(self.content):
      temp = (str(index+1)+ ") " + items)
      if len(temp) > self.width:
        self.width = len(temp) + 6
    
    # Filling in the frame with lines
    for i in range(self.width):
      top_frame_line += hor_line
      bottom_frame_line += hor_line

    # Adding in the right corners
    top_frame_line += upper_right_corner
    bottom_frame_line += bottom_right_corner

    # Prints the top of the frame
    print(top_frame_line.center(WIDTH))

    # Prints the title and a empty row underneath
    print((vert_line + (LINE + self.name+ RESET).center(self.width+ len(LINE) + len(RESET))  + vert_line).center(WIDTH + len(LINE) + len(RESET)))
    print((vert_line + ("").center(self.width) + vert_line).center(WIDTH))

    # Prints all the items in the list
    leftover_space = self.height
    if len(self.pagified_content) > 0:
      for i in range(len(self.pagified_content[self.current_page-1])):
          temp = (str((i+1)+self.max_content*(self.current_page-1))+ ") " + self.pagified_content[self.current_page-1][i].capitalize())
          print((vert_line + temp + ("").center(self.width - len(temp) ) + vert_line).center(WIDTH))
          leftover_space -= 1
    
    # If the page has left over space after printing content, print empty rows
    for i in range(leftover_space):
      print((vert_line + ("").center(self.width) + vert_line).center(WIDTH))
      
    # Print the bottom of the frame
    print(bottom_frame_line.center(WIDTH))


  def menu(self):

    # Prints page number
    print(f"Page {self.current_page}/{self.pages}".center(WIDTH))
    print('\n')

    # Prints meny actions
    print("add=(name), remove=(name/nr), next, prev, exit".center(WIDTH))
    print('\n')

    # Gets user inputs
    inp = input("§ ".rjust(int(WIDTH/2)-5))
    inp = inp.split("=")

    try:

      # Adds new item
      if inp[0] in ["add", "a"] and inp[1].isdigit() == False and len(inp[1]) < self.max_chars:
        self.content.append(inp[1].lower())

        # Jumps to the page where item was added
        if self.current_page < self.pages:
          self.current_page = self.pages
        
        # We just added item
        self.just_added_element = True
        
      # Removed item
      if inp[0] in ["remove", "r"] and len(self.content) > 0:
        if inp[1].isdigit():
          if int(inp[1]) <= len(self.content) and int(inp[1]) != 0:
            del self.content[int(inp[1])-1]
        else:
          self.content.remove(inp[1].lower())
      
      # Goes to the next page if possible
      if inp[0] in ["next", "n"]:
        if self.current_page != self.pages:
          self.current_page += 1

      # Goes to the previous page if possible
      if inp[0] in ["prev", "p"]:
        if self.current_page != 1:
          self.current_page -= 1

      # Exits the app
      if inp[0] in ["exit"]:
        self.running = False
    
    except Exception as e:
      print(f"Error:  {e}".center(WIDTH))
      time.sleep(3)

    # Updates pages 
    self.make_pages()
  

  # Makes a list with all the pages, each page not having more content than max content
  def make_pages(self):

    # Makes a list with a sublist of page content
    self.pagified_content = []
    for page in range(0, len(self.content), self.max_content):
        self.pagified_content.append(self.content[page:page + self.max_content])
    
    # If we just added an element and that made a new page, go to that page
    if self.pages < len(self.pagified_content) and self.just_added_element == True:
      self.just_added_element = False
      self.current_page = len(self.pagified_content)

    # Sets new number of pages avalible
    self.pages = len(self.pagified_content)

    # If current page is empty, go backwards
    if len(self.pagified_content) < self.current_page:
      self.current_page -= 1

    # If list if empty, pages equal 1
    if self.pages == 0:
      self.pages = 1
    # Checks if current page is zero and sets it to 1
    if self.current_page == 0:
      self.current_page = 1

  # The game loop
  def run(self):
    os.system('cls')
    self.draw_list()
    self.menu()



# App loop
app = Liste()
while app.running:
  app.run()