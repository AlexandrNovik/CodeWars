package task

fun main() {
    println(fibIterable(500000))
}

fun fibSimple(n: Int): Int = if (n == 0 || n == 1) n else fibSimple(n - 1) + fibSimple(n - 2)

val cache = mutableMapOf(0 to 0, 1 to 1)
fun fib(n: Int): Int {
    if (cache[n] != null) {
        return cache[n]!!
    }
    for (i in 2..n) {
        cache[n] = fib(n - 2) + fib(n - 1)
    }
    return cache[n] ?: error("NOOOO!!!!")
}

fun fibIterable(n: Int): Int {
    var x1 = 0
    var x2 = 1
    var sum = 0
    for (i in 2..n) {
        sum = x1 + x2
        x1 = x2
        x2 = sum
    }
    return sum
}