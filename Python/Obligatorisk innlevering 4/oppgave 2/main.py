
# Import my own Pygame GUI Library (alpha version)
from kk_pygame_gui import *
import random, time

class BlackJack():
  def __init__(self):

    # Is true while the game is running
    self.running = True

    # This is true until someone wins or loses
    self.game_in_progress = False

    # Makes the game deck (also resets)
    self.reset_deck()

    # Game variables
    self.money = ["Your money: $ ", 100]  # Current money
    self.bet = 0
    self.player_value = []    # Value of player cards
    self.dealer_value = []    # Value of dealer cards

    # Who's turn it is
    self.current_phase = "get_cards"
    self.turn_delay = 1   # seconds between each dealt card
    self.start_time = 0
    self.counter = 0

    # Colors
    self.bg_color = GREEN_DARK
    self.main_color = WHITE

    # Which screen to view, title, game or rules(how-to-play)
    self.current_screen = "title" 

    # Pygame screen and logic
    self.window = Screen(title="Blackjack ver:0.1", direction=0, 
                         width=WIDTH, height=HEIGHT)
    
    

    # To keep things from becoming cluttered and to keep them organized
    self.make_game_screen()
    self.make_rules_screen()
    self.back_btn = Button(text="Back", background_color=GREEN_DARK, text_color=WHITE, border_color=WHITE, border_width=1, width=50, height=20, id="back", x=5, y=5)
    self.window.add(self.back_btn)
    self.make_title_screen()


  # Resets the deck
  def reset_deck(self):
    self.deck = DECK.copy()
    random.shuffle(self.deck)

  # Deals the fist few cards before the game begins
  def deal_first_cards(self):
    self.add_player_card()
    self.add_dealer_card()
    self.add_player_card()
    self.add_dealer_card(hidden=True)



  def run(self):
    
    # Runs the window and all the pygame logic (including buttons and other modules)
    self.window.run()

    if self.game_in_progress == True:

      if self.current_phase == "get_cards":
        if time.time() - self.start_time >= self.turn_delay:
          self.start_time = time.time()

          if self.counter == 0:
            self.add_player_card()
            self.counter += 1

          elif self.counter == 1:
            self.add_dealer_card(hidden=True)
            self.counter += 1

          elif self.counter == 2:
            self.add_player_card()
            self.counter += 1

          elif self.counter == 3:
            self.add_dealer_card()
            self.current_phase = "player"
            self.hit_btn.disabled = False
            self.stand_btn.disabled = False
            self.counter += 1

      elif self.current_phase == "dealer":
        if time.time() - self.start_time >= self.turn_delay:
          if self.dealer_table.contents[0].hidden == True:
            self.dealer_table.contents[0].hidden = False
            self.check_values()
            self.start_time = time.time()
          else:
            self.add_dealer_card()
            self.start_time = time.time()


    # If a module, such as a button, is acitvated/triggered
    if self.window.triggered == True:
      print(self.window.value)

      # When pressing start button
      if self.window.value["id"] == "start":
        self.game_in_progress = True
        self.start_btn.visible = False
        self.bet_input.disabled = True
        self.bet_input.border_width = 0
        if len(self.bet_input.text_array) == 0:
          self.bet_input.set_text("0")
        else:
          self.bet = int(''.join(str(str(item.text)) for item in self.bet_input.text_array))
          self.money[1] -= self.bet
          self.money_text.text = self.money[0] + str(self.money[1])
          self.money_text.make_text()
      
      # When pressing the hit button
      if self.window.value["id"] == "hit":
        self.add_player_card()
        self.check_values()

      # when pressing the stand button
      if self.window.value["id"] == "stand":
        self.current_phase = "dealer"
        self.hit_btn.disabled = True
        self.stand_btn.disabled = True

      if self.window.value["id"] == "reset":
        self.reset()
        
      if self.window.value["id"] == "play_game":
        self.title_screen.disabled = True
        self.game_screen.disabled = False
        self.rules_screen.disabled = True

      if self.window.value["id"] == "back":
        self.running = False


      if self.window.value["id"] == "exit":
        self.window.exit()

      if self.window.value["id"] == "rules":
        self.title_screen.disabled = True
        self.game_screen.disabled = True
        self.rules_screen.disabled = False

  # Makes all the components for the Title-screen
  def make_title_screen(self):

    self.title = Text(text="BLACKJACK", font_size=80, text_color=WHITE)

    self.play_btn = Button(text="Play Game", width=200, height=50, font_size=30, border_color=WHITE, text_color=WHITE, background_color=GREEN_DARK, id="play_game")
    self.rules_btn = Button(text="How to play", width=200, height=50, font_size=30, border_color=WHITE, text_color=WHITE, background_color=GREEN_DARK, id="rules")
    self.exit_btn = Button(text="Exit", width=200, height=50, font_size=30, border_color=WHITE, text_color=WHITE, background_color=GREEN_DARK, id="exit")
    self.title_button_wrapper = Flexbox(background_color=GREEN_DARK,contents=[self.play_btn, self.rules_btn, self.exit_btn])

    self.title_screen = Flexbox(width=WIDTH, height=HEIGHT, background_color=GREEN_DARK, contents=[self.title, self.title_button_wrapper])

    self.window.add(self.title_screen)

  # Makes all the components for the Game-screen
  def make_game_screen(self):

    # Make tables
    self.dealer_table = Flexbox(width=400, height=150, direction=0, background_color=GREEN_DARK, border_color=GREEN, border_width=2)
    self.info_dealer_value = Text(text=" 0 ", background_color=BLACK, text_color=WHITE)
    self.dealer_table_wrapper = Flexbox(width=400, height=175, contents=[self.dealer_table, self.info_dealer_value], background_color=GREEN_DARK)


    self.player_table = Flexbox(width=400, height=150, direction=0, background_color=GREEN_DARK, border_color=GREEN, border_width=2)
    self.info_player_value = Text(text=" 0 ", background_color=BLACK, text_color=WHITE)
    self.player_table_wrapper = Flexbox(width=400, height=175, contents=[self.info_player_value, self.player_table], background_color=GREEN_DARK)

    self.start_btn = Button(text="START", id="start", width=70, height=40, background_color=ORANGE, font_size=20, border_width=3)
    self.table_wrapper = Flexbox(width=410, height=450, contents=[self.dealer_table_wrapper, self.start_btn, self.player_table_wrapper], background_color=GREEN_DARK)
    
    # Make info at bottom
    self.hit_btn = Button(text="HIT", id="hit", width=70, height=40, background_color=RED, font_size=20, border_width=3, disabled=True)
    self.stand_btn = Button(text="STAND", id="stand", width=70, height=40, background_color=PURPLE_LIGHT, font_size=20, border_width=3, disabled=True)
    self.game_button_wrapper = Flexbox(width=180, height=50, direction=0, contents=[self.hit_btn, self.stand_btn], background_color=GREEN_DARK)
    self.money_text = Text(text=str(self.money[0])+str(self.money[1]), background_color=BLACK, text_color=WHITE, font_size=24, text_padding=10)

    self.bet_input = Input(background_color=BLACK, text_color=WHITE, limit="numbers", min_number=0, height=30 ,max_number=self.money[1], width=80, font_size=22, border_color=WHITE, border_width=1)
    self.bet_text = Text(background_color=BLACK, text_color=WHITE, text="Current Bet:")
    self.bet_wrapper = Flexbox(width=200, height=40, background_color=BLACK, contents=[self.bet_text, self.bet_input], direction=0)

    self.bottom_wrapper = Flexbox(width=WIDTH, height=90, background_color=GREEN_DARK, direction=0, 
                                  contents=[self.game_button_wrapper, self.bet_wrapper, self.money_text])

    # Make screen and add to main window
    self.game_screen = Flexbox(width=WIDTH, height=HEIGHT, background_color=GREEN_DARK,
                               contents=[self.table_wrapper, self.bottom_wrapper], disabled=True)
    
    self.window.add(self.game_screen)

  # Makes all the components for the Rules-screen
  def make_rules_screen(self):
    self.rules_title = Text(text="Rules of BlackJack", text_color=WHITE, font_size=40)
    self.rules_1 = Text(text="Aim to get a hand total close to 21 without going over.", text_color=WHITE)
    self.rules_2 = Text(text="Face cards are worth 10, aces are 1 or 11, others are face value.", text_color=WHITE)
    self.rules_3 = Text(text="Players get two cards and can 'hit' (take more cards) or 'stand' (keep their hand).", text_color=WHITE)
    self.rules_4 = Text(text="Going over 21 ('busting') means you lose the round.", text_color=WHITE)
    self.rules_5 = Text(text="Dealer must hit until their hand is 17 or higher.", text_color=WHITE)
    self.rules_wrapper = Flexbox(width=WIDTH, height=300, background_color=GREEN_DARK, contents=[self.rules_1, self.rules_2, self.rules_3, self.rules_4, self.rules_5])
    self.rules_screen = Flexbox(width=WIDTH, height=HEIGHT, background_color=GREEN_DARK, x=0, y=0,
                                contents=[self.rules_title, self.rules_wrapper], disabled=True)
    self.window.add(self.rules_screen)

  # Adds a card from the deck to the player table
  def add_player_card(self):

    # Take random card from deck
    rnd_card = random.choice(self.deck)
    self.deck.remove(rnd_card)
    crd = Card(number=rnd_card[2], type=rnd_card[1][0], value=rnd_card[0])

    # Add card to table
    self.player_table.add(crd)
    self.player_value.append(rnd_card[0])

    # Check value
    if sum(self.player_value) > 21:
      for index, item in enumerate(self.player_value):
        if item == 11:
          self.player_value[index] = 1
          break
    
    self.check_values()

  # Adds a card from the deck to the dealer table
  def add_dealer_card(self, hidden=False):

    # Take random card from deck
    rnd_card = random.choice(self.deck)
    self.deck.remove(rnd_card)
    crd = Card(number=rnd_card[2], type=rnd_card[1][0], value=rnd_card[0], hidden=hidden)

    # Add card to table
    self.dealer_table.add(crd)
    self.dealer_value.append(rnd_card[0])

    # Check value
    if sum(self.dealer_value) > 21:
      for index, item in enumerate(self.dealer_value):
        if item == 11:
          self.dealer_value[index] = 1
          break

    self.check_values()      
  

  # Checks the card values and checks if we win or lose
  def check_values(self):

    # Shows only the score of the visible cards
    if len(self.dealer_table.contents) > 1:
      if self.dealer_table.contents[0].hidden == True:
        self.info_dealer_value.text = str(self.dealer_value[1])
      else:
        self.info_dealer_value.text = str(sum(self.dealer_value))
    self.info_dealer_value.make_text()

    # Shows player total score
    self.info_player_value.text = str(sum(self.player_value))
    self.info_player_value.make_text()

    # Check for win/lose situations
    player_sum = sum(self.player_value)
    dealer_sum = sum(self.dealer_value)

    # Player
    if self.current_phase == "player":

      if player_sum > 21:
        print("Player busted! Dealer won!")
        self.game_over()
        self.add_money(0)

      elif player_sum == 21:
        print("Player got 21, player won!")
        self.game_over()
        self.add_money(3)
    
    if self.current_phase == "get_cards":
      if player_sum == 21:
        print("Player got 21, player won!")
        self.game_over()
        self.add_money(3)

    if self.current_phase == "dealer":
      if dealer_sum > 21:
        print("Dealer busted! Player won!")
        self.game_over()
        self.add_money(2)

      elif dealer_sum == 21 and self.dealer_table.contents[0].hidden == False:
        print("Dealer got 21, dealer won!")
        self.game_over()
        self.add_money(0)

      elif dealer_sum == player_sum and dealer_sum >= 17:
        print("It's a tie!")
        self.game_over()
        self.add_money(1)

      elif dealer_sum > player_sum and self.dealer_table.contents[0].hidden == False:
        print("Dealer's score is higher, dealer won!")
        self.game_over()
        self.add_money(0)

  # What happens when a game ends
  def game_over(self):
    self.game_in_progress = False
    self.hit_btn.disabled = True
    self.stand_btn.disabled = True
    self.start_btn.id = "reset"
    self.start_btn.text = "AGAIN"
    self.start_btn.update_text()
    self.start_btn.visible = True

  # Adds money
  def add_money(self, multiplier):
    self.money[1] += self.bet * multiplier
    self.money_text.text = self.money[0] + str(self.money[1])
    self.money_text.make_text()
    self.bet_input.set_text("")
    self.bet_input.max_number = self.money[1]

    if multiplier < 1:
      print(f"You lost your bet:({self.bet}), money left:{self.money[1]}")
    else:
      print(f"You gained {self.bet * multiplier} money!")

  # Resets the board for a new round
  def reset(self):
    
    self.start_btn.id = "start"
    self.start_btn.text = "START"
    self.start_btn.update_text()

    self.dealer_table.contents.clear()
    self.player_table.contents.clear()
    self.dealer_value.clear()
    self.player_value.clear()
    self.deck.clear()

    self.bet = 0
    self.counter = 0
    self.game_in_progress = False

    self.current_phase = "get_cards"

    self.bet_input.disabled = False
    self.bet_input.border_width = 1

    self.reset_deck()

    self.info_dealer_value.text = "0"
    self.info_dealer_value.make_text()

    self.info_player_value.text = "0"
    self.info_player_value.make_text()

    self.current_turn = "player"


if __name__ == "__main__":

    while True:
      # Creates the game
      game = BlackJack()

      # Runs the game
      while game.running == True:
        game.run()
