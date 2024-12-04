package day4

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
    println(Part1a.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int = input.find('X').sumOf { input.valid("XMAS", it) }

    private fun List<String>.find(character: Char): List<Pair<Int, Int>> =
        flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }
            .filter { it.second == character }.map { it.first to y } }

    private fun List<String>.valid(word: String, point: Pair<Int,Int>): Int =
        listOf(0 to -1, 1 to -1, 1 to 0, 1 to 1, 0 to 1, -1 to 1, -1 to 0, -1 to -1)
            .count { valid(word, point, it.first, it.second) }

    private fun List<String>.valid(word: String, point: Pair<Int,Int>, xStep:Int, yStep: Int): Boolean =
        word.indices.map { getOrNull(point.second + it * yStep)?.getOrNull(point.first + it * xStep) ?: "" }
            .joinToString("") == word
}

object Part1a {
    fun calc(input: List<String>): Int = input.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }
            .filter { it.second == 'X' }.map { it.first to y } }.sumOf { p ->
                listOf(0 to -1, 1 to -1, 1 to 0, 1 to 1, 0 to 1, -1 to 1, -1 to 0, -1 to -1)
                .count { o -> "XMAS".indices.map { input.getOrNull(p.second + it * o.second)
                    ?.getOrNull(p.first + it * o.first) ?: "" }.joinToString("") == "XMAS" }
        }
}