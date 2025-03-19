

menu = {
    "Ribbe" : 145.90,
    "Pinnekjøtt" : 155.90,
    "Lutefisk" : 135.90,
    "Nøttestek" : 135.90,
    "Reinsdyrstek" : 155.90
}


def display_menu_item(dict, item):
    print(f"{item} - {dict[item]} kr")

display_menu_item(menu, "Ribbe")

def place_order(ribbe=2, pinne=0, lute=0, nut=0, rein=0):
    order = {
        "Ribbe" : ribbe,
        "Pinnekjøtt" : pinne,
        "Lutefisk" : lute,
        "Nøttestek" : nut,
        "Reinsdyrstek" : rein
        }
    
    if rein != 0:
        print("Buhuu")

    return order

order = place_order()

def calculate_total(menu, order):
    total_sum  = 0

    for item in order:
        total_sum += menu[item] * order[item]
    
    return(total_sum)



def display_cost(menu, order):
    for item in order:
        if order[item] > 0:
            print(f"{item} - ({order[item]}) - {menu[item] * order[item]} kr")


display_cost(menu, order)



def confirm_order(order_cost):
    
    print(f"Your total price is: {order_cost} kr")
    inp = input("Bekreft bestilling (yes/no)")

    if inp == "yes": 
        print("Rudolf er grønn på nesen!")
        return True
    else:
        print("Rudolf er rød på nesen")
        return False

confirm_order(calculate_total(menu, order))


order_history = []
def record_order(history_list, order):
    history_list.append(order)

import json
def save_order_to_file(file_name, order):
    with open((file_name), "w") as new_order:
        json.dump(order, new_order)

def load_order_from_file(file_name):
    try:
        with open((file_name), "w") as new_order:
            data = json.load(new_order)
        return data
    except FileNotFoundError:
        print("Fant ikke filen!")

