object Statistics {
    fun printStatistics(cells: Array<Array<Cell>>) {
        val animalCount = mutableMapOf<String, Int>()
        var plantCount = 0

        for (row in cells) {
            for (cell in row) {
                for (animal in cell.animals) {
                    animalCount[animal.name] = animalCount.getOrDefault(animal.name, 0) + 1
                }
                plantCount += cell.plants.size
            }
        }

        println("Статистика на острове:")
        animalCount.forEach { (name, count) ->
            println("$name: $count")
        }
        println("Количество растений: $plantCount")
        println("===================================")
    }
}