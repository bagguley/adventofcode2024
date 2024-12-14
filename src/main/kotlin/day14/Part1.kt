package day14

import util.*

fun main() {
    println(Part1.calc(testData, width = 11, height = 7))
    println(Part1.calc(data, width = 101, height = 103))
}

object Part1 {
    fun calc(input: List<String>, width: Int, height: Int): Int {
        val robots = load(input)

        val moved = robots.map { it.move(100) }.map { robot ->
            val newX = (robot.position.x % width).let { if (it < 0) it + width else it }
            val newY = (robot.position.y % height).let { if (it < 0) it + height else it }

            Robot(Vec2(newX, newY), robot.direction)
        }

        val centreX = width / 2
        val centreY = height / 2

        val q1 = moved.filter { it.position.x < centreX && it.position.y < centreY }
        val q2 = moved.filter { it.position.x > centreX && it.position.y < centreY }
        val q3 = moved.filter { it.position.x < centreX && it.position.y > centreY }
        val q4 = moved.filter { it.position.x > centreX && it.position.y > centreY }

        return q1.size * q2.size * q3.size * q4.size
    }

    private fun load(input: List<String>): List<Robot> {
        return input.map {
            val (_, posX, posY, dirX, dirY) = "p=(-?\\d+),(-?\\d+) v=(-?\\d+),(-?\\d+)".toRegex().find(it)!!.groupValues
            Robot(Vec2(posX.toInt(), posY.toInt()), Vec2(dirX.toInt(), dirY.toInt()))
        }
    }

    data class Robot(val position: Vec2, val direction: Vec2) {
        fun move(times: Int) = Robot(position + direction * times, direction)
    }
}
