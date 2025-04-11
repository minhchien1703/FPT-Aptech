class Book:
    def __init__(self, title, author, year, quantity):
        self.title = title
        self.author = author
        self.year = year
        self.quantity = quantity
        self.available = quantity

    def __str__(self):
        return f"{self.title} - {self.author} ({self.year}) | Quantity: {self.quantity} | Available: {self.available}"

    def __eq__(self, other):
        return self.title.lower() == other.title.lower()

    def __hash__(self):
        return hash(self.title.lower())


library = set()

def add_book():
    title = input("Book title: ")
    author = input("Author: ")
    year = input("Publication year: ")
    quantity = int(input("Quantity: "))
    book = Book(title, author, year, quantity)

    for b in library:
        if b == book:
            b.quantity += quantity
            b.available += quantity
            print("Book quantity updated.")
            return
    library.add(book)
    print("New book added.")


def search_book():
    title = input("Enter the title to search: ")
    for book in library:
        if book.title.lower() == title.lower():
            print("Book found:")
            print(book)
            return
    print("Book not found.")


def search_available():
    title = input("Enter the title to search (available books only): ")
    for book in library:
        if book.title.lower() == title.lower() and book.available > 0:
            print("Available book found:")
            print(book)
            return
    print("No available copies found.")


def borrow_book():
    title = input("Enter the title of the book to borrow: ")
    for book in library:
        if book.title.lower() == title.lower():
            if book.available > 0:
                book.available -= 1
                print("Book borrowed successfully.")
            else:
                print("Book is currently unavailable.")
            return
    print("Book not found.")


def return_book():
    title = input("Enter the title of the book to return: ")
    for book in library:
        if book.title.lower() == title.lower():
            if book.available < book.quantity:
                book.available += 1
                print("Book returned successfully.")
            else:
                print("All copies have already been returned.")
            return
    print("Book not found.")


def get_all_books():
    for book in library:
        print(book)


def main():
    while True:
        print("\n===== LIBRARY MANAGEMENT SYSTEM =====")
        print("1. Add book")
        print("2. Search book by title")
        print("3. Search available book")
        print("4. Borrow book")
        print("5. Return book")
        print("6. Show all books in library")
        print("7. Exit")
        choice = input("Choose an option (1-7): ")

        if choice == "1":
            add_book()
        elif choice == "2":
            search_book()
        elif choice == "3":
            search_available()
        elif choice == "4":
            borrow_book()
        elif choice == "5":
            return_book()
        elif choice == "6":
            get_all_books()
        elif choice == "7":
            print("Exiting program.")
            break
        else:
            print("Invalid choice.")


if __name__ == "__main__":
    main()
