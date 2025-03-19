#
#
#     Oppgave 2 – Funksjon - Tallgenerering 
#
#
#     Definer en funksjon som lager en fin utskrift med et 
#     tilfeldig generert tall mellom 0 og 100.
#     Funksjonen skal ikke ta noen parametere. 
# 
#     Eksempelutskrift: 
#
#         ********
#
#         ***97*** 
#
#         ********
#

import os, time, random


# Screen size
WIDTH = 40
HEIGHT = 10

# Makes the screen a different size
CMD = 'mode ' + str(WIDTH) + ", " + str(HEIGHT)
os.system(CMD)


# Makes a list with rows equal to the visible print height of terminal
window = ["" for i in range(HEIGHT-1)]



# Definer en funksjon som lager en fin utskrift
def make_numbers():

  delta_time = 0.2 # How fast the terminal updates in seconds
  counter = 0      # Counter for how often we add a number
  max_count = 5    # Counter's max value

  while True:

    # Increase the counter by 1
    counter += 1

    # If the counter reaches the maximum value, 
    # we add a new number to the list and reset counter
    if counter == max_count:
      
      # Reset counter
      counter = 0 
      
      # Chooses a random row in the list to add a new number
      random_row = random.randint(0, len(window)-1)  

      # Makes a random number
      random_number = str(random.randint(0, 100))

      # Removes the first few characters, based on length of new number
      window[random_row] = window[random_row][len(random_number):]

      # Adds new number to start of string
      window[random_row] = random_number + window[random_row]
      

    # Adds a space to each row in the list
    # Removes any part of string longer than the terminal width
    for i in range(len(window)):
      window[i] = " " + window[i]
      if len(window[i]) >= WIDTH:
        window[i] = window[i][:WIDTH]
        

    # Clears the terminal
    os.system('cls')

    # Prints the rows onto the terminal
    for row in window:
      print(row)

    # Delay before we repeat
    time.sleep(delta_time)



# Calls the function
make_numbers()