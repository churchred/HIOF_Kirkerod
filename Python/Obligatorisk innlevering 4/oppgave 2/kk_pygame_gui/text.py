
import pygame

class Text():
  def __init__(self,
               x=0, y=0, text="This is text",
               text_color = (0,0,0), font="Arial", font_size = 20, char_limit=None,
               underline = False, capitalize=False, toLowerCase=False, toUpperCase=False,
               underline_padding_top=0, text_padding = 5,
               background_color = None, border_color = None, border_width = 1
               ):
    
    # Important for loop
    self.type = "text"
    self.id = None
    self.char_limit = char_limit


    # Location
    self.x = x
    self.y = y

    # Text info
    self.text = text
    self.font = font
    self.text_color = text_color
    self.font_size = font_size
    self.text_padding = text_padding

    # Backgorund
    self.background_color = background_color
    self.border_color = border_color
    self.border_width = border_width

    # Decorate
    self.underline = underline
    self.underline_thickness = 1
    self.underline_padding_top = underline_padding_top
    self.capitalize = capitalize
    self.toUpperCase = toUpperCase
    self.toLowerCase = toLowerCase

    self.make_text()


  def run(self, screen, mouse, dt, key_event):

    # This is to keep track of hovering anything 
    # and need to change cursor, and if we clicked anything
    # NOT USED IN THIS CLASS, BUT NEEDED FOR CONSISTENSY
    package = {"hover":False, "triggered":False, "id":False, "content":False, "type":False}

    if self.border_color != None:
      pygame.draw.rect(screen, self.border_color, (self.x-self.text_padding/2, self.y-self.text_padding/2, 
                                            self.width + self.text_padding, self.height + self.text_padding))
    if self.background_color != None:
      pygame.draw.rect(screen, self.background_color, (self.x - self.text_padding/2 + self.border_width, 
                                                       self.y+self.border_width-self.text_padding/2, 
																				               self.width-self.border_width*2+self.text_padding, 
                                                       self.height-self.border_width*2+self.text_padding))
  

    screen.blit(self.text_element, (self.x, self.y))

    if self.underline == True:
      pygame.draw.rect(screen, self.text_color, (self.x, self.y+self.height*0.9+self.underline_padding_top, self.width, self.underline_thickness))



    return package
  
  def make_text(self):

    self.printed_text = self.text

    if self.capitalize == True:
      self.printed_text = self.text.capitalize()
    

    if self.toUpperCase == True:
      self.printed_text = self.text.upper()
    

    if self.toLowerCase == True:
      self.printed_text = self.text.lower()



    # Making the text and getting it's size
    self.myfont = pygame.font.SysFont(self.font, self.font_size)

    if self.char_limit != None:
      if len(self.printed_text) > self.char_limit:
        self.printed_text = self.printed_text[:self.char_limit]
        self.printed_text += "..."

    # Makes the text element
    self.text_element = self.myfont.render(self.printed_text, 1, (self.text_color))

    # Get size of text element
    self.width, self.height = self.text_element.get_width(), self.text_element.get_height()

  def change_text(self, txt):
    self.text = txt
    self.make_text()

  def center(self):
    pass