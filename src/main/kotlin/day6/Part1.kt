package day6

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        var position = input.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }.filter { it.second == '^' }.map { it.first to y } }.first()
        var direction = 0 to -1

        val visited: MutableSet<Pair<Int,Int>> = mutableSetOf(position)

        var current = '^'
        while (current != 'X') {
            val next = input.getOrNull(position.second + direction.second)?.getOrNull(position.first + direction.first) ?: 'X'

            when (next) {
                '.', '^' -> {
                    position = position.first + direction.first to position.second + direction.second
                    visited.add(position)
                    current = next
                }
                '#' -> direction = -direction.second to direction.first
                else -> current = 'X'
            }
        }

        return visited.size
    }
}
