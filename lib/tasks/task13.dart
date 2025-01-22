class UniqueID {
  static int _idCounter = 0;

  static String generateID() {
    _idCounter++;
    return "ID$_idCounter";
  }
}

void task13() {
  print(UniqueID.generateID());
  print(UniqueID.generateID());
}

void main() {
  task13();
}
