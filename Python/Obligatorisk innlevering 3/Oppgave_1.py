#
#   Oppgave 1 - Dictionaries 
#
#   Lag en dictionary med informasjon om en student: 
#
#     student = { 
#       "first name" : "Ola", 
#       "last name" : "Nordmann,
#       "favourite course" : "Programmering 1" 
#     } 
#
#
#     1. Skriv ut studentens fullstendige navn (fornavn og etternavn). 
#
#     2. Programmatisk endre studentens favorittkurs til å inkludere kursets emnekode: "ITF10219 Programmering 1"
#
#     3. Programmatisk legg til en alder for studenten i dictionarien. Du kan selv velge hva alderen skal være.




# Lager en dictionary med student informasjon
student = { 
  "first name" : "Ola", 
  "last name" : "Nordmann",
  "favourite course" : "Programmering 1" 
  } 


# 1. Skriv ut studentens fullstendige navn (fornavn og etternavn). 
print(f"Navnet til studenten er {student["first name"]} {student["last name"]}")



# 2. Programmatisk endre studentens favorittkurs til å inkludere kursets emnekode: "ITF10219 Programmering 1"
student["favourite course"] = "ITF10219 " + student["favourite course"]
print(student["favourite course"])


# 3. Programmatisk legg til en alder for studenten i dictionarien. Du kan selv velge hva alderen skal være.
student.update({"age": 28})
print(student)