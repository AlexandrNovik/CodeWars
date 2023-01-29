package task


fun main() {
    val s = MultiplyStrings()
    println(s.multiply("28", "341"))
}

class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        val result = takeMultiplyResultList(num1, num2)
        return result.joinToString()
    }

    private fun takeMultiplyResultList(num1: String, num2: String): List<String> {
        val numReversed1 = num1.reversed()
        val numReversed2 = num2.reversed()

        val multiplyList = mutableListOf<String>()
        var transValue: Int
        for (n2 in numReversed2) {
            transValue = 0
            var intermediate = ""
            for (n1 in numReversed1) {
                val result = n1.digitToInt() * n2.digitToInt()
                intermediate = "${(result % 10) + transValue}$intermediate"
                transValue = result / 10
            }
            if (transValue > 0) {
                intermediate = "$transValue$intermediate"
            }
            multiplyList.add(intermediate)
        }

        return multiplyList
    }
}
