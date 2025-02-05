import java.io.File
import java.io.IOException
import kotlin.math.pow


//C:/Users/PC/IdeaProjects/untitled2/Tasks/TheCaesarCipher/encrypted.txt путь к зашифрованному файлу
//C:/Users/PC/IdeaProjects/untitled2/Tasks/TheCaesarCipher/text.txt путь к файлу который нужно зашифровать
//C:/Users/PC/IdeaProjects/untitled2/Tasks/TheCaesarCipher/brute_force путь к папке

// Русский алфавит (без ъ и ь)
val russianAlphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЫЭЮЯ"

val russianFrequency = mapOf(
    'О' to 0.1095, 'Е' to 0.0847, 'А' to 0.0801, 'И' to 0.0736, 'Н' to 0.0710,
    'Т' to 0.0622, 'С' to 0.0531, 'Р' to 0.0501, 'В' to 0.0454, 'Л' to 0.0437,
    'К' to 0.0355, 'М' to 0.0321, 'Д' to 0.0319, 'П' to 0.0311, 'У' to 0.0291,
    'Я' to 0.0265, 'Ы' to 0.0223, 'Ь' to 0.0209, 'Г' to 0.0206, 'З' to 0.0184,
    'Ч' to 0.0182, 'Ш' to 0.0149, 'Э' to 0.0148, 'Ю' to 0.0115, 'Ж' to 0.0105,
    'Ц' to 0.0099, 'Х' to 0.0092, 'Ф' to 0.0062, 'С' to 0.0055, 'Ё' to 0.0005
)

fun encryptText(text: String, key: Int): String {
    val alphabetLength = russianAlphabet.length
    val shift = key % alphabetLength

    return text.map { char ->
        when {
            russianAlphabet.contains(char.toUpperCase()) -> {
                val index = russianAlphabet.indexOf(char.toUpperCase())
                val shiftedChar = russianAlphabet[(index + shift) % alphabetLength]
                if (char.isLowerCase()) shiftedChar.toLowerCase() else shiftedChar
            }
            russianAlphabet.contains(char.toLowerCase()) -> {
                val index = russianAlphabet.indexOf(char.toUpperCase())
                val shiftedChar = russianAlphabet[(index + shift) % alphabetLength]
                if (char.isLowerCase()) shiftedChar.toLowerCase() else shiftedChar
            }
            else -> char
        }
    }.joinToString("")
}

fun decryptText(text: String, key: Int): String {
    val alphabetLength = russianAlphabet.length
    val shift = key % alphabetLength

    return text.map { char ->
        when {
            russianAlphabet.contains(char.toUpperCase()) -> {
                val index = russianAlphabet.indexOf(char.toUpperCase())
                val shiftedChar = russianAlphabet[(index - shift + alphabetLength) % alphabetLength]
                if (char.isLowerCase()) shiftedChar.toLowerCase() else shiftedChar
            }
            russianAlphabet.contains(char.toLowerCase()) -> {
                val index = russianAlphabet.indexOf(char.toUpperCase())
                val shiftedChar = russianAlphabet[(index - shift + alphabetLength) % alphabetLength]
                if (char.isLowerCase()) shiftedChar.toLowerCase() else shiftedChar
            }
            else -> char
        }
    }.joinToString("")
}

fun getLetterFrequency(text: String): Map<Char, Double> {
    val letterCount = mutableMapOf<Char, Int>()
    var totalLetters = 0

    for (char in text.filter { it in russianAlphabet }) {
        val upperChar = char.toUpperCase()
        letterCount[upperChar] = letterCount.getOrDefault(upperChar, 0) + 1
        totalLetters++
    }

    return letterCount.mapValues { it.value / totalLetters.toDouble() }
}

fun calculateFrequencyMatch(decryptedText: String): Double {
    val letterFrequency = getLetterFrequency(decryptedText)

    var similarity = 0.0
    for (letter in russianFrequency.keys) {
        val freqInText = letterFrequency[letter] ?: 0.0
        val freqInStat = russianFrequency[letter] ?: 0.0
        similarity += (freqInText - freqInStat).pow(2)
    }

    return similarity
}

fun statisticalAnalysisDecrypt(inputFile: String, outputFile: String) {
    try {
        val encryptedText = File(inputFile).readText()

        var bestKey = 0
        var bestMatch = Double.MAX_VALUE

        for (key in 0 until russianAlphabet.length) {
            val decryptedText = decryptText(encryptedText, key)
            val similarity = calculateFrequencyMatch(decryptedText)
            if (similarity < bestMatch) {
                bestMatch = similarity
                bestKey = key
            }
        }

        val finalDecryptedText = decryptText(encryptedText, bestKey)

        File(outputFile).writeText(finalDecryptedText)
        println("Текст успешно расшифрован методом статистического анализа. Ключ: $bestKey")
    } catch (e: IOException) {
        println("Ошибка при обработке файла: ${e.message}")
    }
}

fun encryptFile(inputFile: String, outputFile: String, key: Int) {
    try {
        val text = File(inputFile).readText()
        val encryptedText = encryptText(text, key)
        File(outputFile).writeText(encryptedText)
        println("Текст успешно зашифрован и записан в файл: $outputFile")
    } catch (e: IOException) {
        println("Ошибка при обработке файла: ${e.message}")
    }
}

fun decryptFile(inputFile: String, outputFile: String, key: Int) {
    try {
        val text = File(inputFile).readText()
        val decryptedText = decryptText(text, key)
        File(outputFile).writeText(decryptedText)
        println("Текст успешно расшифрован и записан в файл: $outputFile")
    } catch (e: IOException) {
        println("Ошибка при обработке файла: ${e.message}")
    }
}

fun bruteForceDecrypt(inputFile: String, outputFolder: String) {
    try {
        val text = File(inputFile).readText()

        val outputDir = File(outputFolder)
        if (!outputDir.exists()) {
            val success = outputDir.mkdirs()
            if (success) {
                println("Папка для результатов создана: $outputFolder")
            } else {
                println("Не удалось создать папку для результатов.")
                return
            }
        }

        for (key in 0 until russianAlphabet.length) {
            val decryptedText = decryptText(text, key)
            val outputFile = File(outputDir, "key_$key.txt")
            outputFile.writeText(decryptedText)
            println("Пробуем ключ $key: результат записан в файл ${outputFile.absolutePath}")
        }
    } catch (e: IOException) {
        println("Ошибка при обработке файла: ${e.message}")
    }
}

fun main() {
    println("Выберите действие:")
    println("1. Шифровка текста")
    println("2. Расшифровка текста с известным ключом")
    println("3. Расшифровка текста методом brute force")
    println("4. Расшифровка текста методом статистического анализа")

    when (readLine()?.toInt()) {
        1 -> {
            println("Введите путь к исходному файлу:")
            val inputFile = readLine()!!
            println("Введите путь для сохранения зашифрованного файла:")
            val outputFile = readLine()!!
            println("Введите ключ (сдвиг):")
            val key = readLine()?.toIntOrNull() ?: 0
            if (key < 0 || key >= russianAlphabet.length) {
                println("Ошибка: ключ должен быть в диапазоне от 0 до ${russianAlphabet.length - 1}")
            } else {
                encryptFile(inputFile, outputFile, key)
            }
        }
        2 -> {
            println("Введите путь к зашифрованному файлу:")
            val inputFile = readLine()!!
            println("Введите путь для сохранения расшифрованного файла:")
            val outputFile = readLine()!!
            println("Введите ключ (сдвиг):")
            val key = readLine()?.toIntOrNull() ?: 0
            if (key < 0 || key >= russianAlphabet.length) {
                println("Ошибка: ключ должен быть в диапазоне от 0 до ${russianAlphabet.length - 1}")
            } else {
                decryptFile(inputFile, outputFile, key)
            }
        }
        3 -> {
            println("Введите путь к зашифрованному файлу:")
            val inputFile = readLine()!!
            println("Введите путь для папки, где будут сохранены результаты:")
            val outputFolder = readLine()!!
            bruteForceDecrypt(inputFile, outputFolder)
        }
        4 -> {
            println("Введите путь к зашифрованному файлу:")
            val inputFile = readLine()!!
            println("Введите путь для сохранения расшифрованного файла:")
            val outputFile = readLine()!!
            statisticalAnalysisDecrypt(inputFile, outputFile)
        }
        else -> println("Неверный выбор.")
    }
}