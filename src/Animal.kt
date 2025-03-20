abstract class Animal(val name: String, var hunger: Int, val symbol: String) {
    abstract fun eat(plants: MutableList<Plant>, cells: Array<Array<Cell>>, x: Int, y: Int)
    abstract fun reproduce(cells: Array<Array<Cell>>, x: Int, y: Int)
    abstract fun move(cells: Array<Array<Cell>>, x: Int, y: Int)

    protected fun logAction(action: String) {
        println("$name $action")
    }
}