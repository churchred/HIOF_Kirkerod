#
#  Oppgave 5 - for-løkke(r) - Dart 
#
#    I denne oppgaven skal du simulere et dartspill. 
#        - Det skal kastes 3 piler. 
#        - Hvert kast gir mellom 0 og 60 poeng. 
#     
#    Du kan bruke randrange(<fra>, <til>) for å generere en tilfeldig score for hvert kast. 
#
#    Skriv ut sluttscoren. 
#
#    Utvid oppgaven til å ta som input hvor mange spillere som skal spille. 
#    Hver spiller skal kaste 3 piler hver. Spilleren skal kaste alle 3 pilene før neste spiller skal kaste. 
#    Skriv ut resultat for hver spiller når spilleren er ferdig med å kaste. 
#
#
#
#  Bonusoppgave 1 – Dart 2.0:
#
#     Vi her skal forbedre dartoppgaven.  
#
#     Utvid programmet til å ta imot antall piler og antall runder hver spiller skal kaste.
#  
#     Fremfor et tilfeldig tall mellom 0 og 60, så skal du benytte de lovlige 
#     poengene man kan få med et kast. Som er 0p, 1-20p (samt dobbel og trippel av disse), 
#     25p (outer bullseye) og 50p (inner bullseye). 
#


import os, time, random, copy


# Screen size
WIDTH = 43
HEIGHT = 29

# Makes the screen a different size
CMD = 'mode ' + str(WIDTH) + ", " + str(HEIGHT)
os.system(CMD)

# A list of colors to use in command window
# Example: print(RED + "Hey" + RESET), makes "Hey" in red color. 
# While print(RED + "Hey") makes not only "hey" red, but also EVERY print after
RED    = '\33[31m'
GREEN  = '\33[32m'
YELLOW = '\033[33m'
LINE   = '\033[4m'
RESET  = '\33[0m'

# Variables for the different frame lines
hor_line = '\u2500'           
vert_line = '\u2502'
bottom_left_corner = '\u2514'
upper_left_corner = '\u250C'
bottom_right_corner = '\u2518'
upper_right_corner = '\u2510'  

# Rectangle used in the dart board
sq = "\u25A0"                  



# Class for the whole game
class Game():
  def __init__(self):

    self.menu_running = True # We cant leave the meny until this is False

    self.players = 2      # Number of players (changes by user later)
    self.max_players = 4  # Max number of players 
    self.player_list = [] # A list containing all players names and scores

    self.number_of_darts = 3      # How many darts each player throws per rounds
    self.max_number_of_darts = 10 # Becuase users cant have unlimited power to break everything
    self.dart_symbol = "+"        # Symbol used for a dart in the terminal
    self.throw_delay = [1, 5]     # Delay between each dart throw

    self.rounds = 1       # How many rounds the players get before a winner is selected
    self.max_rounds = 10  # Because, why not, users are crazy
      
    # The dart_board we use
    self.dart_board = [
      ["#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"],
      ["#", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"],
      ["#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#"],
      ["#", " ", "#", " ", " ", " ", " ", " ", " ", " ", "#", " ", "#"],
      ["#", " ", "#", " ", "#", "#", "#", "#", "#", " ", "#", " ", "#"],
      ["#", " ", "#", " ", "#", " ", " ", " ", "#", " ", "#", " ", "#"],
      ["#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#", " ", "#"],
      ["#", " ", "#", " ", "#", " ", " ", " ", "#", " ", "#", " ", "#"],
      ["#", " ", "#", " ", "#", "#", "#", "#", "#", " ", "#", " ", "#"],
      ["#", " ", "#", " ", " ", " ", " ", " ", " ", " ", "#", " ", "#"],
      ["#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#"],
      ["#", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"],
      ["#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"]
    ]

    # The values of all dart board posistions, in its own list for easier readablility
    self.dart_board_value = [
      [ 10,   5,  15,   5,   5, 40, 40, 40,   1,   1,   3,   1,   2],
      [ 10,   5,  15,   5,   5, 20, 20, 20,   1,   1,   3,   1,   2],
      [ 24,  12,  36,  12,  12, 60, 60, 60,  18,  18,  54,  18,  36],
      [ 18,   9,  27,   9,   9, 20, 20, 20,   4,   4,  12,   4,   8],
      [ 28,  14,  42,  14,  14, 20, 20, 20,  13,  13,  39,  13,  26],
      [ 22,  11,  33,  11,  11, 25, 25, 25,   6,   6,  18,   6,  12],
      [ 22,  11,  33,  11,  11, 25, 50, 25,   6,   6,  18,   6,  12],
      [ 22,  11,  33,  11,  11, 25, 25, 25,   6,   6,  18,   6,  12],
      [ 16,   8,  24,   8,   8,  3,  3,  3,  10,  10,  30,  10,  20],
      [ 32,  16,  48,  16,  16,  3,  3,  3,  15,  15,  45,  15,  30],
      [ 14,   7,  21,   7,   7,  9,  9,  9,   2,   2,   6,   2,   4],
      [ 38,  19,  57,  19,  19,  3,  3,  3,  17,  17,  51,  17,  34],
      [ 38,  19,  57,  19,  19,  6,  6,  6,  17,  17,  51,  17,  34],
    ]

    # Length of dart board for easier use later
    self.board_rows = len(self.dart_board)
    self.board_colums = len(self.dart_board[0])

    # Names we can use for players
    self.names = [
      "Emma", "Liam", "Olivia", "Noah", "Ava", 
      "Elijah", "Sophia", "James", "Isabella", "Benjamin",
      "Mia", "Lucas", "Amelia", "Henry", "Charlotte", 
      "Alexander", "Harper", "Jack", "Evelyn", "Daniel"
    ]

  # Prints logo
  def print_logo(self):
    print('\n')
    print("#######         #       #######  ########".center(WIDTH))
    print("##    ##       # #      ##    ##    ##   ".center(WIDTH))
    print("##     ##     #   #     ##    ##    ##   ".center(WIDTH))
    print("##     ##    ##   ##    #######     ##   ".center(WIDTH))
    print("##     ##   #########   ##  ##      ##   ".center(WIDTH))
    print("##    ##   ##       ##  ##   ##     ##   ".center(WIDTH))
    print("#######   ##         ## ##    ##    ##   ".center(WIDTH))

  # Draw the board onto the screen
  def draw_board(self, board):
    for row in board:
      row_temp = ""
      for col in row:
        if col == "#":
          row_temp += sq + " "
        else:
          row_temp += col + " "
      print("        " + row_temp)

  # Draw the scoreboard onto the screen
  def draw_scoreboard(self, player_index):

    # Starts the top and bottom of the frame with a corner
    top_line = upper_left_corner
    bottom_line = bottom_left_corner

    # Fills the top and bottom with the right length
    for i in range(WIDTH-18):
      top_line += hor_line
      bottom_line += hor_line

    # Ends the top and bottom of the frame with a corner
    top_line += upper_right_corner
    bottom_line += bottom_right_corner

    # Pritns the top line of the frame
    print(top_line.center(WIDTH-1))
    leader_content = (LINE + "Leaderboard" + RESET).center(len(top_line)-2+len(RESET)+len(LINE))
    print((vert_line + leader_content + vert_line).center(WIDTH+len(RESET)+len(LINE)-1))
    print((vert_line + ("").center(len(top_line)-2) + vert_line).center(WIDTH-1))

    # Prints all the players inside the frame
    for person in self.player_list:
      if player_index != None:
        if person[0] == self.player_list[player_index][0]:
          content = (YELLOW + person[0] + ": " + str(person[1]) + RESET).center(len(top_line)-2+len(YELLOW)+len(RESET))
          print((vert_line + content + vert_line).center(WIDTH+len(YELLOW)+len(RESET)-2))
        else:
          content = (person[0] + ": " + str(person[1])).center(len(top_line)-2)
          print((vert_line + content + vert_line).center(WIDTH-1))
      else:
        content = (person[0] + ": " + str(person[1])).center(len(top_line)-2)
        print((vert_line + content + vert_line).center(WIDTH-1))



    # Prints the bottom line of the frame
    print(bottom_line.center(WIDTH-1))

  # Draw the current player onto the screen
  def draw_current_player(self, player_index):
    print(f"Player: {self.player_list[player_index][0]}".center(WIDTH))
    print(f"Score: {self.player_list[player_index][1]}".center(WIDTH))

  # Draw the victory message onto the screen
  def draw_victory(self):
    self.player_list = sorted(self.player_list, key=lambda x: x[1])
    self.player_list.reverse()
    print(GREEN)
    print(f"The winner is: {self.player_list[0][0]}".center(WIDTH))
    print(RESET)
    print("Press enter to play again".center(WIDTH))
    input("")

  # Draw all the UI elements in the correct order
  def draw_UI(self, board, player_index, round, victory=False):
    if victory == False:
      os.system('cls')
      print('\n')
      self.draw_board(board)
      print(f"Round {round+1}/{self.rounds}".center(WIDTH-1))
      print('\n')
      self.draw_scoreboard(player_index)
      

      random_delay = random.randint(self.throw_delay[0], self.throw_delay[1])
      time.sleep(random_delay)


    if victory == True:
      os.system('cls')
      print('\n')
      self.draw_board(board)
      print(f"Round {round}/{self.rounds}".center(WIDTH-1))
      self.draw_scoreboard(player_index)
      self.draw_victory()


  # Adds players
  def menu(self):

    os.system('cls')
    self.print_logo()
    print('\n')

    print(f"Number of players:".center(WIDTH))
    print((GREEN + "[" + str(self.players) + "]" + RESET).center(WIDTH+len(GREEN)+len(RESET))) #+len(GREEN)+len(RESET)
    print('\n')

    print(f"Number of darts:".center(WIDTH))
    print((GREEN + "[" + str(self.number_of_darts) + "]" + RESET).center(WIDTH+len(GREEN)+len(RESET)))
    print('\n')

    print(f"Number of rounds:".center(WIDTH))
    print((GREEN + "[" + str(self.rounds) + "]" + RESET).center(WIDTH+len(GREEN)+len(RESET)))
     
    print('\n')
    print("(players=, darts=, rounds=, start)".center(WIDTH))
    print("(p=, d=, r=, s)".center(WIDTH))
    print('\n')

    inp = (input("§ ".rjust(int(WIDTH/2)-1)))
    inp = inp.split("=")

    try: 
        # Changes the number of players
        if inp[0] in ["players", "player", "play", "pla", "pl", "p"] and inp[1].isdigit():
          if int(inp[1]) > self.max_players:
            self.players = self.max_players
          else:
            self.players = int(inp[1])

        # Changes the number of darts
        if inp[0] in ["darts", "dart", "dar", "da", "d"] and inp[1].isdigit():
          if int(inp[1]) > self.max_number_of_darts:
            self.number_of_darts = self.max_number_of_darts
          else:
            self.number_of_darts = int(inp[1])

        # Changes the number of rounds
        if inp[0] in ["rounds", "round", "roun", "rou", "ro", "r"] and inp[1].isdigit():
          if int(inp[1]) > self.max_rounds:
            self.rounds = self.max_rounds
          else:
            self.rounds = int(inp[1])

        # Starts everything
        if inp[0] in ["start", "run", "begin", "commence", "initiate", "s"]:
          self.menu_running = False

    except Exception as e:
       print("Error", e)

  # Runs each game for each player
  def play(self, player_index, round):

    # Makes a deep copy of the layered list
    board = copy.deepcopy(self.dart_board)

    # Where the darts will be places
    dart_locations = []

    # Size of the board
    board_size = self.board_rows*self.board_colums

    # Find where the darts land
    for i in range(self.number_of_darts):
      random_location = random.choice([i for i in range(1, (board_size)) if i not in dart_locations])
      dart_locations.append(random_location)

    # Prints and empty board before we start throwing
    self.draw_UI(board, player_index, round)
      

    # Thorw the darts from the list onto the right place on the board list
    for dart_throw in dart_locations:
      for row_index, row in enumerate(board):
        for col_index, colum in enumerate(row):
          if dart_throw == row_index*(len(board)) + col_index+1:
            board[row_index][col_index] = (RED + self.dart_symbol + RESET)
            self.player_list[player_index][1] += self.dart_board_value[row_index][col_index]
            break

      # Draw all the UI elements
      self.draw_UI(board, player_index, round)

  # The game logic. This loops forever.
  def run(self):

    # How many players we have
    while self.menu_running == True:
      self.menu()

    # Makes a list of players with random names
    self.player_list = random.sample([[i, 0] for i in self.names if i not in self.player_list], self.players) 
    
    # Simulates all the rounds, and player turns
    for round in range(self.rounds):
      for person in range(len(self.player_list)):
        self.play(person, round)

    # Draws the victory screen
    self.draw_UI(self.dart_board, None, self.rounds, victory=True)


    



# Game-loop
while True:
  game = Game()
  game.run()
