import java.lang.IllegalArgumentException
import java.lang.IndexOutOfBoundsException
import java.lang.NumberFormatException
import kotlin.math.sqrt
import java.text.SimpleDateFormat

fun main() {
    while (true) {
        println("\nМеню:")
        println("Задание 1. Нахождение максимума")
        println("Задание 2. Калькулятор деления")
        println("Задание 3. Конвертер строк в числа")
        println("Задание 4. Проверка возраста")
        println("Задание 5. Нахождение корня")
        println("Задание 6. Факториал")
        println("Задание 7. Проверка массива на нули")
        println("Задание 8. Калькулятор возведения в степень")
        println("Задание 9. Обрезка строки")
        println("Задание 10. Поиск элемента в массиве")
        println("Задание 11. Конвертация в двоичную систему")
        println("Задание 12. Проверка делимости")
        println("Задание 13. Чтение элемента списка")
        println("Задание 14. Парольная проверка")
        println("Задание 15. Проверка даты")
        println("Задание 16. Конкатенация строк")
        println("Задание 17. Остаток от деления")
        println("Задание 18. Квадратный корень")
        println("Задание 19. Конвертер температуры")
        println("Задание 20. Проверка строки на пустоту")
        println("0. Выход")

        when (readLine()?.toIntOrNull()) {
            1 -> println(maxOfTwo(readInt(), readInt()))
            2 -> println(divide(readInt(), readInt()))
            3 -> println(stringToInt(readLine().orEmpty()))
            4 -> println(checkAge(readInt()))
            5 -> println(findRoot(readInt()))
            6 -> println(factorial(readInt()))
            7 -> checkArrayForZeros(readIntArray())
            8 -> println(power(readInt(), readInt()))
            9 -> println(trimString(readLine().orEmpty(), readInt()))
            10 -> println(findInArray(readIntArray(), readInt()))
            11 -> println(toBinary(readInt()))
            12 -> println(isDivisible(readInt(), readInt()))
            13 -> println(getElementAtIndex(readList(), readInt()))
            14 -> checkPassword(readLine().orEmpty())
            15 -> checkDate(readLine().orEmpty())
            16 -> println(concatenateStrings(readLine(), readLine()))
            17 -> println(modulo(readInt(), readInt()))
            18 -> println(squareRoot(readInt()))
            19 -> println(celsiusToFahrenheit(readDouble()))
            20 -> checkString(readLine())
            0 -> return
            else -> println("Неверный выбор, попробуйте снова.")
        }
    }
}

fun readInt(): Int {
    print("Введите число: ")
    return readLine()?.toIntOrNull() ?: throw NumberFormatException("Некорректный ввод.")
}

fun readDouble(): Double {
    print("Введите число: ")
    return readLine()?.toDoubleOrNull() ?: throw NumberFormatException("Некорректный ввод.")
}

fun readIntArray(): IntArray {
    print("Введите массив чисел через пробел: ")
    return readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() }?.toIntArray()
        ?: throw IllegalArgumentException("Некорректный ввод.")
}

fun readList(): List<String> {
    print("Введите элементы списка через пробел: ")
    return readLine()?.split(" ") ?: throw IllegalArgumentException("Некорректный ввод.")
}

fun maxOfTwo(a: Int, b: Int): Int {
    if (a == b) throw IllegalArgumentException("Числа равны.")
    return if (a > b) a else b
}

fun divide(a: Int, b: Int): Double {
    if (b == 0) throw ArithmeticException("Деление на ноль недопустимо.")
    return a.toDouble() / b
}

fun stringToInt(str: String): Int {
    return str.toIntOrNull() ?: throw NumberFormatException("Не удалось конвертировать строку в число.")
}

fun checkAge(age: Int): String {
    if (age !in 0..150) throw IllegalArgumentException("Возраст должен быть в диапазоне от 0 до 150.")
    return "Возраст корректен."
}

fun findRoot(num: Int): Double {
    if (num < 0) throw IllegalArgumentException("Число не должно быть отрицательным.")
    return sqrt(num.toDouble())
}

fun factorial(num: Int): Long {
    if (num < 0) throw IllegalArgumentException("Число не должно быть отрицательным.")
    var result = 1L
    for (i in 1..num) {
        result *= i
    }
    return result
}

fun checkArrayForZeros(arr: IntArray) {
    if (arr.contains(0)) throw IllegalArgumentException("Массив содержит нули.")
    println("Массив не содержит нулей.")
}

fun power(base: Int, exponent: Int): Double {
    if (exponent < 0) throw IllegalArgumentException("Степень не должна быть отрицательной.")
    return Math.pow(base.toDouble(), exponent.toDouble())
}

fun trimString(str: String, length: Int): String {
    if (length > str.length) throw IllegalArgumentException("Длина обрезки превышает длину строки.")
    return str.substring(0, length)
}

fun findInArray(arr: IntArray, element: Int): Int {
    val index = arr.indexOf(element)
    if (index == -1) throw IllegalArgumentException("Элемент не найден.")
    return index
}

fun toBinary(num: Int): String {
    if (num < 0) throw IllegalArgumentException("Число должно быть неотрицательным.")
    return Integer.toBinaryString(num)
}

fun isDivisible(a: Int, b: Int): Boolean {
    if (b == 0) throw ArithmeticException("Деление на ноль недопустимо.")
    return a % b == 0
}

fun getElementAtIndex(list: List<String>, index: Int): String {
    if (index !in list.indices) throw IndexOutOfBoundsException("Индекс вне диапазона.")
    return list[index]
}

fun checkPassword(password: String) {
    if (password.length < 8) throw IllegalArgumentException("Пароль слишком короткий.")
    println("Пароль принят.")
}

fun checkDate(date: String) {
    val format = SimpleDateFormat("dd.MM.yyyy")
    format.isLenient = false
    try {
        format.parse(date)
        println("Дата корректна.")
    } catch (e: Exception) {
        throw IllegalArgumentException("Некорректный формат даты.")
    }
}

fun concatenateStrings(str1: String?, str2: String?): String {
    if (str1 == null || str2 == null) throw NullPointerException("Одна из строк равна null.")
    return str1 + str2
}

fun modulo(a: Int, b: Int): Int {
    if (b == 0) throw ArithmeticException("Деление на ноль недопустимо.")
    return a % b
}

fun squareRoot(num: Int): Double {
    if (num < 0) throw IllegalArgumentException("Число не должно быть отрицательным.")
    return sqrt(num.toDouble())
}

fun celsiusToFahrenheit(celsius: Double): Double {
    if (celsius < -273.15) throw IllegalArgumentException("Температура ниже абсолютного нуля.")
    return celsius * 9 / 5 + 32
}

fun checkString(str: String?) {
    if (str.isNullOrEmpty()) throw IllegalArgumentException("Строка пуста или равна null.")
    println("Строка корректна.")
}
