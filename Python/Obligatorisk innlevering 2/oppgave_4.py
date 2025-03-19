#
#  Oppgave 4 - Iterere gjennom en liste 
#
#     Opprett en tom liste. 
#
#     Gå gjennom listen med bøker fra Oppgave 3 og legg dem til i den tomme listen hvis de er i Lord of the Rings-trilogien. 
#
#     Skriv så ut innholdet i den nye lista ved hjelp av en for-løkke. 
#
#     Det er flere måter man kan skrive en for-løkke på, forsøk å demonstrere et par forskjellige i denne oppgaven. 
#
#


# List of all books
book_list = [
    "The Hobbit",
    "Farmer Giles of Ham",
    "The Fellowship of the Ring",
    "The Two Towers",
    "The Return of the King",
    "The Adventures of Tom Bombadil",
    "Tree and Leaf"
]


# List of lord of the rings main trilogy books
lord_of_the_rings = [
    "The Fellowship of the Ring",
    "The Two Towers",
    "The Return of the King"
]


# Opprett en tom liste. 
empty_list = []

# Gå gjennom listen med bøker fra Oppgave 3 og 
# legg dem til i den tomme listen hvis de er i Lord of the Rings-trilogien. 
empty_list = [book for book in book_list if book in lord_of_the_rings]


# Skriv så ut innholdet i den nye lista ved hjelp av en for-løkke. 
for book in empty_list:
  print(book)
