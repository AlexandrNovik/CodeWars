package task

import task.MultiplicationTable.multiplicationTable

fun main() {
    multiplicationTable(3).forEach { array ->
        array.forEach { print("$it ") }
        println()
    }
}

object MultiplicationTable {
    fun multiplicationTable(size: Int) = Array(size) { i -> IntArray(size) { i2 -> (i + 1) * (i2 + 1) } }
}