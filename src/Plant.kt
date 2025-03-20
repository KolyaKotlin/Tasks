import kotlin.random.Random

class Plant(val type: String = "Растение") {
    fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < SimulationParameters.plantReproductionChance) { // Шанс на размножение
            cells[y][x].plants.add(Plant())
        }
    }
}