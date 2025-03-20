class Person {
  String name;
  int age;
  String gender;

  Person(this.name, this.age, this.gender);
}

class Worker extends Person {
  double salary;

  Worker(String name, int age, String gender, this.salary) : super(name, age, gender);

  void displaySalary() {
    print("Зарплата: $salary");
  }
}

class Manager extends Worker {
  List<String> subordinates;

  Manager(String name, int age, String gender, double salary, this.subordinates)
      : super(name, age, gender, salary);

  void displaySubordinates() {
    print("Подчиненные: ${subordinates.join(", ")}");
  }
}

void task2() {
  Manager manager = Manager("Алексей", 40, "Мужской", 1500.0, ["Иван", "Мария"]);
  manager.displaySalary();
  manager.displaySubordinates();
}

void main() {
  task2();
}
