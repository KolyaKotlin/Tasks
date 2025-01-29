import java.io.*
import java.nio.file.*
import java.nio.channels.*
import java.nio.ByteBuffer
import java.nio.file.attribute.BasicFileAttributes
import java.util.concurrent.*
import kotlin.system.measureTimeMillis

// Задание 1: Работа с потоками ввода-вывода
fun task1() {
    println("Введите путь к исходному файлу:")
    val inputFile = readLine() ?: return
    println("Введите путь к результирующему файлу:")
    val outputFile = readLine() ?: return

    try {
        BufferedReader(FileReader(inputFile)).use { reader ->
            BufferedWriter(FileWriter(outputFile)).use { writer ->
                reader.forEachLine { line ->
                    writer.write(line.toUpperCase())
                    writer.newLine()
                }
            }
        }
        println("Файл успешно преобразован и записан.")
    } catch (e: Exception) {
        println("Ошибка: ${e.message}")
    }
}

// Задание 2: Реализация паттерна Декоратор
interface TextProcessor {
    fun process(text: String): String
}

class SimpleTextProcessor : TextProcessor {
    override fun process(text: String) = text
}

class UpperCaseDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String) = processor.process(text).toUpperCase()
}

class TrimDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String) = processor.process(text).trim()
}

class ReplaceDecorator(private val processor: TextProcessor) : TextProcessor {
    override fun process(text: String) = processor.process(text).replace(" ", "_")
}

fun task2() {
    val processor = ReplaceDecorator(
        UpperCaseDecorator(
            TrimDecorator(SimpleTextProcessor())
        )
    )
    val result = processor.process(" Hello world ")
    println("Результат обработки: $result")
}

// Задание 3: Сравнение производительности IO и NIO
fun task3() {
    println("Введите путь к большому файлу для тестирования (например, несколько мегабайт):")
    val inputFile = readLine() ?: return
    val outputFileIO = "output_io.txt"
    val outputFileNIO = "output_nio.txt"

    // IO
    val ioTime = measureTimeMillis {
        try {
            BufferedReader(FileReader(inputFile)).use { reader ->
                BufferedWriter(FileWriter(outputFileIO)).use { writer ->
                    reader.forEachLine { line ->
                        writer.write(line)
                        writer.newLine()
                    }
                }
            }
            println("IO: Файл успешно скопирован в $outputFileIO")
        } catch (e: Exception) {
            println("IO ошибка: ${e.message}")
        }
    }
    println("Время выполнения IO: $ioTime мс")

    // NIO
    val nioTime = measureTimeMillis {
        try {
            Files.copy(Paths.get(inputFile), Paths.get(outputFileNIO), StandardCopyOption.REPLACE_EXISTING)
            println("NIO: Файл успешно скопирован в $outputFileNIO")
        } catch (e: Exception) {
            println("NIO ошибка: ${e.message}")
        }
    }
    println("Время выполнения NIO: $nioTime мс")
}

// Задание 4: Копирование файла с использованием NIO
fun task4() {
    println("Введите путь к исходному файлу для копирования:")
    val sourceFile = readLine() ?: return
    println("Введите путь к результирующему файлу:")
    val destFile = readLine() ?: return

    try {
        FileInputStream(sourceFile).channel.use { sourceChannel ->
            FileOutputStream(destFile).channel.use { destChannel ->
                sourceChannel.transferTo(0, sourceChannel.size(), destChannel)
            }
        }
        println("Файл успешно скопирован с использованием NIO.")
    } catch (e: Exception) {
        println("Ошибка при копировании: ${e.message}")
    }
}

// Задание 5: Асинхронное чтение файла с использованием NIO.2
fun task5() {
    println("Введите путь к файлу для асинхронного чтения:")
    val filePath = readLine() ?: return
    val channel = AsynchronousFileChannel.open(Paths.get(filePath), StandardOpenOption.READ)
    val buffer = ByteBuffer.allocate(1024)

    val handler = object : CompletionHandler<Int, ByteBuffer> {
        override fun completed(result: Int, attachment: ByteBuffer) {
            attachment.flip()
            while (attachment.hasRemaining()) {
                print(attachment.get().toChar())
            }
            attachment.clear()
            if (result != -1) {
                channel.read(attachment, 0, attachment, this)
            } else {
                println("\nЧтение завершено.")
            }
        }

        override fun failed(exc: Throwable, attachment: ByteBuffer) {
            println("Ошибка: ${exc.message}")
        }
    }
    channel.read(buffer, 0, buffer, handler)
}

fun main() {
    while (true) {
        println("\nВыберите задание:")
        println("1. Работа с потоками ввода-вывода (IO)")
        println("2. Реализация паттерна Декоратор")
        println("3. Сравнение производительности IO и NIO")
        println("4. Копирование файла с использованием NIO")
        println("5. Асинхронное чтение файла с использованием NIO.2")
        println("0. Выход")

        when (readLine()?.toIntOrNull()) {
            1 -> task1()
            2 -> task2()
            3 -> task3()
            4 -> task4()
            5 -> task5()
            0 -> {
                println("Выход из программы...")
                break
            }
            else -> println("Неверный выбор. Попробуйте снова.")
        }
    }
}
