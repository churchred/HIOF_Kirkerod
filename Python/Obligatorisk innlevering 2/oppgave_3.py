#
#   Opprett en liste med Tolkien sine bøker: 
#        - The Hobbit 
#        - Farmer Giles of Ham
#        - The Fellowship of the Ring,
#        - The Two Towers
#        - The Return of the King
#        - The Adventures of Tom Bombadil,
#        - Tree and Leaf 
#
#   1) Skriv ut de to første og de to siste bøkene i listen.
#
#   2) Legg til to av bøkene som ble utgitt etter hans død: 
#         - The Silmarillion 
#         - Unfinished Tales  
#
#   3) Gjør endringer på de tre bøkene i Lord of the Rings trilogien 
#      og legg til "Lord of the Rings: " foran hver av dem. 
#      (hvis dere ikke vet hvilke dette er, vet Google) 
#
#   4) Sorter lista og skriv den ut. 
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


# 1) Skriv ut de to første og de to siste bøkene i listen.
print(f"First item: {book_list[0]}")
print(f"Second item: {book_list[1]}")
print(f"Second to last item: {book_list[-2]}")
print(f"Last item: {book_list[-1]}")

# 2) Legg til to av bøkene som ble utgitt etter hans død (The Silmarillion / Unfinished Tales)
book_list.extend(("The Silmarillion", "Unfinished Tales"))


# 3) Gjør endringer på de tre bøkene i Lord of the Rings trilogien 
for index, book in enumerate(book_list):
  if book in lord_of_the_rings:
    book_list[index] = "Lord of the Rings: " + book


# 4) Sorter lista og skriv den ut. 
book_list.sort()
print(book_list)






