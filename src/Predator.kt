import kotlin.random.Random

class Wolf : Animal("Волк", 0, "🐺") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        val prey = cells[y][x].animals.filterIsInstance<Rabbit>().firstOrNull()
        if (prey != null) {
            cells[y][x].animals.remove(prey)
            hunger = 0 // Сбрасываем голод
            logAction("съел $prey.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < SimulationParameters.predatorReproductionChance) { // Шанс на размножение
            cells[y][x].animals.add(Wolf())
            logAction("размножился.")
        }
    }

    override fun move(cells: Array<Array<Cell>>, x: Int, y: Int) {
        val newX = (x + Random.nextInt(-1, 2)).coerceIn(0, cells[0].size - 1)
        val newY = (y + Random.nextInt(-1, 2)).coerceIn(0, cells.size - 1)

        if (newX != x || newY != y) {
            cells[newY][newX].animals.add(this)
            cells[y][x].animals.remove(this)
            logAction("переместился на ($newX; $newY).")
        }
    }
}

class Snake : Animal("Змея", 0, "🐍") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        val prey = cells[y][x].animals.filterIsInstance<Mouse>().firstOrNull()
        if (prey != null) {
            cells[y][x].animals.remove(prey)
            hunger = 0
            logAction("съел $prey.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < SimulationParameters.predatorReproductionChance) { // Шанс на размножение
            cells[y][x].animals.add(Snake())
            logAction("размножилась.")
        }
    }

    override fun move(cells: Array<Array<Cell>>, x: Int, y: Int) {
        val newX = (x + Random.nextInt(-1, 2)).coerceIn(0, cells[0].size - 1)
        val newY = (y + Random.nextInt(-1, 2)).coerceIn(0, cells.size - 1)

        if (newX != x || newY != y) {
            cells[newY][newX].animals.add(this)
            cells[y][x].animals.remove(this)
            logAction("переместилась на ($newX; $newY).")
        }
    }
}

class Fox : Animal("Лиса", 0, "🦊") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        val prey = cells[y][x].animals.filterIsInstance<Rabbit>().firstOrNull()
        if (prey != null) {
            cells[y][x].animals.remove(prey)
            hunger = 0
            logAction("съел $prey.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < SimulationParameters.predatorReproductionChance) { // Шанс на размножение
            cells[y][x].animals.add(Fox())
            logAction("размножилась.")
        }
    }

    override fun move(cells: Array<Array<Cell>>, x: Int, y: Int) {
        val newX = (x + Random.nextInt(-1, 2)).coerceIn(0, cells[0].size - 1)
        val newY = (y + Random.nextInt(-1, 2)).coerceIn(0, cells.size - 1)

        if (newX != x || newY != y) {
            cells[newY][newX].animals.add(this)
            cells[y][x].animals.remove(this)
            logAction("переместилась на ($newX; $newY).")
        }
    }
}
class Bear : Animal("Медведь", 0, "🐻") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        val prey = cells[y][x].animals.filterIsInstance<Deer>().firstOrNull()
        if (prey != null) {
            cells[y][x].animals.remove(prey)
            hunger = 0 // Сбрасываем голод
            logAction("съел $prey.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < SimulationParameters.predatorReproductionChance) { // Шанс на размножение
            cells[y][x].animals.add(Bear())
            logAction("размножился.")
        }
    }

    override fun move(cells: Array<Array<Cell>>, x: Int, y: Int) {
        val newX = (x + Random.nextInt(-1, 2)).coerceIn(0, cells[0].size - 1)
        val newY = (y + Random.nextInt(-1, 2)).coerceIn(0, cells.size - 1)

        if (newX != x || newY != y) {
            cells[newY][newX].animals.add(this)
            cells[y][x].animals.remove(this)
            logAction("переместился на ($newX; $newY).")
        }
    }
}
class Eagle : Animal("Орёл", 0, "🦅") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        val prey = cells[y][x].animals.filterIsInstance<Mouse>().firstOrNull()
        if (prey != null) {
            cells[y][x].animals.remove(prey)
            hunger = 0 // Сбрасываем голод
            logAction("съел $prey.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < SimulationParameters.predatorReproductionChance) { // Шанс на размножение
            cells[y][x].animals.add(Eagle())
            logAction("размножился.")
        }
    }

    override fun move(cells: Array<Array<Cell>>, x: Int, y: Int) {
        val newX = (x + Random.nextInt(-1, 2)).coerceIn(0, cells[0].size - 1)
        val newY = (y + Random.nextInt(-1, 2)).coerceIn(0, cells.size - 1)

        if (newX != x || newY != y) {
            cells[newY][newX].animals.add(this)
            cells[y][x].animals.remove(this)
            logAction("переместился на ($newX; $newY).")
        }
    }
}