package greedy

/*
Задача на программирование: непрерывный рюкзак

Выведите максимальную стоимость частей предметов (от каждого предмета можно отделить любую часть, стоимость и объём при этом пропорционально уменьшатся), помещающихся в данный рюкзак, с точностью не менее трёх знаков после запятой.
*/
import kotlin.math.abs

fun main() {
    data class Item(val cost: Double, val weight: Double)

    val items = arrayListOf<Item>()
    var sumCost = 0.0
    var currentWeight = 0.0
    val (n, w) = readLine()!!.split(" ").map { it.toDouble() }
    repeat(n.toInt()) { readLine()!!.split(" ").map { it.toDouble() }.also { (a, b) -> items.add(Item(a, b)) } }

    items.sortByDescending { it.cost / it.weight }
    for (item in items) {
        if (w == currentWeight) break
        if (w < item.weight + currentWeight) {
            val weighRatio = abs(w - currentWeight) / item.weight
            sumCost += item.cost * weighRatio
            currentWeight += item.weight * weighRatio
        } else {
            sumCost += item.cost
            currentWeight += item.weight
        }
    }
    print(sumCost)
}