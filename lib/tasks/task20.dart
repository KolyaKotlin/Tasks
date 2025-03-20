class Device {
  String brand;

  Device(this.brand);

  void turnOn() {
    print("$brand включен");
  }

  void turnOff() {
    print("$brand выключен");
  }
}

class Smartphone extends Device {
  Smartphone(String brand) : super(brand);

  void takePhoto() {
    print("$brand делает фото");
  }
}

class Laptop extends Device {
  Laptop(String brand) : super(brand);

  void browseInternet() {
    print("$brand подключен к интернету");
  }
}

void task19() {
  Device device = Device("Бренд A");
  device.turnOn();

  Smartphone smartphone = Smartphone("iPhone");
  smartphone.takePhoto();
  smartphone.turnOff();

  Laptop laptop = Laptop("Dell");
  laptop.browseInternet();
  laptop.turnOff();
}

void main() {
  task19();
}
