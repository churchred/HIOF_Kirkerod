#
#
#     Oppgave 3 – Funksjon – Printe liste 
#
#
#       Definer en funksjon som heter print_list(). 
#
#       Denne funksjonen skal ta i mot en liste som parameter, og printe ut hvert element i denne listen en etter en.
#  
#       Lag deretter kort liste med dine 3 favorittmatretter, og kall funksjonen din med denne listen som parameter.
#
#
#



# Definer en funksjon som heter print_list(). 
def print_list(list):
  for row in list:
    print(row)

# Lag deretter kort liste med dine 3 favorittmatretter
my_food_list = [
  "Pizza",
  "Sushi",
  "Taco"
]

# Kall funksjonen din med listen som parameter.
print_list(my_food_list)