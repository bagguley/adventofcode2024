package day14

import util.*

fun main() {
    println(Part2.calc(data, 101, 103))
}

object Part2 {
    fun calc(input: List<String>, width: Int, height: Int): Int {
        val repeatAt = width * height
        var robots = load(input)
        var count = 0

        for (i in 0..repeatAt) {
            if (containsColumn(robots)) break
            robots = move(robots, width, height)
            count++
        }

        print(robots, width, height).print()

        return count
    }

    private fun move(robots: List<Robot>, width: Int, height: Int): List<Robot> {
        return robots.map { it.move(1) }.map { robot ->
            val newX = (robot.position.x % width).let { if (it < 0) it + width else it }
            val newY = (robot.position.y % height).let { if (it < 0) it + height else it }

            Robot(Vec2(newX, newY), robot.direction)
        }
    }

    private fun load(input: List<String>): List<Robot> {
        return input.map {
            val (_, posX, posY, dirX, dirY) = "p=(-?\\d+),(-?\\d+) v=(-?\\d+),(-?\\d+)".toRegex().find(it)!!.groupValues
            Robot(Vec2(posX.toInt(), posY.toInt()), Vec2(dirX.toInt(), dirY.toInt()))
        }
    }


    private fun print(robots: List<Robot>, width: Int, height: Int): List<String> {
        val result = mutableListOf<String>()
        for (y in 0..<height) {
            val line = StringBuilder()
            for (x in 0..<width) {
                val robot = if (robots.any { it.position == Vec2(x,y) }) 'R' else '.'
                line.append(robot)
            }
            result.add(line.toString())
        }
        return result
    }

    private fun containsColumn(robots: List<Robot>): Boolean {
        return robots.any { robot ->
            val posBelow = (1..10).map { Direction.SOUTH * it }
            posBelow.all { pos ->
                robots.any { r -> ; r.position == (pos + robot.position) }
            }
        }
    }

    data class Robot(val position: Vec2, val direction: Vec2) {
        fun move(times: Int) = Robot(position + direction * times, direction)
    }
}