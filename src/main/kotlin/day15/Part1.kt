package day15

import util.*

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(testData2))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val (map, moves) = load(input)
        var position = map.entries.find { it.value == '@' }!!.key

        for (move in moves) {
            position = move(map, position, move)
        }

        return map.entries.filter { it.value == 'O' }.sumOf { it.key.y * 100 + it.key.x }
    }

    private fun load(input: List<String>): Pair<MutableMap<Vec2, Char>, List<Direction>> {
        val map = input[0].split("\n").toVec2Map{ it }.toMutableMap()
        val moves = input[1].split("\n").flatMap { it.map { c -> c.toDirection() } }
        return map to moves
    }

    private fun move(map: MutableMap<Vec2, Char>, position: Vec2, direction: Direction): Vec2 {
        var nextChar = map[position + direction]!!
        if (nextChar in listOf('.', '@')) return position + direction
        if (nextChar == '#') return position

        var i  = 2
        nextChar = map[position + direction * i]!!
        while (nextChar != '#') {
            if (nextChar in listOf('.', '@')) {
                map[position + (direction * i)] = 'O'
                map[position + direction] = '.'
                return position + direction
            }
            i++
            nextChar = map[position + direction * i]!!
        }

        return position
    }
}
