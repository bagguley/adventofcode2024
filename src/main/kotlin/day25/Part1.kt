package day25

fun main() {
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val (l, k) = input.map { it.split("\n") }.partition { it.first() == "#####" }
        val locks = l.map { it.drop(1) }.map { toCombo(it) }
        val keys = k.map { it.dropLast(1) }.map { toCombo(it) }

        return locks.sumOf { lock -> keys.count { key -> fits(lock, key) } }
    }

    private fun toCombo(input: List<String>): List<Int> =
        input.map { it.map { c -> if (c == '#') 1 else 0 } }.reduce { a, b -> a.zip(b) { c, d -> c + d } }

    private fun fits(lock: List<Int>, key: List<Int>): Boolean =
        lock.zip(key).map { it.first + it.second }.all { it < 6 }
}