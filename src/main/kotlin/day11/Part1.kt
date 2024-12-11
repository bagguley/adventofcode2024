package day11

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: String): Int {
        var list = input.split(" ")

        repeat(25) {
           list = list.flatMap {
               if (it == "0") listOf("1")
               else if (it.length and 1 == 0) listOf(it.drop(it.length/2), it.dropLast(it.length/2).toLong().toString())
               else listOf((it.toLong()*2024).toString())
           }
        }

        return list.size
    }
}
