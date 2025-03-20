class BankAccount {
  String accountNumber;
  double balance;

  BankAccount(this.accountNumber, this.balance);

  void deposit(double amount) {
    balance += amount;
    print("Пополнение на $amount. Баланс: $balance");
  }

  void withdraw(double amount) {
    if (balance >= amount) {
      balance -= amount;
      print("Снятие $amount. Баланс: $balance");
    } else {
      print("Недостаточно средств.");
    }
  }
}

void task6() {
  BankAccount account = BankAccount("123456789", 1000.0);
  account.deposit(500.0);
  account.withdraw(300.0);
}

void main() {
  task6();
}
