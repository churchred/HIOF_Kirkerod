#
#
#
#   Oppgave 1 - Klasser og objekter
#     A)
#         Opprett en klasse for filmer med inneholder instansvariabler for filmtittel, utgivelsesår og score.  
#         Bruk denne klassen til å opprette et objekt for hver av de følgende filmene: 
#
#                Inception -    Utgivelsesår: 2010, Score: 8.8
#                The Martian -  Utgivelsesår: 2015, Score: 8.0 
#                Joker -        Utgivelsesår: 2019, Score: 8.4 
# 
#         Skriv ut all informasjon om hver film med formatet; "<title> was released in <year> and currently has a score of <score>", 
#         ved å benytte de opprettede objektene. 
#    
#     B) Metoder 
#
#         Opprett en metode i filmklassen som returnerer en tekststreng med all informasjon om en gitt film på samme format som i forrige deloppgave. 
#         Igjen, skriv ut all informasjon om filmobjektene opprettet i forrige deloppgave, men denne gangen ved å benytte den nylig opprettede metoden. 
#



# Opprett en klasse for filmer med inneholder instansvariabler for filmtittel, utgivelsesår og score
class Film():
  def __init__(self, name, year, score):
    
    self.name = name
    self.year = year
    self.score = score
  
  # Opprett en metode i filmklassen som returnerer en tekststreng med all informasjon om en gitt film på samme format som i forrige deloppgave.
  def text_print(self):
    return(f"{self.name} was released in {self.year} and currently has a score of {self.score}.")
  



# Bruk denne klassen til å opprette et objekt for hver av de følgende filmene: 
movie_1 = Film("Inception", 2010, 8.8)
movie_2 = Film("The Martian", 2015, 8.0)
movie_3 = Film("Joker", 2019, 8.4)

# Skriv ut all informasjon om hver film med formatet; "<title> was released in <year> and currently has a score of <score>"
print(f"{movie_1.name} was released in {movie_1.year} and currently has a score of {movie_1.score}.")
print(f"{movie_2.name} was released in {movie_2.year} and currently has a score of {movie_2.score}.")
print(f"{movie_3.name} was released in {movie_3.year} and currently has a score of {movie_3.score}.")


# Skriv ut all informasjon om filmobjektene opprettet i forrige deloppgave, men denne gangen ved å benytte den nylig opprettede metoden.
print(movie_1.text_print())
print(movie_2.text_print())
print(movie_3.text_print())