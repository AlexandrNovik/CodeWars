package task
/*
https://codeforces.com/problemset/problem/527/A
A. Игра с бумагой
*/
fun main() {
    var (a, b) = readLine()!!.split(' ').map { it.toLong() }
    var count = 0L
    while (a > 0 && b > 0) {
        if (a >= b) {
            count += a / b
            a %= b
        } else {
            count += b / a
            b %= a
        }
    }
    println(count)
}
