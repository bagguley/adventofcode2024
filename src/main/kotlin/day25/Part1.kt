package day25

import util.transpose

fun main() {
    println(Part1.calc(data))
    println(Part1a.calc(data))
    println(Part1b.calc(data))
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

object Part1a {
    fun calc(input: List<String>): Int {
        val (l, k) = input.map { it.split("\n") }.partition { it.first() == "#####" }
        val locks = l.map { it.drop(1).transpose() }.map { it.map { it.count { it == '#' }} }
        val keys = k.map { it.dropLast(1).transpose() }.map { it.map { it.count { it == '#' }} }

        return locks.sumOf { lock -> keys.count { key -> lock.zip(key).all { it.first + it.second < 6} } }
    }
}

object Part1b {
    fun calc(input: List<String>): Int =
    input.map { it.split("\n") }.partition { it.first() == "#####" }.let { (l, k) ->
        l.map { it.drop(1).transpose() }.map { it.map { it.count { it == '#' }} } to
        k.map { it.dropLast(1).transpose() }.map { it.map { it.count { it == '#' }} } }
        .let { (locks, keys) -> locks.sumOf { lock -> keys.count { key -> lock.zip(key).all { it.first + it.second < 6} } } }
}