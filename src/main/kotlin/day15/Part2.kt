package day15

import util.*
import util.Direction.*

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(testData2))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val (map, moves) = load(input)
        var position = map.entries.find { it.value == '@' }!!.key

        for (move in moves) {
            if (move(map, position, move)) {
                map[position] = '.'
                position += move
            }
        }

        return map.entries.filter { it.value == '[' }.sumOf { it.key.y * 100 + it.key.x }
    }

    private fun load(input: List<String>): Pair<MutableMap<Vec2, Char>, List<Direction>> {
        val map = input[0].split("\n").map { line ->
            line.map { char ->
                when (char) {
                    '#' -> "##"
                    'O' -> "[]"
                    '.' -> ".."
                    '@' -> "@."
                    else -> throw IllegalArgumentException("Bad char: $char")
                }
            }.joinToString("")
        }.toVec2Map{ it }.toMutableMap()

        val moves = input[1].split("\n").flatMap { it.map { c -> c.toDirection() } }
        return map to moves
    }

    private fun move(map: MutableMap<Vec2, Char>, position: Vec2, direction: Direction): Boolean {
        when (direction) {
            EAST, WEST -> {
                if (canMoveHorizontally(map, position, direction)) {
                    moveHorizontally(map, position, direction)
                    return true
                }
            }
            NORTH, SOUTH -> {
                if (canMoveVertically(map, position, direction)) {
                    moveVertically(map, position, direction)
                    return true
                }
            }
        }
        return false
    }

    private fun canMoveVertically(map: MutableMap<Vec2, Char>, position: Vec2, direction: Direction): Boolean {
        val nextChar = map[position + direction]!!
        if (nextChar in listOf('.', '@')) return true
        if (nextChar == '#') return false

        return if (nextChar == '[')
            canMoveVertically(map, position + direction, direction) && canMoveVertically(map, position + direction + EAST, direction)
        else
            canMoveVertically(map, position + direction, direction) && canMoveVertically(map, position + direction + WEST, direction)
    }

    private fun canMoveHorizontally(map: MutableMap<Vec2, Char>, position: Vec2, direction: Direction): Boolean {
        val nextChar = map[position + direction]!!
        if (nextChar in listOf('.', '@')) return true
        if (nextChar == '#') return false

        return canMoveHorizontally(map, position + direction, direction)
    }

    private fun moveVertically(map: MutableMap<Vec2, Char>, position: Vec2, direction: Direction) {
        val nextChar = map[position + direction]!!
        if (nextChar == '[') {
            moveVertically(map, position + direction, direction)
            moveVertically(map, position + direction + EAST, direction)
        } else if (nextChar == ']') {
            moveVertically(map, position + direction, direction)
            moveVertically(map, position + direction + WEST, direction)
        }
        map[position + direction] = map[position]!!
        map[position] = '.'
    }

    private fun moveHorizontally(map: MutableMap<Vec2, Char>, position: Vec2, direction: Direction) {
        val nextChar = map[position + direction]!!
        if (nextChar in listOf('[', ']')) moveHorizontally(map, position + direction, direction)
        map[position + direction] = map[position]!!
        map[position] = '.'
    }
}