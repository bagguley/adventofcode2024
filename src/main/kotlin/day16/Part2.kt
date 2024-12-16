package day16

import util.*
import util.Direction.EAST
import java.util.*

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(testData2))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val start = input.findChar('S').first()
        val end = input.findChar('E').first()
        val routes = mutableListOf<Path>()

        val seen = mutableMapOf(start to EAST to 0)

        val queue = PriorityQueue<Path>().apply { add(Path(start, EAST, 0, listOf(start))) }

        while (queue.any { it.cost <= (routes.getOrNull(0)?.cost ?: Int.MAX_VALUE) } ) {
            val current = queue.remove()!!

            if (current.position == end) {
                routes.add(current)
                continue
            }

            val nextMove = Path(current.position + current.direction, current.direction, current.cost + 1, current.route + (current.position + current.direction))
            val nextTurnCW = Path(current.position, current.direction.clockwise90(), current.cost + 1000, current.route)
            val nextTurnCCW = Path(current.position, current.direction.anticlockwise90(), current.cost + 1000, current.route)

            if (input.getOr(nextMove.position, '#') != '#') {
                if ((seen[nextMove.toPair()] ?: Int.MAX_VALUE) >= nextMove.cost) {
                    queue.add(nextMove)
                    seen[nextMove.toPair()] = nextMove.cost
                }
            }

            listOf(nextTurnCW, nextTurnCCW).forEach {
                if ((seen[it.toPair()] ?: Int.MAX_VALUE) >= it.cost) {
                    queue.add(it)
                    seen[it.toPair()] = it.cost
                }
            }
        }

        return routes.flatMap { it.route }.toSet().size
    }

    data class Path(val position: Vec2, val direction: Direction, val cost: Int, val route: List<Vec2>): Comparable<Path> {
        fun toPair() = position to direction

        override fun compareTo(other: Path): Int {
            return cost.compareTo(other.cost)
        }
    }
}