package day3

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: String): Int {
        return """mul\(\d+,\d+\)""".toRegex().findAll(input).sumOf { mul(it.value) }
    }

    private fun mul(input: String): Int =
        input.drop(4).dropLast(1).split(",").let{ it[0].toInt() * it[1].toInt() }
}
