class ComplexNumber {
  double real, imaginary;

  ComplexNumber(this.real, this.imaginary);

  ComplexNumber operator +(ComplexNumber other) {
    return ComplexNumber(real + other.real, imaginary + other.imaginary);
  }

  ComplexNumber operator -(ComplexNumber other) {
    return ComplexNumber(real - other.real, imaginary - other.imaginary);
  }

  ComplexNumber operator *(ComplexNumber other) {
    double realPart = real * other.real - imaginary * other.imaginary;
    double imaginaryPart = real * other.imaginary + imaginary * other.real;
    return ComplexNumber(realPart, imaginaryPart);
  }

  ComplexNumber operator /(ComplexNumber other) {
    double denominator = other.real * other.real + other.imaginary * other.imaginary;
    double realPart = (real * other.real + imaginary * other.imaginary) / denominator;
    double imaginaryPart = (imaginary * other.real - real * other.imaginary) / denominator;
    return ComplexNumber(realPart, imaginaryPart);
  }

  @override
  String toString() {
    return "$real + ${imaginary}i";
  }
}

void task15() {
  ComplexNumber num1 = ComplexNumber(4, 3);
  ComplexNumber num2 = ComplexNumber(1, 2);

  print("Сложение: ${num1 + num2}");
  print("Вычитание: ${num1 - num2}");
  print("Умножение: ${num1 * num2}");
  print("Деление: ${num1 / num2}");
}

void main() {
  task15();
}
