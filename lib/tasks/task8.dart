abstract class Shape {
  double getArea();
}

class Circle extends Shape {
  double radius;

  Circle(this.radius);

  @override
  double getArea() {
    return 3.14 * radius * radius;
  }
}

class Rectangle extends Shape {
  double width;
  double height;

  Rectangle(this.width, this.height);

  @override
  double getArea() {
    return width * height;
  }
}

void task8() {
  Shape circle = Circle(5.0);
  Shape rectangle = Rectangle(4.0, 6.0);

  print("Площадь круга: ${circle.getArea()}");
  print("Площадь прямоугольника: ${rectangle.getArea()}");
}

void main() {
  task8();
}
