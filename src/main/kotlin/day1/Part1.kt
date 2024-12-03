package day1

import kotlin.math.abs

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
    println(Part1a.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val pairs = load(input)
        val first = pairs.map { it.first }.sorted()
        val second = pairs.map { it.second }.sorted()

        return first.zip(second) { a, b -> abs(a - b) }.sum()
    }

    private fun load(input: List<String>): List<Pair<Int, Int>> {
        return input.map { it.split("   ") }.map { it[0].toInt() to it[1].toInt() }
    }
}

object Part1a {
    fun calc(input: List<String>): Int = input.map{it.split("   ")}
        .map{it[0].toInt() to it[1].toInt()}.let{it.map{it.first}.sorted()
            .zip(it.map{it.second}.sorted()){a,b->abs(a-b)}.sum()}
}