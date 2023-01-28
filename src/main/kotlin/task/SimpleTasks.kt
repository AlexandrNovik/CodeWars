package task

import kotlin.math.sqrt

fun main() {
    println(predictAge(65, 60, 75, 55, 60, 63, 64, 45))
}
// -36, -45, 86, 8, -4, -40, -1, 22
fun maxSequence(arr: List<Int>): Int {
    var maxSum = 0
    var sum = 0
    for (eachNumber in arr) {
        sum += eachNumber
        maxSum = Math.max(sum, maxSum)
        sum = Math.max(sum, 0)
    }
    return maxSum
}

fun minMax(word: String): String = word.slice(((word.length / 2) - ((word.length + 1) % 2))..(word.length / 2))

fun invert(arr: IntArray): IntArray =
    arr.map { -it }.toIntArray()

fun reverseLetter(str: String) = str.filter { it.isLetter() }.reversed()

/*
*   var s1 = arrayOf<String>("cdIw", "tzIy", "xDu", "rThG")
*   var a = "[[cdIw, tzIy xDu rThG], [cdIw tzIy, xDu rThG], [cdIw tzIy xDu, rThG]]"
*/
fun partlist(arr: Array<String>): Array<Array<String>> =
    (0 until arr.size - 1)
        .map {
            arrayOf(
                arr.sliceArray(0..it).joinToString(" "),
                arr.sliceArray(it + 1 until arr.size).joinToString(" ")
            )
        }
        .toTypedArray()

fun maps(x: IntArray): IntArray = x.map { it * 2 }.toIntArray()

fun bingoMy(ticket: Array<Pair<String, Int>>, win: Int): String = ticket.map { (srt, value) ->
    var i = 0
    srt.toCharArray().forEach { if (it.toInt() == value) i++ }
    return@map if (i > 0) 1 else 0
}.sum().let { if (it >= win) "Winner!" else "Loser!" }

fun bingo(ticket: Array<Pair<String, Int>>, win: Int): String =
    if (ticket.count { it.second.toChar() in it.first } >= win) "Winner!" else "Loser!"

fun predictAge(vararg age: Int): Int =
    sqrt(age.map { it*it }.sum().toDouble()).div(2).toInt()
