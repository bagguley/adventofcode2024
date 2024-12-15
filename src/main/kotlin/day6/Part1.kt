package day6

import util.*

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
    println(Part1a.calc(data))
    println(Part1b.calc(data))
    println(Part1c.calc(data))
    println(Part1UsingUtil.calc(data))
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

object Part1a {
    fun calc(input: List<String>): Int =
        input.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }.filter { it.second == '^' }
            .map { it.first to y } }.first().let { move(it, 0 to -1, input, setOf(it)) }

    private tailrec fun move(pos: Pair<Int,Int>, dir: Pair<Int,Int>, input: List<String>, been: Set<Pair<Int,Int>>): Int =
        (input.getOrNull(pos.second + dir.second)?.getOrNull(pos.first + dir.first) ?: 'X').let {
            return if (it == 'X') been.size else if (it != '#') move(pos.first + dir.first to pos.second + dir.second, dir,
            input, been + (pos.first + dir.first to pos.second + dir.second)) else move(pos, -dir.second to dir.first, input, been)}
}

object Part1b {
    fun calc(input: List<String>): Int =
        input.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }.filter { it.second == '^' }
            .map { it.first to y } }.first().let { move(it, 0 to -1, input, setOf(it)) }

    private tailrec fun move(pos: Pair<Int,Int>, dir: Pair<Int,Int>, input: List<String>,
                             been: Set<Pair<Int,Int>>): Int =
        (input.getOrNull(pos.second + dir.second)?.getOrNull(pos.first + dir.first) ?: 'X').let {
            return if (it == 'X') been.size else if (it != '#') move(pos.first + dir.first to
                    pos.second + dir.second, dir, input, been + (pos.first + dir.first to
                    pos.second + dir.second)) else move(pos, -dir.second to dir.first, input, been)}
}

object Part1c {
    fun calc(input: List<String>): Int = input.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }.filter { it.second == '^' }
        .map { it.first to y } }.first().let { map ->
            DeepRecursiveFunction<Pair<Triple<Pair<Int,Int>, Pair<Int,Int>, List<String>>, Set<Pair<Int,Int>>>, Int> { param ->
                (input.getOrNull(param.first.first.second + param.first.second.second)?.getOrNull(param.first.first.first + param.first.second.first) ?: 'X').let {
                    if (it == 'X') param.second.size else if (it != '#') callRecursive(Triple(param.first.first.first + param.first.second.first to
                            param.first.first.second + param.first.second.second, param.first.second, input) to param.second + (param.first.first.first + param.first.second.first to
                            param.first.first.second + param.first.second.second)) else callRecursive(Triple(param.first.first, -param.first.second.second to param.first.second.first, input) to param.second)
                }
            }.invoke(Triple(map, 0 to -1, input) to setOf(map))
        }
}


object Part1UsingUtil {
    fun calc(input: List<String>): Int {
        var position = input.findChar('^').first()
        var direction = Direction.NORTH
        val visited: MutableSet<Vec2> = mutableSetOf(position)

        var current = '^'

        while (current != 'X') {
            when (val next = input.getOr(position + direction, 'X')) {
                '.', '^' -> {
                    position += direction
                    visited.add(position)
                    current = next
                }
                '#' -> direction = direction.clockwise90()
                else -> current = 'X'
            }
        }

        return visited.size
    }
}


