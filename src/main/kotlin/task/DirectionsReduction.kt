package task

import task.DirectionsReduction.dirReduc
import java.util.*

fun main() {
    dirReduc(arrayOf("NORTH", "EAST", "NORTH", "EAST", "WEST", "WEST", "EAST", "EAST", "WEST", "SOUTH")).forEach {
        println(it)
    }

}

object DirectionsReduction {
    private val opposite = mapOf("NORTH" to "SOUTH", "SOUTH" to "NORTH", "EAST" to "WEST", "WEST" to "EAST")
    fun dirReduc(arr: Array<String>): Array<String> = LinkedList<String>()
        .apply { arr.forEach { if (size > 0 && last() == opposite[it]) removeLast() else add(it) } }.toTypedArray()
}