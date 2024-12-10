package day6

import util.*

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
    println(Part2a.calc(data))
    println(Part2UsingUtil.calc(data))
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

object Part2a {
    fun calc(input: List<String>): Int = with(input.flatMapIndexed{y,s->s.mapIndexed{x,c->x to c}.filter{it.second=='^'}
        .map{it.first to y}}.first()){input.flatMapIndexed{y,s->s.mapIndexed{x,c->x to c}.filter{it.second=='.'}
        .map{it.first to y}}.map{d->input.toMutableList().apply{this[d.second]=StringBuilder(this[d.second])
        .also{it.setCharAt(d.first,'#')}.toString()}}.count{!doesExit(it,this)}}


    private fun doesExit(input: List<String>, start: Pair<Int,Int>): Boolean {
        val visited: MutableSet<Pair<Pair<Int,Int>,Pair<Int,Int>>> = mutableSetOf(start to (0 to -1))
        var pos = start
        var dir = 0 to -1

        while (true) {
            when (input.getOrNull(pos.second + dir.second)?.getOrNull(pos.first + dir.first) ?: 'X') {
                '.', '^' -> { pos = pos.first + dir.first to pos.second + dir.second
                    if (pos to dir in visited) return false
                    visited.add(pos to dir) }
                '#' -> dir = -dir.second to dir.first
                else -> return true
            }
        }
    }
}

object Part2UsingUtil {
    fun calc(input: List<String>): Int {
        val start = input.findChar('^').first()
        val dots = input.findChar('.')

        return dots.map { d -> input.setAt(d, '#') }.count { !doesExit(it, start) }
    }

    private fun doesExit(input: List<String>, start: Vec2): Boolean {
        var direction = Direction.NORTH
        val visited = mutableSetOf(start to direction)

        var position = start
        var current = '^'

        while (current != 'X') {
            when (val next = input.getOr(position + direction, 'X')) {
                '.', '^' -> {
                    position += direction
                    if (position to direction in visited) return false
                    visited.add(position to direction)
                    current = next
                }
                '#' -> direction = direction.clockwise90()
                else -> current = 'X'
            }
        }

        return true
    }
}