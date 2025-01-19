import java.util.Scanner;

public class KirillTasks {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        while (true) {
            System.out.println("Меню:");
            System.out.println("1. Задание 1");
            System.out.println("2. Задание 2");
            System.out.println("3. Задание 3");
            System.out.println("4. Задание 4");
            System.out.println("5. Задание 5");
            System.out.println("6. Задание 6");
            System.out.println("7. Задание 7");
            System.out.println("8. Задание 8");
            System.out.println("9. Задание 9");
            System.out.println("10. Задание 10");
            System.out.println("11. Задание 11");
            System.out.println("12. Задание 12");
            System.out.println("13. Задание 13");
            System.out.println("14. Задание 14");
            System.out.println("15. Задание 15");
            System.out.println("16. Задание 16");
            System.out.println("17. Задание 17");
            System.out.println("18. Задание 18");
            System.out.println("19. Задание 19");
            System.out.println("20. Задание 20");
            System.out.println("0. Выход");

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkEvenOrOdd(scanner);
                    break;
                case 2:
                    findMinOfThree(scanner);
                    break;
                case 3:
                    multiplicationTable();
                    break;
                case 4:
                    theSumOfTheNumbers(scanner);
                    break;
                case 5:
                    fibonacciNumbers(scanner);
                    break;
                case 6:
                    primeNumber(scanner);
                    break;
                case 8:
                    sumEvenNumbers(scanner);
                    break;
                case 9:
                    ReverseString(scanner);
                    break;
                case 10:
                    CountDigits(scanner);
                    break;
                case 11:
                    Factorial(scanner);
                    break;
                case 12:
                    SumDigits(scanner);
                    break;
                case 13:
                    PalindromeCheck(scanner);
                    break;
                case 14:
                    MaxInArray(scanner);
                    break;
                case 15:
                    SumArray(scanner);
                    break;
                case 16:
                    CountPosNeg(scanner);
                    break;
                case 17:
                    PrimeNumbersInRange(scanner);
                    break;
                case 18:
                    CountVowelsConsonants(scanner);
                    break;
                case 19:
                    ReverseWords(scanner);
                    break;
                case 20:
                    ArmstrongNumber(scanner);
                    break;
                case 0:
                    scanner.close();
                    return;
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }

            System.out.println();
        }
    }

    private static void checkEvenOrOdd(Scanner scanner) {
        System.out.print("Введите число: ");
        int inputDigit = scanner.nextInt();
        if (inputDigit % 2 == 0) {
            System.out.println("Число четное.");
        } else {
            System.out.println("Число нечетное.");
        }
    }

    private static void findMinOfThree(Scanner scanner) {
        System.out.println("Введите три целых числа:");
        System.out.print("Число 1: ");
        int num1 = scanner.nextInt();
        System.out.print("Число 2: ");
        int num2 = scanner.nextInt();
        System.out.print("Число 3: ");
        int num3 = scanner.nextInt();

        int min = num1;
        if (num2 < min) {
            min = num2;
        }
        if (num3 < min) {
            min = num3;
        }

        System.out.println("Минимальное число: " + min);
    }

    private static void multiplicationTable() {
        System.out.println("Таблица умножения на 5:");
    for(int i = 1; i <= 10; i++ ){
        System.out.println("5 * "+ i + " = " + (5*i));
        }
    }
    private static void theSumOfTheNumbers(Scanner scanner){
        System.out.println("Введите число N:");
        int n = scanner.nextInt();

        int sum = 0;
        for(int i = 1; i < n; i++){
            sum += i;
        }
        System.out.println("Сумма чисел от 1 до " + n + ": " + sum);

    }

    private static void fibonacciNumbers(Scanner scanner){
        System.out.println("Введите чсило N:");
        int n = scanner.nextInt();

        int num0 = 0; int num1 = 1;
        for(int i = 0; i < n; i++ ){
            System.out.print(num0 + " ");

            int sum = num0 + num1;

            num0 = num1;
            num1 = sum;
        }
    }
    private static void primeNumber(Scanner scanner) {
        System.out.println("Введите число N: ");
        int n = scanner.nextInt();

        boolean isPrime = true;

        if (n <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }

        if (isPrime) {
            System.out.println("Число простое.");
        } else {
            System.out.println("Число не является простым.");
        }
    }

    private static void reverseOrder(Scanner scanner){
        System.out.println("Введите число N:");
        int n = scanner.nextInt();

        System.out.println("Числа от " + n + " до 1 в обратном порядке:");
        for (int i = n; i >= 1; i--) {
            System.out.print(i + " ");
        }
    }

    private static void sumEvenNumbers(Scanner scanner){
        System.out.print("Введите два числа A и B: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int sum = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }

        System.out.println("Сумма четных чисел: " + sum);
    }

    private static void ReverseString(Scanner scanner){
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        String reversed = new StringBuilder(input).reverse().toString();
        System.out.println("Реверс строки: " + reversed);
    }

    private static void CountDigits(Scanner scanner){
        System.out.print("Введите число: ");
        int number = Math.abs(scanner.nextInt());

        int count = String.valueOf(number).length();
        System.out.println("Количество цифр в числе: " + count);
    }

    private static void Factorial(Scanner scanner){
        System.out.print("Введите число N: ");
        int n = scanner.nextInt();

        long factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
        }

        System.out.println("Факториал: " + factorial);
    }

    private static void SumDigits(Scanner scanner){
        System.out.print("Введите число: ");
        int number = Math.abs(scanner.nextInt());

        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }

        System.out.println("Сумма цифр числа: " + sum);
    }
    private static void PalindromeCheck(Scanner scanner){
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();
        String reversed = new StringBuilder(input).reverse().toString();

        if (input.equals(reversed)) {
            System.out.println("Строка является палиндромом.");
        } else {
            System.out.println("Строка не является палиндромом.");
        }
    }
    private static void MaxInArray(Scanner scanner){
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int max = array[0];
        for (int num : array) {
            if (num > max) {
                max = num;
            }
        }

        System.out.println("Максимальное число: " + max);
    }
    private static void SumArray(Scanner scanner){
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        int sum = 0;
        for (int num : array) {
            sum += num;
        }

        System.out.println("Сумма всех элементов массива: " + sum);
    }

    private static void CountPosNeg(Scanner scanner){
        System.out.print("Введите размер массива: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        int positive = 0, negative = 0;

        System.out.println("Введите элементы массива:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
            if (array[i] > 0) positive++;
            if (array[i] < 0) negative++;
        }

        System.out.println("Положительных чисел: " + positive);
        System.out.println("Отрицательных чисел: " + negative);
    }
    private static void PrimeNumbersInRange(Scanner scanner){
        System.out.print("Введите два числа A и B: ");
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        System.out.println("Простые числа в диапазоне:");
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            if (isPrime(i)) {
                System.out.print(i + " ");
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    private static void CountVowelsConsonants(Scanner scanner){
        System.out.print("Введите строку: ");
        String input = scanner.nextLine().toLowerCase();

        int vowels = 0, consonants = 0;
        for (char c : input.toCharArray()) {
            if ("aeiouаеёиоуыэюя".indexOf(c) != -1) vowels++;
            else if (Character.isLetter(c)) consonants++;
        }

        System.out.println("Гласных: " + vowels);
        System.out.println("Согласных: " + consonants);
    }

    private static void ReverseWords(Scanner scanner){
        System.out.print("Введите строку: ");
        String input = scanner.nextLine();

        String[] words = input.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            System.out.print(words[i] + " ");
        }
    }

    private static void ArmstrongNumber(Scanner scanner){
        System.out.print("Введите число: ");
        int number = scanner.nextInt();

        int original = number, sum = 0, digits = String.valueOf(number).length();
        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        if (sum == original) {
            System.out.println(original + " — число Армстронга.");
        } else {
            System.out.println(original + " — не является числом Армстронга.");
        }
    }


}
