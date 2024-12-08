package day8

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val height = input.size
        val width = input[0].length
        val uniqueLetters = input.flatMap { it.filter { it != '.' }.toSet() }.toSet()

        val combinations = uniqueLetters.flatMap { input.combinations(it) }

        val antinodes = combinations.flatMap { antinodes(it, width, height) }.toSet()

        val inside = antinodes.filter{ it.first in 0..<height && it.second in 0..<width}

        return inside.count()
    }

    private fun List<String>.combinations(char: Char): List<Pair<Pair<Int, Int>, Pair<Int, Int>>> {
        val coords = this.flatMapIndexed { y: Int, s: String -> s.mapIndexed { x: Int, c: Char -> x to c}.filter { it.second == char }.map { it.first to y } }
        return combinations(coords.first(), coords.drop(1))
    }

    private fun combinations(head: Pair<Int, Int>, tail: List<Pair<Int,Int>>): List<Pair<Pair<Int,Int>,Pair<Int,Int>>> {
        return tail.map { head to it } + if (tail.size == 1) emptyList() else combinations(tail.first(), tail.drop(1))
    }

    private fun antinodes(pair: Pair<Pair<Int,Int>,Pair<Int,Int>>, width: Int, height: Int): List<Pair<Int,Int>> {
        val first = pair.first
        val second = pair.second
        val diff = first.first - second.first to first.second - second.second
        val result = mutableListOf<Pair<Int,Int>>()
        var antiNode = first.first - diff.first to first.second - diff.second
        while (antiNode.first in 0..<width && antiNode.second in 0..<height) {
            result.add(antiNode)
            antiNode = antiNode.first - diff.first to antiNode.second - diff.second
        }

        antiNode = second.first + diff.first to second.second + diff.second
        while (antiNode.first in 0..<width && antiNode.second in 0..<height) {
            result.add(antiNode)
            antiNode = antiNode.first + diff.first to antiNode.second + diff.second
        }

        return result
    }
}