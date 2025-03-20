class Student {
  String name;
  String group;
  double grade;

  Student(this.name, this.group, this.grade);
}

class University {
  List<Student> students = [];

  void addStudent(Student student) {
    students.add(student);
  }

  void sortByName() {
    students.sort((a, b) => a.name.compareTo(b.name));
  }

  void filterByGrade(double minGrade) {
    students.where((student) => student.grade >= minGrade).forEach((student) {
      print("Студент: ${student.name}, Оценка: ${student.grade}");
    });
  }
}

void task10() {
  University university = University();
  university.addStudent(Student("Иван", "Группа 1", 4.5));
  university.addStudent(Student("Мария", "Группа 2", 5.0));
  university.addStudent(Student("Алексей", "Группа 1", 3.8));

  university.sortByName();
  university.filterByGrade(4.0);
}

void main() {
  task10();
}
