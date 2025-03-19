

from datetime import date


car_register = {
  "toyotaBZ4X": {
    "brand": "Toyota",
    "model": "Corolla",
    "price": 96_000,
    "year": 2012,
    "month": 8,
    "new": False,
    "km": 163_000
  },
  "pugeot408": {
    "brand": "Pugeot",
    "model": "408",
    "price": 330_000,
    "year": 2019,
    "month": 1,
    "new": False,
    "km": 40_000
  },
  "audiRS3": {
    "brand": "Audi",
    "model": "RS3",
    "price": 473_000,
    "year": 2022,
    "month": 2,
    "new": True,
    "km": 0
  },
} 

NEW_CAR_REGISTRATION_FEE = 8745
RENT_CAR_PERCENTAGE = 0.4
RENT_NEW_CAR__FEE = 1000


# Case 2 - Oppgave 1
# Implementer funksjonen print_car_information() som printer ut informasjon om en bil på følgende format:
#   Brand: Toyota
#   Model: Corolla  
#   Price. 96000,-
#   Manufactured: 2012-8
#   Condition: Used
def print_car_information(car):
  print(f"Brand: {car["brand"]}")
  print(f"Model: {car["model"]}")
  print(f"Price: {car["price"]},-")
  print(f"Manufactured: {car["year"]}-{car["month"]}")

  if car["new"] == False:
    print("Condition: Used")
  else:
    print("Condition: New")



# Case 2 - Oppgave 2
# Implementer funksjonen create_car() som tar forskjellig informasjon om en bil som parametere. 
# Denne skal lage en dictionary for en bil med korrekte nøkkelverdier slik som beskrevet i Case-beskrivelsen, 
# legger den inn i registeret og returner til slutt bil-dictionaryen.
def create_car(car_register, brand, model, price, year, month, new, km):
  car_register[brand + model] = {
    "brand": brand,
    "model": model,
    "price": price,
    "year": year,
    "month": month,
    "new": new,
    "km": km
  }

#Case 2 - Oppgave 3
# Implementer funksjonen get_car_age() som returnerer bilens alder fra inneværende år. 
# F.eks. Hvis bilen er fra 2019, og inneværende år er 2022, er bilen 3 år (vi bryr oss ikke om måned).
def get_car_age(car):
  current_date = date.today()
  car_age = current_date.year -  car["year"]
  return car_age


# Case 2 - Oppgave 4
# Implementer funksjonen rent_car_monthly_price() som returner månedsprisen for 
# å leie en bil (prisen skal være avrundet til 2 desimaler). 
# Den årlige prisen er 40% av totalprisen av bilen. 
# Hvis bilen er ny, skal det også legges til en påslag på 1000kr i måneden.
def rent_car_monthly_price(car):
  price_for_year = car["price"] * 0.4
  if car["new"] == True:
    price_for_year += 1000*12
  return round(price_for_year / 12, 2)


# Case 2 - Oppgave 5
# Implementer funksjonen next_eu_control() som returnerer et dato-objekt for neste EU-kontroll. 
# EU-kontrollen skal skje hver 2. år, fra året og måneden bilen ble produsert. 
# Det er OK om man setter den 1. i måneden i dato-objektet man returnerer.
def next_eu_control(car):
  current_date = date.today()
  year = car["year"]
  while year < current_date.year:
    year += 2
  
  if car["month"] < current_date.month:
    year += 2

  return date(year, car["month"], 1)


# Case 2 - Oppgave 6
# Implementer funksjonen calculate_total_price() som returnerer totalprisen til bilen. 
# I dette systemet er totalprisen prisen på bilen pluss en avgift. 
# Avgiften for nye biler er 10783kr uavhengig av alder på bilen. 
# Er bilen en bruktbil gis avgiften basert på tabellen under.
#
# Alder på bil |	Avgift i kr
# 0-3 	       |  6681
# 4-11         |	4034
# 12-29        |	1729
# 30+ (veteran)| 	0
#
# Forsøk å gjøre data fra denne tabellen gjenbrukbar.
def calculate_total_price(car):

  car_charges = {
    "30":0,
    "29":1729,
    "11":4034,
    "3":6681
  }

  if car["new"] == True:
    return car["price"] + 10783
  else:
    car_age = get_car_age(car)

    for age in car_charges:
      if int(age) <= car_age:
          return car["price"] + car_charges[age]


def is_new(car):
  return car['new']




# Case 2 - Oppgave 7
# Basert på informasjonen om en bil som finnes i car_register-dictionarien, 
# lag en klasse som skal kunne holde på informasjonen om en bil isteden.
#
# Legg også til metode-definisjonene (ikke implementasjon) for de funksjonene som er definert i del 3 av eksamen, 
# som du mener kunne passe inn i denne klassen isteden. Begrunn kort hvorfor.
class Car():
  def __init__(self, brand, model, price, year, month, new, km):
    self.brand = brand
    self.model = model
    self.price = price
    self.made_date = date(year, month)
    self.new = new
    self.km = km

    self.total_price = self.get_total_price()
    self.monthly_rent_price = self.get_monthly_rent_price()

  def print_car_information(self):
    pass
  
  def get_total_price(self):
    pass

  def get_monthly_rent_price(self):
    pass

  def next_eu_control(self):
    pass





if __name__ == '__main__':

  create_car(car_register, "Volvo", "V90", 850_000, 2021, 12, True, 0)

  toyota = car_register['toyotaBZ4X']
  print_car_information(toyota)
  print(f"\nThe total price for this {toyota['brand']} {toyota['model']} is {calculate_total_price(toyota)}kr.")
  print(f"Next EU-control for the {toyota['brand']} {toyota['model']} is {next_eu_control(toyota)}")
  print(f"If you want to rent the {toyota['brand']} {toyota['model']} the monthly fee will be {rent_car_monthly_price(toyota)}.")


  audi = car_register['audiRS3']
  print_car_information(audi)
  print(f"\nThe total price for this {audi['brand']} {audi['model']} is {calculate_total_price(audi)}kr.")
  print(f"Next EU-control for the {audi['brand']} {audi['model']} is {next_eu_control(audi)}")
  print(f"If you want to rent the {audi['brand']} {audi['model']} the monthly fee will be {rent_car_monthly_price(audi)}kr.")
