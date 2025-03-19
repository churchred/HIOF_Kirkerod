#
#
#
#   Oppgave 4 – Funksjon – Volum
#
#     
#     Lag en funksjon for å regne ut volumet av et tredimensjonalt objekt. 
#
#     Vi lar ting være enkelt og forholder oss bare til enkle verdier for lengde, bredde og høyde. 
#
#     Volumet kan da beregnes med følgende formel: lengde*bredde*høyde. 
#
#     Du skal ta lengden, bredden og høyden som individuelle input-parametere for funksjonen, og returnere volumet. 
#
#     Kall funksjonen noen ganger med forskjellige verdier for lengde, bredde og høyde, og skriv ut resultatet av hver utregning.
# 
#


# import random
import random

# Function for finding the Volum
def volume(b, h, l):
  return b*l*h

# Make 10 different, random values for height, length, width,
# and send them into the volume function.
for i in range(10):
  rand_nr = [random.randint(1, 50) for _ in range(3)]
  print(f" The volume is: {volume(rand_nr[0], rand_nr[1], rand_nr[2])}m\u00B3")