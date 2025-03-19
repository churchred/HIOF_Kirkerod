#------------------------------------------
#Oppgaver
#------------------------------------------




#Case 1 - Oppgave 1
#
# Skriv en funksjon som printer ut informasjon om en vare på følgende format:
#
# Name: Example Ware
# Price: 3999,-
# Number in stock: 30
#
# Description: A non-existent ware used only for this example.
# Funksjonen skal hete print_ware_information() og skal ta én parameter:
#   - ware - En varereferanse - dictionary
def print_ware_information(ware):
    '''Funksjonsbeskrivelse: Printer ut informasjon om en spesifisert vare.'''
    print(f"Name: {ware["name"].title()}")
    print(f"Price: {ware["price"]}")
    print(f"Number in stock: {ware["number_in_stock"]}")





# Case 1 - Oppgave 2
# Skriv en funksjon som returnerer den gjennomsnittlige ratingen (en float verdi med én desimal) for en gitt vare. 
# Det vil si summen av alle ratingene for denne varen delt på antallet ratinger. Bemerk at hvis listen er tom, 
# vil denne utregningen føre til en ZeroDivisionError.
# Funksjonen skal hete calculate_average_ware_rating() og skal ta minst én parameter: 
#       - ware - En varereferanse - dictionary
def calculate_average_ware_rating(ware):
    # Returnerer den gjennomsnittlige ratingen for en spesifisert vare.
    if len(ware["ratings"]) == 0:
        return 0
    else:
        average = sum(ware["ratings"]) / len(ware["ratings"])
        return average



# Case 1 - Oppgave 3
# Skriv en funksjon som returnerer en dictionary med alle varer som er på lager. 
# Den returnerte dictionarien skal følge samme format som vareregisteret i webshop_frontent.py (all_wares-variabelen).
# Funksjonen skal hete get_all_wares_in_stock() og skal ta minst én parameter: 
#    - all_wares - Et vareregister – dictionary 
def get_all_wares_in_stock(all_wares):
    # Returnerer en dictionary med alle varer som er på lager.
    wares_in_stock = {}

    for item_name in all_wares:
        if all_wares[item_name]["number_in_stock"] > 0:
            wares_in_stock[item_name] = all_wares[item_name]
    
    return wares_in_stock




# Case 1 - Oppgave 4
# Skriv en funksjon som returnerer en Boolean-verdi som representerer om et spesifisert antall av en gitt vare finnes på lager. 
# Denne funksjonen skal hete is_number_of_ware_in_stock() og skal minst ta to parametere: 
#    - ware - En varereferanse - dictionary
#    - number_of_ware - Antallet av denne varen - int  
def is_number_of_ware_in_stock(ware, number_of_ware):
    # Returnerer en Boolean-verdi som representerer om et spesifisert antall av en gitt vare finnes på lager.
    if ware["number_in_stock"] >= number_of_ware:
        return True
    else:
        return False



# Case 1 - Oppgave 5
#
# Skriv en funksjon som legger til en vare med et gitt antall i en "handlevogn" i form av en dictionary. 
# Ta utgangspunkt i at handlevogn-dictionarien er/skal være på følgende format: 
#
# { <varenøkkel 1>: <antall av vare i handlevognen>, <varenøkkel 2>: <antall av vare i handlevognen>,etc.} 
#
# Det skal kontrolleres at antallet av den gitte varen som forsøkes å legges til i handlevognen faktisk er på lager. 
# Hvis det fulle antallet ikke er tilgjengelig, men varen ellers er på lager, skal det tilgjengelige antallet på lager legges til.
#
# Lag fornuftige utskrifter der du mener det kan være nyttig for brukeren å få informasjon om hva som skjer.
#
# Denne funksjonen skal hete add_number_or_ware_to_shopping_cart() og skal ta minst fire parametere: 
#       ware_key - En varenøkkel - string
#       ware - En varereferanse - dictionary
#       shopping_cart - En handlevogn - dictionary
#       number_of_ware - Antallet av varen - int (standardverdi skal være 1)
def add_number_of_ware_to_shopping_cart(ware_key, ware, shopping_cart, number_of_ware=1):
    # Legger til et spesifisert antall av en gitt vare i en spesifisert handlevogn.

    # Are we out of that item?
    if ware["number_in_stock"] == 0:
        print(f"Sorry we are out of {ware["name"]}")
        return

    # Do we have it already?
    if ware_key in shopping_cart:
        shopping_cart[ware_key] += number_of_ware
        print("Shopping cart updated!")
    else:
        shopping_cart[ware_key] = number_of_ware
        print(f"Added {ware["name"]} to the shopping cart")

    # Did we add more than we have avaliable?
    if shopping_cart[ware_key] > ware["number_in_stock"]:
        shopping_cart[ware_key] = ware["number_in_stock"]
        print(f"Sorry, we don't have {ware["number_in_stock"]} left in stock of the item: {ware["name"]}.")
        print(f"{ware["number_in_stock"]} {ware["name"]} added to shopping cart instead!")





# Case 1 - Oppgave 6
# Skriv en funksjon som returnerer prisen (med skatt) av en gitt handlevogn.
# Ta fortsatt utgangspunkt i at handlevogn-dictionarien er på følgende format: 
# { <varenøkkel 1>: <antall av vare i handlevognen>, 
#   <varenøkkel 2>: <antall av vare i handlevognen>,
#   etc.} 
# 
# Denne funksjonen skal hete calculate_shopping_cart_price() og skal minst ta tre input-parametere: 
#       shopping_cart - En handlevogn - dictionary 
#       all_wares - Et vareregister - dictionary 
#       tax - En skatteprosent - float (standardverdi for skatteprosent skal være 25%) '
def calculate_shopping_cart_price(shopping_cart, all_wares, tax):
    # Returnerer prisen av en handlevogn basert på varene i den.
    total_price = 0

    for cart_item_name in shopping_cart:
        total_price += all_wares[cart_item_name]["price"] * shopping_cart[cart_item_name]

    return total_price * tax



def can_afford_shopping_cart(shopping_cart_price, wallet):
    # Returnerer en Boolean-verdi basert på om det er nok penger i en gitt lommebok for å kjøpe en handlevogn.
    pass

def buy_shopping_cart():
    # Kjøper varene i en handlevogn. Parameterene defineres i oppgaven.
    pass





#------------------------------------------
# Predefinerte funksjoner
#------------------------------------------

def is_ware_in_stock(ware):
    # Returnerer en Boolean-verdi som representerer om en vare er på lager.
    if ware["number_in_stock"] >= 1:
        return True
    else:
        return False
    
def clear_shopping_cart(shopping_cart):
    # Tømmer en handlevogn.
    shopping_cart.clear()