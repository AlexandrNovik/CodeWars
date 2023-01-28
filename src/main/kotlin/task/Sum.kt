package task

/*
Задача на программирование: различные слагаемые
По данному числу n найдите максимальное число kk, для которого nn можно представить как сумму kk различных натуральных слагаемых. Выведите в первой строке число kk, во второй — kk слагаемых.
*/
fun main() {
    val x = readLine()!!.toInt()
    val numberList = arrayListOf<Int>()
    var currentNumber = 1
    var sum = 0
    while (sum < x) {
        if (sum + currentNumber > x) { // last step
            val delta = x - sum
            numberList[numberList.size - 1] += delta
            break
        } else {                       // regular step
            sum += currentNumber
            numberList.add(currentNumber++)
        }
    }
    println(numberList.size)
    print(numberList.joinToString(" "))
}