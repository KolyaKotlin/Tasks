// Задание 1: Создание класса базы данных как Singleton
// Класс DatabaseConnection реализует паттерн Singleton, чтобы всегда возвращать один и тот же объект подключения.

enum class OrderStatus {
    NEW, IN_PROGRESS, DELIVERED, CANCELLED
}

enum class Season {
    WINTER, SPRING, SUMMER, AUTUMN
}

class DatabaseConnection private constructor() {

    init {
        println("Подключение к базе данных установлено.")
    }

    companion object {
        private var instance: DatabaseConnection? = null

        fun getInstance(): DatabaseConnection {
            if (instance == null) {
                instance = DatabaseConnection()
            }
            return instance!!
        }
    }
}

class Logger private constructor() {

    private val logs = mutableListOf<String>()

    fun addLog(message: String) {
        logs.add(message)
    }

    fun printLogs() {
        println("Логи:")
        logs.forEach { println(it) }
    }

    companion object {
        private var instance: Logger? = null

        fun getInstance(): Logger {
            if (instance == null) {
                instance = Logger()
            }
            return instance!!
        }
    }
}

class Order(private var status: OrderStatus) {

    fun changeStatus(newStatus: OrderStatus) {
        if (status == OrderStatus.DELIVERED && newStatus == OrderStatus.CANCELLED) {
            println("Невозможно отменить доставленный заказ.")
        } else {
            status = newStatus
            println("Статус заказа изменен на: $status")
        }
    }

    fun getStatus(): OrderStatus {
        return status
    }
}

fun getSeasonName(season: Season): String {
    return when (season) {
        Season.WINTER -> "Зима"
        Season.SPRING -> "Весна"
        Season.SUMMER -> "Лето"
        Season.AUTUMN -> "Осень"
    }
}

fun main() {
    var exit = false
    val scanner = java.util.Scanner(System.`in`)

    while (!exit) {
        println("\nМеню:")
        println("1. Создать подключение к базе данных")
        println("2. Логирование в системе")
        println("3. Работа с заказами")
        println("4. Получить название сезона")
        println("5. Выход")
        print("Выберите опцию: ")

        when (scanner.nextInt()) {
            // Задание 1: Создание подключения к базе данных
            1 -> {
                val connection1 = DatabaseConnection.getInstance()
                val connection2 = DatabaseConnection.getInstance()
                println(connection1 === connection2)
            }

            // Задание 2: Логирование в системе
            2 -> {
                val logger = Logger.getInstance()
                println("Введите сообщение для лога:")
                scanner.nextLine()
                val message = scanner.nextLine()
                logger.addLog(message)
                logger.printLogs()
            }

            // Задание 3: Работа с заказами
            3 -> {
                println("Введите текущий статус заказа (NEW, IN_PROGRESS, DELIVERED, CANCELLED):")
                val statusInput = scanner.next().toUpperCase()
                val orderStatus = OrderStatus.valueOf(statusInput)

                val order = Order(orderStatus)
                println("Текущий статус заказа: ${order.getStatus()}")

                println("Введите новый статус заказа (NEW, IN_PROGRESS, DELIVERED, CANCELLED):")
                val newStatusInput = scanner.next().toUpperCase()
                val newOrderStatus = OrderStatus.valueOf(newStatusInput)

                order.changeStatus(newOrderStatus)
            }

            // Задание 4: Получить название сезона на русском языке
            4 -> {
                println("Введите сезон (WINTER, SPRING, SUMMER, AUTUMN):")
                val seasonInput = scanner.next().toUpperCase()
                val season = Season.valueOf(seasonInput)
                println("Название сезона: ${getSeasonName(season)}")
            }

            5 -> {
                println("Выход из программы.")
                exit = true
            }

            else -> println("Некорректный выбор. Попробуйте снова.")
        }
    }
}
