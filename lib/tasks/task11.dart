class Product {
  String name;
  double price;
  int quantity;

  Product(this.name, this.price, this.quantity);
}

class Store {
  List<Product> products = [];

  void addProduct(Product product) {
    products.add(product);
    print("Товар добавлен: ${product.name}");
  }

  void removeProduct(String name) {
    products.removeWhere((product) => product.name == name);
    print("Товар удален: $name");
  }

  void searchProduct(String name) {
    products.where((product) => product.name == name).forEach((product) {
      print("Найден товар: ${product.name}, Цена: ${product.price}, Количество: ${product.quantity}");
    });
  }
}

void task11() {
  Store store = Store();
  store.addProduct(Product("Хлеб", 1.5, 100));
  store.addProduct(Product("Молоко", 2.0, 50));
  store.searchProduct("Хлеб");
  store.removeProduct("Молоко");
}
