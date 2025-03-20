class Book {
  String title;
  String author;
  int year;

  Book(this.title, this.author, this.year);
}

class Library {
  List<Book> books = [];

  void addBook(Book book) {
    books.add(book);
  }

  void searchByAuthor(String author) {
    books.where((book) => book.author == author).forEach((book) {
      print("Книга: ${book.title}, Автор: ${book.author}, Год: ${book.year}");
    });
  }

  void searchByYear(int year) {
    books.where((book) => book.year == year).forEach((book) {
      print("Книга: ${book.title}, Автор: ${book.author}, Год: ${book.year}");
    });
  }
}

void task5() {
  Library library = Library();
  library.addBook(Book("Девушка в поезде", "Пола Хокинс", 2015));
  library.addBook(Book("1984", "Джордж Оруэлл", 1949));

  library.searchByAuthor("Пола Хокинс");
}

void main() {
  task5();
}
