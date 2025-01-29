import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.*
import kotlin.random.Random

fun main() {
    val scanner = Scanner(System.`in`)

    while (true) {
        println("\nВыберите задачу:")
        println("1. Текущая дата и время")
        println("2. Сравнение дат")
        println("3. Сколько дней до Нового года?")
        println("4. Проверка високосного года")
        println("5. Подсчет выходных за месяц")
        println("6. Расчет времени выполнения метода")
        println("7. Форматирование и парсинг даты")
        println("8. Конвертация между часовыми поясами")
        println("9. Вычисление возраста по дате рождения")
        println("10. Создание календаря на месяц")
        println("11. Генерация случайной даты в диапазоне")
        println("12. Расчет времени до заданной даты")
        println("13. Вычисление количества рабочих часов")
        println("14. Конвертация даты в строку с учетом локали")
        println("15. Определение дня недели по дате")
        println("0. Выход")

        when (scanner.nextInt()) {
            1 -> showCurrentDateTime()      // Задание 1: Текущая дата и время
            2 -> compareDates()             // Задание 2: Сравнение дат
            3 -> daysUntilNewYear()         // Задание 3: Сколько дней до Нового года?
            4 -> checkLeapYear()            // Задание 4: Проверка високосного года
            5 -> countWeekends()            // Задание 5: Подсчет выходных за месяц
            6 -> measureExecutionTime()     // Задание 6: Расчет времени выполнения метода
            7 -> formatAndParseDate()       // Задание 7: Форматирование и парсинг даты
            8 -> convertTimeZone()          // Задание 8: Конвертация между часовыми поясами
            9 -> calculateAge()             // Задание 9: Вычисление возраста по дате рождения
            10 -> showMonthCalendar()       // Задание 10: Создание календаря на месяц
            11 -> generateRandomDate()      // Задание 11: Генерация случайной даты в диапазоне
            12 -> timeUntilEvent()          // Задание 12: Расчет времени до заданной даты
            13 -> calculateWorkHours()      // Задание 13: Вычисление количества рабочих часов
            14 -> formatDateWithLocale()    // Задание 14: Конвертация даты в строку с учетом локали
            15 -> getDayOfWeek()            // Задание 15: Определение дня недели по дате
            0 -> return
            else -> println("Неверный ввод")
        }
    }
}

// Задание 1: Текущая дата и время
fun showCurrentDateTime() {
    val date = LocalDate.now()
    val time = LocalTime.now()
    println("Текущая дата: ${date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"))}")
    println("Текущее время: ${time.format(DateTimeFormatter.ofPattern("HH:mm:ss"))}")
}

// Задание 2: Сравнение дат
fun compareDates() {
    val scanner = Scanner(System.`in`)
    println("Введите первую дату (yyyy-MM-dd):")
    val date1 = LocalDate.parse(scanner.next())
    println("Введите вторую дату (yyyy-MM-dd):")
    val date2 = LocalDate.parse(scanner.next())
    println(if (date1 > date2) "Первая дата больше" else if (date1 < date2) "Вторая дата больше" else "Даты равны")
}

// Задание 3: Сколько дней до Нового года?
fun daysUntilNewYear() {
    val today = LocalDate.now()
    val newYear = LocalDate.of(today.year + 1, 1, 1)
    println("До Нового года: ${ChronoUnit.DAYS.between(today, newYear)} дней")
}

// Задание 4: Проверка високосного года
fun checkLeapYear() {
    println("Введите год:")
    val year = Scanner(System.`in`).nextInt()
    println(if (Year.of(year).isLeap) "Високосный год" else "Не високосный год")
}

// Задание 5: Подсчет выходных за месяц
fun countWeekends() {
    println("Введите год:")
    val year = Scanner(System.`in`).nextInt()
    println("Введите месяц (1-12):")
    val month = Month.of(Scanner(System.`in`).nextInt())
    val weekends = (1..month.length(Year.of(year).isLeap)).count {
        val date = LocalDate.of(year, month, it)
        date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY
    }
    println("Количество выходных: $weekends")
}

// Задание 6: Расчет времени выполнения метода
fun measureExecutionTime() {
    val start = System.nanoTime()
    repeat(1_000_000) {}
    println("Время выполнения: ${(System.nanoTime() - start) / 1_000_000} мс")
}

// Задание 7: Форматирование и парсинг даты
fun formatAndParseDate() {
    println("Введите дату в формате dd-MM-yyyy:")
    val scanner = Scanner(System.`in`)
    val input = scanner.next()
    val date = LocalDate.parse(input, DateTimeFormatter.ofPattern("dd-MM-yyyy"))
    println("Дата +10 дней: ${date.plusDays(10).format(DateTimeFormatter.ofPattern("yyyy/MM/dd"))}")
}

// Задание 8: Конвертация между часовыми поясами
fun convertTimeZone() {
    println("Введите дату и время в формате (yyyy-MM-dd HH:mm:ss):")
    val scanner = Scanner(System.`in`)
    val input = scanner.nextLine().trim()
    val dateTime = LocalDateTime.parse(input, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    val utcTime = ZonedDateTime.of(dateTime, ZoneId.of("UTC"))
    println("Московское время: ${utcTime.withZoneSameInstant(ZoneId.of("Europe/Moscow"))}")
}

// Задание 9: Вычисление возраста по дате рождения
fun calculateAge() {
    println("Введите год, месяц и день рождения (yyyy MM dd):")
    val scanner = Scanner(System.`in`)
    val year = scanner.nextInt()
    val month = scanner.nextInt()
    val day = scanner.nextInt()
    val birthDate = LocalDate.of(year, month, day)
    val age = ChronoUnit.YEARS.between(birthDate, LocalDate.now())
    println("Возраст: $age лет")
}

// Задание 10: Создание календаря на месяц
fun showMonthCalendar() {
    println("Введите год:")
    val year = Scanner(System.`in`).nextInt()
    println("Введите месяц (1-12):")
    val month = Month.of(Scanner(System.`in`).nextInt())
    for (day in 1..month.length(Year.of(year).isLeap)) {
        val date = LocalDate.of(year, month, day)
        val isWeekend = date.dayOfWeek == DayOfWeek.SATURDAY || date.dayOfWeek == DayOfWeek.SUNDAY
        println("$date - ${if (isWeekend) "Выходной" else "Рабочий день"}")
    }
}

// Задание 11: Генерация случайной даты в диапазоне
fun generateRandomDate() {
    println("Введите начальную дату (yyyy-MM-dd):")
    val start = LocalDate.parse(Scanner(System.`in`).next())
    println("Введите конечную дату (yyyy-MM-dd):")
    val end = LocalDate.parse(Scanner(System.`in`).next())
    val randomDate = LocalDate.ofEpochDay(Random.nextLong(start.toEpochDay(), end.toEpochDay()))
    println("Случайная дата: $randomDate")
}

// Задание 12: Расчет времени до заданной даты
fun timeUntilEvent() {
    println("Введите дату события (yyyy-MM-dd HH:mm:ss):")
    val scanner = Scanner(System.`in`)
    val eventDateTime = LocalDateTime.parse(scanner.nextLine().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
    val now = LocalDateTime.now()
    val duration = Duration.between(now, eventDateTime)
    println("До события: ${duration.toHours()} часов, ${duration.toMinutes() % 60} минут, ${duration.seconds % 60} секунд")
}

// Задание 13: Вычисление количества рабочих часов
fun calculateWorkHours() {
    println("Введите начало рабочего дня (yyyy-MM-dd HH:mm):")
    val scanner = Scanner(System.`in`)
    val start = LocalDateTime.parse(scanner.nextLine().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
    println("Введите конец рабочего дня (yyyy-MM-dd HH:mm):")
    val end = LocalDateTime.parse(scanner.nextLine().trim(), DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"))
    val hours = ChronoUnit.HOURS.between(start, end)
    println("Рабочих часов: $hours")
}

// Задание 14: Конвертация даты в строку с учетом локали
fun formatDateWithLocale() {
    val date = LocalDate.now()
    println("Введите локаль (например, ru или en):")
    val locale = Locale(Scanner(System.`in`).next())
    println("Дата в выбранном формате: ${date.format(DateTimeFormatter.ofPattern("dd MMMM yyyy", locale))}")
}

// Задание 15: Определение дня недели по дате
fun getDayOfWeek() {
    println("Введите дату (yyyy-MM-dd):")
    val scanner = Scanner(System.`in`)
    val date = LocalDate.parse(scanner.next())
    println("День недели: ${date.dayOfWeek.getDisplayName(java.time.format.TextStyle.FULL, Locale("ru"))}")
}
