class Cell {
    val animals = mutableListOf<Animal>()
    val plants = mutableListOf<Plant>()

    fun update(cells: Array<Array<Cell>>, x: Int, y: Int) {
        val animalsCopy = animals.toList()
        animalsCopy.forEach {
            it.move(cells, x, y)
            it.eat(plants, cells, x, y)
            it.reproduce(cells, x, y)
        }
        plants.forEach { it.reproduce(cells, x, y) }
    }


    override fun toString(): String {
        return when {
            animals.isNotEmpty() -> animals.last().symbol
            plants.isNotEmpty() -> "🌱"
            else -> "🟫"
        }
    }
}