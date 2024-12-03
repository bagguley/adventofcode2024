package day3

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: String): Int {
        var active = true
        var sum = 0
        """(mul\(\d+,\d+\)|do\(\)|don't\(\))""".toRegex().findAll(input).forEach {
            when (it.value) {
                "do()" -> active = true
                "don't()" -> active = false
                else -> if (active) sum += mul(it.value)
            }
        }
        return sum
    }

    private fun mul(input: String): Int =
        input.drop(4).dropLast(1).split(",").let{ it[0].toInt() * it[1].toInt() }
}