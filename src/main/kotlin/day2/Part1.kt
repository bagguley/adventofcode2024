package day2

import kotlin.math.abs
import kotlin.math.sign

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val list = load(input)

        return list.count { it.isSafe() }
    }

    private fun load(input: List<String>): List<List<Int>> {
        return input.map { it.split(" ").map { it.toInt() } }
    }

    private fun List<Int>.isSafe(): Boolean {
        val validGap = windowed(2) { abs(it[0] - it[1]) }.all { it <= 3 }
        val validDirection = windowed(2) { (it[0] - it[1]).sign }.toSet().size == 1
        return validGap && validDirection
    }
}
