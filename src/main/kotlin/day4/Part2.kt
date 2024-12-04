package day4

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
    println(Part2a.calc(data))
    println(Part2b.calc(data))
}

object Part2 {
    fun calc(input:List<String>): Int = input.find('A').count { input.valid("MAS", it) }

    private fun List<String>.find(character: Char): List<Pair<Int, Int>> =
        flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }
            .filter { it.second == character }.map { it.first to y } }

    private fun List<String>.valid(word: String, point: Pair<Int,Int>): Boolean {
        val w1 = extract(point, listOf(-1 to -1, 0 to 0, 1 to 1))
        val w2 = extract(point, listOf(1 to -1, 0 to 0, -1 to 1))

        return (w1 == word || w1 == word.reversed()) && (w2 == word || w2 == word.reversed())
    }

    private fun List<String>.extract(point: Pair<Int,Int>, steps: List<Pair<Int, Int>>): String =
        steps.map { s -> getOrNull(point.second + s.second)?.getOrNull(point.first + s.first) ?: "" }
            .joinToString("")
}

object Part2a {
    fun calc(input:List<String>): Int = input.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }
        .filter { it.second == 'A' }.map { it.first to y } }
        .count { p -> listOf(-1 to -1, 0 to 0, 1 to 1).map { s -> input.getOrNull(p.second + s.second)
            ?.getOrNull(p.first + s.first) ?: "" }.joinToString("").let{ it == "MAS" || it == "SAM" } &&
                listOf(1 to -1, 0 to 0, -1 to 1).map { s -> input.getOrNull(p.second + s.second)
                    ?.getOrNull(p.first + s.first) ?: "" }.joinToString("").let{ it == "MAS" || it == "SAM" } }
}

object Part2b {
    fun calc(input:List<String>): Int = input.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }
        .filter { it.second == 'A' }.map { it.first to y } }.count { p -> listOf(listOf(-1 to -1, 0 to 0, 1 to 1),
        listOf(1 to -1, 0 to 0, -1 to 1)).map{ it.map { s -> input.getOrNull(p.second + s.second)
            ?.getOrNull(p.first + s.first) ?: "" }.joinToString("").let{ it == "MAS" || it == "SAM" } }.all { it } }
}