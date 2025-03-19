#
# Oppgave 3:
#
#     Lag en mini-kalkulator
#
#     Ta to tall som input fra brukeren på en fornuftig måte.  
#     Basert på de to tallene, skriv ut resultatet av samtlige av de følgende operatorene
#     (Det holder med å skrive ut alle operasjonene etter hverandre, 
#     men det er jo alltids lov å gjøre det mer komplisert hvis man vil)
#
#          * (gange) 
#          / (dele) 
#          + (pluss) 
#          - (minus)  
#          % (modulo) 
#          ** (opphøye) 
#          // (dele med nedrunding) 



import os   # To reset/clean the command window each time we use the app
import re   # To help split the user equation

# A list of colors to use in command window
# Example: print(RED + "Hey" + RESET), makes "Hey" in red color. 
# While print(RED + "Hey") makes not only "hey" red, but also EVERY print after
RED    = '\33[31m'
GREEN  = '\33[32m'
BOLD   = '\33[1m'
RESET  = '\33[0m'

# Screen size
WIDTH = 50
HEIGHT = 15

# Changes the size of the cmd window
cmd = 'mode ' + str(WIDTH) + ", " + str(HEIGHT)
os.system(cmd)

# Fucntion that prints the error screen we use.
# It is in its own function because we need to call it
# even when no proper error has occured
def print_error(e):
# We clear the screen so the error can be printet alone
    os.system('cls')

    # Then we print the Error message in RED, and center everything
    # We print the actual error message as "e", and the original user input as "user_input"
    print('\n')
    print((RED + "Error! " + str(e) + ": " + RESET).center(WIDTH+len(RED)+len(RESET)))
    print((RED + user_input + RESET).center(WIDTH+len(RED)+len(RESET)))
    print('\n')
    print((RED + "Use only" + BOLD + " two " + RESET + RED + "numbers and" + BOLD + " ONE " + RESET + RED + "operator" + RESET).center(WIDTH+len(RED)*3+len(RESET)*3+len(BOLD)))
    print((RED + "Example: 2+2" + RESET).center(WIDTH+len(RED)+len(RESET)))
    print('\n')
    print("Press enter to try again".center(WIDTH))
    input("")


# We put everything in a loop so we can repeat without closing the aplication.
while True:

  # Clears the screen to keep it from cluttering
  os.system('cls') 

  # The varibel than will contain the answer
  answer = None

  # Prints the question. 
  # '\n' is for itself to not mess with the center function
  print("\n\n")  
  print("Skriv inn et regnestykke".center(WIDTH))
  print("\n\n")

  # Gets the equation from the user
  user_input = input("§ ".rjust(int(WIDTH/3)))

  # Before we handle the data we put it into a try function,
  # just in case the user gave us invalid perameters
  try: 

    # We remove all spaces from the input
    equation = user_input.replace(" ", "")

    # We sort out the numbers and the operator  
    # Will look like this  -->  equation = [['', '+', ''], ['2', '2']]
    equation = [re.split('\d+', equation), re.findall('\d+', equation)]

    # We check if the operator in the given user-equation matches any of our cases.
    # If it does we do the appropriate calculation. 
    # If no match is found then we must have used an operator outside the bounds, and an error will be printed
    if equation[0][1] == "+":
      answer = int(equation[1][0]) + int(equation[1][1])

    elif equation[0][1] == "-":
      answer = int(equation[1][0]) - int(equation[1][1])

    elif equation[0][1] == "*":
      answer = int(equation[1][0]) * int(equation[1][1])

    elif equation[0][1] == "**":
      answer = int(equation[1][0]) ** int(equation[1][1])

    elif equation[0][1] == "%":
      answer = int(equation[1][0]) % int(equation[1][1])

    elif equation[0][1] == "/":
      answer = round((int(equation[1][0]) / int(equation[1][1])), 2)

    elif equation[0][1] == "//":
      answer = int(equation[1][0]) // int(equation[1][1])
    
    else:
      print_error("Not valid operation")

    if answer != None:
      # Clears the screen to present answer
      os.system('cls')

      # prints the answer with the color green, and centers everything
      print("\n")
      print((GREEN + "Svar" + RESET).center(WIDTH+len(GREEN)+len(RESET)))
      print("\n")
      print(f"{equation[1][0]} {equation[0][1]} {equation[1][1]} = {answer}".center(WIDTH))
      input("")

  # If an error is caught/detected this happens
  except Exception as e:
    print_error(e)
  

