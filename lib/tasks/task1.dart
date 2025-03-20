class Person {
  String name;
  int age;
  String gender;

  Person(this.name, this.age, this.gender);

  void displayInfo() {
    print("Имя: $name, Возраст: $age, Пол: $gender");
  }

  void incrementAge() {
    age++;
  }

  void changeName(String newName) {
    name = newName;
  }
}

void task1() {
  Person person = Person("Иван", 25, "Мужской");
  person.displayInfo();
  person.incrementAge();
  person.displayInfo();
  person.changeName("Петр");
  person.displayInfo();
}

void main() {
  task1();
}
