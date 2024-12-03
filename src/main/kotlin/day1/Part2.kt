package day1

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
    println(Part2a.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val pairs = load(input)
        val first = pairs.map { it.first }
        val second = pairs.map { it.second }

        return first.sumOf { f -> second.count { s -> f == s } * f }
    }

    private fun load(input: List<String>): List<Pair<Int, Int>> {
        return input.map { it.split("   ") }.map { it[0].toInt() to it[1].toInt() }
    }
}

object Part2a {
    fun calc(input: List<String>): Int = input.map{it.split("   ")}
        .map{it[0].toInt() to it[1].toInt()}
        .let{it.map{it.first}.sumOf{f->it.map{it.second}.count{s->f==s}*f}}
}