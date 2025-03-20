abstract class PaymentSystem {
  void pay(double amount);
  void refund(double amount);
}

class CreditCard implements PaymentSystem {
  @override
  void pay(double amount) {
    print("Платеж через кредитную карту: $amount");
  }

  @override
  void refund(double amount) {
    print("Возврат через кредитную карту: $amount");
  }
}

class PayPal implements PaymentSystem {
  @override
  void pay(double amount) {
    print("Платеж через PayPal: $amount");
  }

  @override
  void refund(double amount) {
    print("Возврат через PayPal: $amount");
  }
}

void task12() {
  PaymentSystem card = CreditCard();
  PaymentSystem paypal = PayPal();

  card.pay(100.0);
  paypal.refund(50.0);
}

void main() {
  task12();
}
