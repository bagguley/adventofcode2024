package day6

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val start = input.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }.filter { it.second == '^' }.map { it.first to y } }.first()
        val dots = input.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }.filter { it.second == '.' }.map { it.first to y } }

        return dots.map { d -> input.toMutableList().apply { this[d.second] = StringBuilder(this[d.second])
            .also { it.setCharAt(d.first, '#') }.toString() } }.count { !doesExit(it, start) }
    }

    private fun doesExit(input: List<String>, start: Pair<Int,Int>): Boolean {
        val visited: MutableSet<Pair<Pair<Int,Int>,Pair<Int,Int>>> = mutableSetOf(start to (0 to -1))
        var position = start
        var direction = 0 to -1
        var current = '^'

        while (current != 'X') {
            val next = input.getOrNull(position.second + direction.second)?.getOrNull(position.first + direction.first) ?: 'X'

            when (next) {
                '.', '^' -> {
                    position = position.first + direction.first to position.second + direction.second
                    if (position to direction in visited) return false
                    visited.add(position to direction)
                    current = next
                }
                '#' -> direction = -direction.second to direction.first
                else -> current = 'X'
            }
        }

        return true
    }
}