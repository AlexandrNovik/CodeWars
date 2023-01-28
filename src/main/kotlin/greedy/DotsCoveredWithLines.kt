package greedy
/*
Задача на программирование: покрыть отрезки точками

По данным nn отрезкам необходимо найти множество точек минимального размера, для которого каждый из отрезков содержит хотя бы одну из точек.
В первой строке дано число 1 \le n \le 1001≤n≤100 отрезков. Каждая из последующих nn строк содержит по два числа 0 \le l \le r \le 10^90≤l≤r≤10 9, задающих начало и конец отрезка. Выведите оптимальное число mm точек и сами mm точек. Если таких множеств точек несколько, выведите любое из них.
*/
fun main() {
    data class Line(val from: Int, val to: Int)

    val list = arrayListOf<Line>();
    val points = arrayListOf<Int>()
    val n = readLine()!!.toInt()
    repeat(n) { readLine()!!.split(" ").map { it.toInt() }.also { (a, b) -> list.add(Line(a, b)) } }
    list.sortBy { it.to }
    for (line in list) {
        if (line.from > points.lastOrNull() ?: -1) points.add(line.to)
    }
    println(points.size); print(points.joinToString(" "))
}