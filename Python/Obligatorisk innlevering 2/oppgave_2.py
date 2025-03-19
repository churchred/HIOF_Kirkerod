#
#
#  Oppgave 2:
#    Skriv et program som skriver ut alle oddetall fra og med 9 til 101. 
#    Lag to alternativer for programmet; en hvor du benytter en for-løkke og hvor du benytter en while-løkke. 
#
#


# For loop that prints odd numbers from 9 to 100
print("For-løkke:")
for i in range(9, 101):
  if i % 2 != 0:
    print(i)


# While loop that prints odd numbers from 9 to 100
print('\nWhile-løkke:')
i = 0
while i < 101:
  if i % 2 != 0:
    print(i)
  i += 1


