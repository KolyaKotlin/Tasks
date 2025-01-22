class Animal {
  void move() {}
}

class Fish extends Animal {
  @override
  void move() {
    print("Рыба плавает.");
  }
}

class Bird extends Animal {
  @override
  void move() {
    print("Птица летает.");
  }
}

class Dog extends Animal {
  @override
  void move() {
    print("Собака бегает.");
  }
}

void task9() {
  List<Animal> animals = [Fish(), Bird(), Dog()];

  for (var animal in animals) {
    animal.move();
  }
}

void main() {
  task9();
}
