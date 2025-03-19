#
#
#   Oppgave 5.1 - Dictionaries og Funksjoner 
#
#
#     A) Opprett en liste med filmer (hvor hver film er en egen dictionary med dataene om én film). 
#        Dataene om en film skal minst være: name, year og rating. Legg til filmene: 
#
#           *Inception – 2010 – 8.7 
#           *Inside Out – 2015 – 8.1 
#           *Con Air – 1997– 6.9 
#
#
#     B) Opprett en funksjon som legger til en film i filmlisten. 
#        Denne funksjonen skal være definert slik at den minst tar følgende parametere: 
#
#            
#         1. Listen filmen skal legges til i:
#             -name 
#             -year 
#             -rating 
#
#        Benytt funksjonen til å legge til 3 filmer du selv bestemmer. 
#
#      C) Modifiser funksjonen fra forrige deloppgave til å sette default-ratingen 
#         til 5.0 hvis det ikke gis noen rating som argument til funksjonen. 
#         Test at dette fungerer ved å legge til en film uten å spesifisere dens rating. 
#
#
#   Oppgave 5.2 - Mer funksjoner 
#
#       Utvid forrige oppgave med noen funksjoner og benytt dem i koden din. 
#
#       A) Lag en funksjon som printer ut alle filmene i en gitt liste med 
#          filmer slik at formatet for hver filmutskrift blir seende slik ut: 
# 
#                   - The Lion King - 1994 has a rating of 8.5 
#
#       B) Lag en funksjon som tar en liste med filmer som parameter og regner ut 
#          gjennomsnittsratingen for alle filmene i lista og returnerer dette. 
#          Test funksjonen og skriv ut gjennomsnittet. 

#
#       C) Lag en funksjon som tar en liste med filmer og et årstall som parametere, 
#          og returnerer en ny liste med alle filmer fra og med det gitte årstallet. 
#          Benytt funksjonen, og print ut informasjon om alle filmer fra og med 2010 
#
#




# Opprett en liste med filmer (hvor hver film er en egen dictionary med dataene om én film). 
# Dataene om en film skal minst være: name, year og rating. 
movies = [
  {"name": "Inception", "year": 2010,  "rating": 8.7},
  {"name": "Inside Out", "year": 2015,  "rating": 8.1},
  {"name": "Con Air",    "year": 1997,  "rating": 6.9}
]

# Opprett en funksjon som legger til en film i filmlisten. 
def add_movie(list, name, year, rating=5.0):
  list.append({"name": name,    "year": year,  "rating": rating})



#  Lag en funksjon som printer ut alle filmene i en gitt 
#  liste med filmer slik at formatet for hver filmutskrift blir seende slik ut: 
def print_list(list):
  for i in list:
    print(f"{i["name"]} - {i["year"]} has a rating of {i["rating"]}")


#Lag en funksjon som tar en liste med filmer som parameter 
# og regner ut gjennomsnittsratingen for alle filmene i lista og returnerer dette
def average(list):

  # Empty list for rating values    
  temp_list = [] 

  # Adds all rating to the empty list
  for movie in list:
    temp_list.append(movie["rating"])
  
  # Returns average of all ratings rounded to two decimals
  return round(sum(temp_list) / len(temp_list), 2)


# Test at dette fungerer ved å legge til en film uten å spesifisere dens rating. 
add_movie(movies, "Frihetens regn", 1994)



#Printer ut alle filmene i en gitt liste
print_list(movies)

# Test funksjonen og skriv ut gjennomsnittet. 
print(f"The average of all movies is: {average(movies)}")


# Lag en funksjon som tar en liste med filmer og et årstall som parametere, 
# og returnerer en ny liste med alle filmer fra og med det gitte årstallet. 
def find_movies(parameter, value, list):
  temp_list = []
  for movie in list:
    if movie[parameter] == value:
      temp_list.append(movie)
  
  return(temp_list)

# Benytt funksjonen, og print ut informasjon om alle filmer fra og med 2010
print(find_movies("year", 2010, movies))



# Opprett en funksjon som tar en liste med filmer, og filnavn som parameter. 
# Benytt denne funksjonen til å skrive alle filmene i lista til en fil du selv 
# velger navnet på f.eks. "movies.txt". Hvis filen allerede eksisterer, skal den overskrives. 
# Legg gjerne til hver film som en egen linje i filen med et fint format.
def makeFile(list, filename):
  
      file = open((filename), "w")
      for item in list:
        file.write(str(item["name"]) + "\n")
      file.close()

# Lag en funksjon som leser den samme filen 
# (filnavn som input-parameter til funksjonen) 
# og skriver ut innholdet til terminalen.
def retiveFile(filename):
      temp_array = []
      file = open((filename), "r")
      for item in file:
        temp_array.append(str(item)[:-1])
      return temp_array


makeFile(movies, "movies.txt")
print(retiveFile("movies.txt"))