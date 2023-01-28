package sort

fun main() {
    quickSort(listOf(54, 2, 5, 3, 8, 9, 22, 11, 43, 12, 91, 88, 45, 422)).forEach {
        print("$it ")
    }
}

fun quickSort(items: List<Int>): List<Int> {
    if (items.count() < 2) return items
    val pivot = items[items.count() / 2]
    val equal = items.filter { it == pivot }
    val less = items.filter { it < pivot }
    val greater = items.filter { it > pivot }
    return quickSort(less) + equal + quickSort(greater)
}