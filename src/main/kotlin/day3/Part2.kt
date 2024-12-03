package day3

fun main() {
    println(Part2.calc(testData2))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: String): Int {
        var active = true
        var sum = 0
        """mul\((\d+),(\d+)\)|do\(\)|don't\(\)""".toRegex().findAll(input).forEach {
            when (it.value) {
                "do()" -> active = true
                "don't()" -> active = false
                else -> if (active) sum += it.groupValues[1].toInt() * it.groupValues[2].toInt()
            }
        }
        return sum
    }
}