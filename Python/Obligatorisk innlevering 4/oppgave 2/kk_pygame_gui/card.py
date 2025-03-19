
import pygame



class Card():

    def __init__(self, type="", number="", value=0, hidden=False,
                 background_color = (255,255,255), color=(0,0,0),
                 ):

        self.x = 0
        self.y = 0
        
        self.width = 80
        self.height = 120
        self.border_width = 2
        self.hidden = hidden

        self.background_color = background_color
        self.color = color

        self.type = type
        self.number = number
        self.value = value

        self.font = "Arial"
        self.font_size = 20
        self.font_size_2 = 30


        self.make_text()

    
    def run(self, screen, mouse, dt, key_event):

        pygame.draw.rect(screen, self.color, (self.x, self.y, self.width, self.height))

        pygame.draw.rect(screen, self.background_color, (self.x+self.border_width, self.y+self.border_width, 
                                              self.width-self.border_width*2, self.height-self.border_width*2))
        
        if self.hidden == False:
            screen.blit(self.corner_text, (self.x+5, self.y+5))
            screen.blit(self.corner_text, (self.x+self.width-self.corner_text_size[0]-5, self.y+self.height-self.corner_text_size[1]-5))
            screen.blit(self.middle_text, (self.x+self.width/2-self.middle_text_size[0]/2, self.y+self.height/2-self.middle_text_size[1]/2))


        return {"hover":False, "triggered":False, "id":None, "content":None, "type":None}
    

    def make_text(self):

        # Making the text and getting it's size
        self.myfont = pygame.font.SysFont(self.font, self.font_size)
        self.myFont2 = pygame.font.SysFont(self.font, self.font_size_2)

        # Make the card text
        self.corner_text = self.myfont.render(self.type, 1, (self.color))
        self.middle_text = self.myFont2.render(self.number, 1, (self.color))

        # Get the size of text elements
        self.corner_text_size = [self.corner_text.get_width(), self.corner_text.get_height()]
        self.middle_text_size = [self.middle_text.get_width(), self.middle_text.get_height()]

    def center(self):
        pass