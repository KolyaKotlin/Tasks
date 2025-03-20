import kotlin.random.Random

class Rabbit : Animal("Кролик", 0, "🐇") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (plants.isNotEmpty()) {
            plants.removeAt(0)
            hunger = 0
            logAction("съел растение.")
        } else {
            hunger++
            logAction("не нашел растения и увеличил голод.")
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < SimulationParameters.herbivoreReproductionChance) { // Шанс на размножение
            cells[y][x].animals.add(Rabbit())
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
        } else {
            logAction("остался на месте.")
        }
    }
}
class Sheep : Animal("Овца", 0, "🐑") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (plants.isNotEmpty()) {
            plants.removeAt(0)
            hunger = 0
            logAction("съел растение.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < 15) { // 15% шанс на размножение
            cells[y][x].animals.add(Sheep())
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

class Boar : Animal("Кабан", 0, "🐗") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (plants.isNotEmpty()) {
            plants.removeAt(0)
            hunger = 0
            logAction("съел растение.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < 10) { // 10% шанс на размножение
            cells[y][x].animals.add(Boar())
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
class Buffalo : Animal("Буйвол", 0, "🐃") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (plants.isNotEmpty()) {
            plants.removeAt(0)
            hunger = 0
            logAction("съел растение.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < 5) { // 5% шанс на размножение
            cells[y][x].animals.add(Buffalo())
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

class Duck : Animal("Утка", 0, "🦆") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (plants.isNotEmpty()) {
            plants.removeAt(0)
            hunger = 0
            logAction("съел растение.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < 20) { // 20% шанс на размножение
            cells[y][x].animals.add(Duck())
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
class Horse : Animal("Лошадь", 0, "🐎") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (plants.isNotEmpty()) {
            plants.removeAt(0)
            hunger = 0
            logAction("съел растение.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < 15) { // 15% шанс на размножение
            cells[y][x].animals.add(Horse())
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
class Deer : Animal("Олень", 0, "🦌") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (plants.isNotEmpty()) {
            plants.removeAt(0)
            hunger = 0
            logAction("съел растение.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < 10) { // 10% шанс на размножение
            cells[y][x].animals.add(Deer())
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
class Mouse : Animal("Мышь", 0, "🐁") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (plants.isNotEmpty()) {
            plants.removeAt(0)
            hunger = 0
            logAction("съел растение.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < 25) { // 25% шанс на размножение
            cells[y][x].animals.add(Mouse())
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
class Goat : Animal("Коза", 0, "🐐") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (plants.isNotEmpty()) {
            plants.removeAt(0)
            hunger = 0
            logAction("съел растение.")
        } else {
            hunger++
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < 15) { // 15% шанс на размножение
            cells[y][x].animals.add(Goat())
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
class Caterpillar : Animal("Гусеница", 0, "🐛") {
    override fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (plants.isNotEmpty()) {
            plants.removeAt(0) // Гусеница ест растение
            hunger = 0 // Сбрасываем голод
            logAction("съел растение.")
        } else {
            hunger++ // Увеличиваем голод, если нет растений
        }
    }

    override fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int) {
        if (Random.nextInt(100) < 30) { // 30% шанс на размножение
            cells[y][x].animals.add(Caterpillar())
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