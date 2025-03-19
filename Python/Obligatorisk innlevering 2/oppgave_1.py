#
#
#
#  Oppgave 1 - If og else 
#
#  Ta et tall fra brukeren på følgende måte:
#     input("Hva er svaret på det ultimate spørsmålet om livet, 
#            universet og alle ting? Hint: Det er et tall.")
#
#  Konverter inputen til int og lag en if-test som sjekker om verdien er lik 42. 
#
#  Hvis dette er tilfellet, skriv ut:
#       "Det stemmer, meningen med livet er 42!", hvis ikke; skriv ut "FEIL!". 
#
#  Legge til én ekstra sjekk i denne if-testen som sjekker om input-tallet er mellom 30 og 50, 
#  altså større enn 30 og mindre enn 50 på samme tid (hint: logiske operatorer). 
#
#  Hvis dette er tilfellet, skriv ut "Nærme, men feil." 



import time, sys, os

WIDTH = 100
HEIGHT = 20

# A list of colors to use in command window
# Example: print(RED + "Hey" + RESET), makes "Hey" in red color. 
# While print(RED + "Hey") makes not only "hey" red, but also EVERY print after
RED    = '\33[31m'
GREEN  = '\33[32m'
YELLOW = '\033[33m'
RESET  = '\33[0m'

# Makes the screen a different size
cmd = 'mode ' + str(WIDTH) + ", " + str(HEIGHT)
os.system(cmd)

# Makes the text we want to print
question = "Hva er svaret på det ultimate spørsmålet om livet, universet og alle ting?"
hint = " Hint: Det er et tall."


# Prints the given string, either one letter at the time or normally
def print_text(string, animation=False, delay=0):

  if animation == True:

    # Prints the string one letter at the time, with a delay of 0.05s between each
    # I use sys.stdout instead of print, because os.system('cls'), causes stuttering and is slow
    for i in range(len(string)):
      sys.stdout.write("\r" + (string[0:i+1]).center(WIDTH))
      sys.stdout.flush()
      time.sleep(delay)

  else:
    print((string).center(WIDTH))



# Handles the getting the user input
def get_input():
  try:

    # Gets the user input
    user_input = int(input("Svar: ".rjust(int(WIDTH/2)+2)))
    return user_input

  # What happens if an error is detected
  except Exception as e:
    os.system('cls')

    # Prints error warning in RED
    print('\n')
    print(RED)
    print_text("Not a valid number", animation=True, delay=0.1)
    print('\n')
    print_text("Try again", animation=True, delay=0.1)
    print(RESET)
    

    # Waits 1.5s and prints the question again, no animation this time.
    time.sleep(1.5)
    os.system('cls')

    app(animation=False)

# The logic for the app itself, in a function to make repeating easier
def app(animation = False):

  # Adds a space between the question and the top of the screen
  print('\n')

  # Prints the question one letter at the time or normally
  if animation == True:
    print_text(question, animation=True, delay=0.05)
  else:
    print_text(question)


  # Adds a space between the question and the hint
  print('\n')

  # Prints the hint one letter at the time or normally
  if animation == True:
    print_text(hint, animation=True, delay=0.05)
  else:
    print_text(hint)

  # Adds spaces between the question/hint and the input field
  print('\n\n')

  # Gets the user input and handles the logic
  user_input = get_input()

  print('\n')

  if user_input == 42:
    os.system('cls')
    print('\n\n')
    print(GREEN)
    print_text("Det stemmer, meningen med livet er 42!", animation=True, delay=0.1)
    print(RESET)
    time.sleep(4)


  elif user_input > 30 and user_input < 50:
    os.system('cls')
    print('\n\n')
    print(YELLOW)
    print_text("Nærme, men feil.", animation=True, delay=0.1)
    print(RESET)
    time.sleep(3)
    os.system('cls')
    app()

  else:
    os.system('cls')
    print('\n\n')
    print(RED)
    print_text("FEIL!", animation=True, delay=0.1)
    print(RESET)
    time.sleep(2)
    os.system('cls')
    app()



app(animation=True)