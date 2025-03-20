import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit

class Island(val width: Int, val height: Int) {
    private val cells = Array(height) { Array(width) { Cell() } }
    private val executor = Executors.newScheduledThreadPool(1)

    init {
        initializeIsland()
    }

    private fun initializeIsland() {
        val random = java.util.Random()

        val herbivores = listOf(
            Rabbit(), Horse(), Deer(), Mouse(), Goat(), Sheep(), Boar(), Buffalo(), Duck(), Caterpillar()
        )
        val predators = listOf(
            Wolf(), Snake(), Fox(), Bear(), Eagle()
        )

        for (i in 0 until SimulationParameters.initialHerbivores) {
            val randomX = random.nextInt(width)
            val randomY = random.nextInt(height)
            cells[randomY][randomX].animals.add(herbivores.random())
        }

        for (i in 0 until SimulationParameters.initialPredators) {
            val randomX = random.nextInt(width)
            val randomY = random.nextInt(height)
            cells[randomY][randomX].animals.add(predators.random())
        }


        for (i in 0 until SimulationParameters.initialPlants) {
            val randomX = random.nextInt(width)
            val randomY = random.nextInt(height)
            cells[randomY][randomX].plants.add(Plant())
        }

        println("Остров инициализирован: " +
                "${SimulationParameters.initialHerbivores} травоядных, " +
                "${SimulationParameters.initialPredators} хищников и " +
                "${SimulationParameters.initialPlants} растений.")
    }

    fun startSimulation() {
        executor.scheduleAtFixedRate({ updateIsland() }, 0, 5, TimeUnit.SECONDS)
    }

    private fun updateIsland() {
        println("Обновление острова...")
        var totalAnimals = 0
        for (y in cells.indices) {
            for (x in cells[y].indices) {
                cells[y][x].update(cells, x, y)
            }
        }
        Statistics.printStatistics(cells)
        printIsland()

        if (totalAnimals == 0) {
            println("Все животные вымерли. Завершение симуляции.")
            executor.shutdown()
            return
        }

        Statistics.printStatistics(cells)
        printIsland()
    }


    private fun printIsland() {
        for (row in cells) {
            for (cell in row) {
                print(cell)
            }
            println()
        }
        println("===================================")
    }
}