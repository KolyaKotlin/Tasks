abstract class Transport {
  void move();
}

class Car extends Transport {
  @override
  void move() {
    print("Машина едет.");
  }
}

class Bike extends Transport {
  @override
  void move() {
    print("Велосипед едет.");
  }
}

void task4() {
  Transport car = Car();
  Transport bike = Bike();

  car.move();
  bike.move();
}

void main() {
  task4();
}
