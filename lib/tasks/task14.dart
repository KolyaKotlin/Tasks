class Point {
  double x, y;

  Point(this.x, this.y);
}

class Rectangle {
  Point topLeft, bottomRight;

  Rectangle(this.topLeft, this.bottomRight);

  double getArea() {
    return (bottomRight.x - topLeft.x) * (topLeft.y - bottomRight.y);
  }
}

void task14() {
  Point p1 = Point(0, 10);
  Point p2 = Point(5, 0);
  Rectangle rectangle = Rectangle(p1, p2);

  print("Площадь прямоугольника: ${rectangle.getArea()}");
}

void main() {
  task14();
}
