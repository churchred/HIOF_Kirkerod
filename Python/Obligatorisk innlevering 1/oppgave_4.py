# 
# Oppgave 4 - Regnestykker: 
#
#     Lag tre variabler: 
#         a = 6, 
#         b = 3, 
#         c = 2.
#  
#     Lag et program som regner ut resultatene av følgende regnestykker og skriver ut svaret. 
#
#     a) a + b * c 
#     b) (a + b) * c 
#     c) a / b / c 
#     d) a / (b / c) 


# First we define the values of a, b, c
a, b, c = 6, 3, 2

# Then we make a list with the equation, and the answer to said equation
answers = [
  [f"{a} + {b} * {c} =",     a + b * c], 
  [f"({a} + {b}) * {c} =",   (a + b) * c],
  [f"{a} / {b} / {c} =",     a / b / c], 
  [f"{a} / ({b} / {c}) =",   a / (b / c)] 
]

# We loop through the list and print the equation and the answer to each
print(f"a={a}, b={b}, c={c} \n")
for row in answers:
  print(row[0], row[1])