#
# Oppgave 2:
#
#     Lag 3 variabler.
#          - En som inneholder fornavnet ditt
#          - En som inneholder etternavnet ditt
#          - En som inneholder alderen din i heltall
#
#     Benytt så de oprettede variablene til å skrive ut en
#     streng med dette formatet: "Hei. Jeg heter (fornavnet ditt) (etternavnet ditt)
#     og er (alderen din) år gammel"


# We import this to find the current date
import datetime

# We find the current year
current_year = (datetime.date.today()).year


first_name = "kristoffer"  # My first name
last_name = "kirkerød"     # My last name
age = current_year - 1996  # My age, calculated by subtracting my year of birth from the current year

# Prints the answer
print(f"Hei. Jeg heter {first_name.title()} {last_name.title()} og er {age} år gammel")