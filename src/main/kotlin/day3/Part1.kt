package day3

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
    println(Part1a.calc(data))
    println(Part1b.calc(data))
}

object Part1 {
    fun calc(input: String): Int {
        return """mul\(\d+,\d+\)""".toRegex().findAll(input).sumOf { mul(it.value) }
    }

    private fun mul(input: String): Int =
        input.drop(4).dropLast(1).split(",").let{ it[0].toInt() * it[1].toInt() }
}

object Part1a {
    fun calc(input: String): Int = """mul\(\d+,\d+\)""".toRegex().findAll(input)
        .sumOf{it.value.drop(4).dropLast(1).split(",").let{it[0].toInt()*it[1].toInt()}}
}

object Part1b {
    fun calc(input: String): Int = """mul\((\d+),(\d+)\)""".toRegex().findAll(input)
        .sumOf{it.groupValues[1].toInt()*it.groupValues[2].toInt()}
}