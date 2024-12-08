package day8

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
    println(Part1a.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val uniqueLetters = input.flatMap { it.filter { it != '.' }.toSet() }.toSet()

        val combinations = uniqueLetters.flatMap { input.combinations(it) }

        val antinodes = combinations.flatMap { antinodes(it) }.toSet()

        return antinodes.count { it.first in input.indices && it.second in 0..<input[0].length }
    }

    private fun List<String>.combinations(char: Char): List<Pair<Pair<Int, Int>, Pair<Int, Int>>> {
        val coords = this.flatMapIndexed { y: Int, s: String -> s.mapIndexed { x: Int, c: Char -> x to c}.filter { it.second == char }.map { it.first to y } }
        return combinations(coords.first(), coords.drop(1))
    }

    private fun combinations(head: Pair<Int, Int>, tail: List<Pair<Int,Int>>): List<Pair<Pair<Int,Int>,Pair<Int,Int>>> {
        return tail.map { head to it } + if (tail.size == 1) emptyList() else combinations(tail.first(), tail.drop(1))
    }

    private fun antinodes(pair: Pair<Pair<Int,Int>,Pair<Int,Int>>): List<Pair<Int,Int>> {
        val first = pair.first
        val second = pair.second
        val diff = first.first - second.first to first.second - second.second
        val firstAntiNode = first.first + diff.first to first.second + diff.second
        val secondAntiNode = second.first - diff.first to second.second - diff.second
        return listOf(firstAntiNode, secondAntiNode)
    }
}

object Part1a {
    fun calc(input: List<String>): Int = input.flatMap{it.filter{it != '.'}.toSet()}.toSet().flatMap{
        input.combinations(it)}.flatMap{anti(it)}.toSet().count{it.first in input.indices && it.second in 0..<input[0].length}

    private fun List<String>.combinations(char: Char): List<Pair<Pair<Int, Int>, Pair<Int, Int>>> = this.flatMapIndexed {
            y: Int, s: String -> s.mapIndexed{x: Int, c: Char -> x to c}.filter{it.second == char}.map{it.first to y}}
        .let{combinations(it.first(), it.drop(1))}

    private fun combinations(head: Pair<Int, Int>, tail: List<Pair<Int,Int>>): List<Pair<Pair<Int,Int>,Pair<Int,Int>>> =
        tail.map{head to it} + if (tail.size == 1) emptyList() else combinations(tail.first(), tail.drop(1))

    private fun anti(pair: Pair<Pair<Int,Int>,Pair<Int,Int>>): List<Pair<Int,Int>> {
        val diff = pair.first.first - pair.second.first to pair.first.second - pair.second.second
        return listOf(pair.first.first + diff.first to pair.first.second + diff.second,
            pair.second.first - diff.first to pair.second.second - diff.second)
    }
}