class Counter {
  static int _count = 0;

  Counter() {
    _count++;
  }

  static int getCount() {
    return _count;
  }
}

void task7() {
  Counter c1 = Counter();
  Counter c2 = Counter();
  Counter c3 = Counter();

  print("Количество объектов: ${Counter.getCount()}");
}

void main() {
  task7();
}
