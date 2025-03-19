# 
# Oppgave 5 - Småkaker: 
#
#     Det følgende er en oversikt over hvor mange småkaker fem forskjellige personer har spist over en uke: 
#
#          Person 1: 5 småkaker 
#          Person 2: 9 småkaker 
#          Person 3: 2.5 småkaker 
#          Person 4: 21 småkaker 
#          Person 5: 0 småkaker 
#
#     Beregn det gjennomsnittlige antall spiste småkaker ved å benytte variabler og operatorer. Skriv ut svaret som datatypen, int.  
#
#     Gjennomsnittet er beregnet ved å dele det totale antall spiste småkaker på antallet personer.
#     Benytte gjerne også en egen variabel for å representere antallet personer.  
#
#     Det riktige svaret av utregningen er 7.  



# A list with how much each person ate
data = [
  5, 9, 2.5, 21, 0
]

# The total value of cookies
total_value = sum(data)

# Calculate the average, by dividing the total by the number of people
average = int(total_value / len(data))

# Prints answer
print(f"Gjennomsnitt: {average}")
