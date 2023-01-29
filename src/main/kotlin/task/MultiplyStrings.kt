package task

// https://leetcode.com/problems/multiply-strings/description/
fun main() {
    val s = MultiplyStrings()
    println(s.multiply("140", "721"))
}

class MultiplyStrings {
    fun multiply(num1: String, num2: String): String {
        if (num1 == "0" || num2 == "0") return "0"
        val resultReversed = takeMultiplyResultList(num1, num2)
        val resultWithNulls = mutableListOf<String>()
        resultReversed.forEachIndexed { index, s ->
            resultWithNulls.add("0".repeat(index) + s)
        }
        val solutionList = mutableListOf<String>()
        var index = 0
        var transValue = 0
        val maxCount = resultWithNulls.fold(0) { acc, s -> acc.coerceAtLeast(s.count()) }
        while (true) {
            if (index >= maxCount) {
                if (transValue > 0){
                    solutionList.add("1")
                }
                break
            }
            var result = 0
            resultWithNulls.forEach {
                result += it.getOrNull(index)?.toString()?.toInt() ?: 0
            }
            val intermediate = "${(result + transValue) % 10}"
            transValue = (result + transValue) / 10
            solutionList.add(intermediate)
            index++
        }

        return solutionList.reversed().joinToString("")
    }

    private fun takeMultiplyResultList(num1: String, num2: String): List<String> {
        val numReversed1 = num1.reversed()
        val numReversed2 = num2.reversed()

        val multiplyList = mutableListOf<String>()
        var transValue = 0
        var intermediate = ""
        for (n2 in numReversed2) {
            transValue = 0
            intermediate = ""
            for (n1 in numReversed1) {
                val result = n1.toString().toInt() * n2.toString().toInt()
                intermediate = "${((result % 10) + transValue) % 10}$intermediate"
                transValue = (result + transValue) / 10
            }
            if (transValue > 0) {
                intermediate = "$transValue$intermediate"
            }
            println(intermediate)
            multiplyList.add(intermediate.reversed())
        }

        return multiplyList
    }
}
