package task

/*
    @Test
    fun exampleTestCases() {
        assertEquals("HEY JUDE", decodeMorse(".... . -.--   .--- ..- -.. ."))
    }
*/
fun main() {
    println(decodeMorse("-..- -.-.- .   ."))
}

fun decodeMorse(code: String): String {
    //Your code goes here!
    //A map, MorseCode, is available
    val list = mutableListOf<String>()
    code.split("   ").forEach { word ->
        word.split(" ").forEach { letter ->
            list.add(MorseCode[letter.trim()] ?: "")
        }
        list.add(" ")
    }
    return list.dropLast(1).joinToString("")
}

val MorseCode = hashMapOf(
    ".-" to "A",
    "-..." to "B",
    "-.-." to "C",
    "-.." to "D",
    "." to "E",
    "..-." to "F",
    "--." to "G",
    "...." to "H",
    ".---" to "J",
    "-.-" to "K",
    ".-.." to "L",
    "--" to "M",
    "-." to "N",
    "---" to "O",
    ".--." to "P",
    "--.-" to "Q",
    ".-." to "R",
    "..." to "S",
    "-" to "T",
    "..-" to "U",
    "...-" to "V",
    ".--" to "W",
    "-..-" to "[",
    "-.-.-" to "]",
    "--.." to "Z",
    ".----" to "1",
    "..---" to "2",
    "...--" to "3",
    "....-" to "4",
    "....." to "5",
    "-...." to "6",
    "--..." to "7",
    "---.." to "8",
    "----." to "9",
    "-----" to "0"
)