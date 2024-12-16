package day16

import util.*
import util.Direction.EAST
import java.util.PriorityQueue

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(testData2))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val start = input.findChar('S').first()
        val end = input.findChar('E').first()

        val seen = mutableMapOf((start to EAST) to 0)

        val queue = PriorityQueue<Path>().apply { add(Path(start, EAST, 0)) }

        while (queue.first().position != end) {
            val current = queue.remove()!!
            val nextMove = Path(current.position + current.direction, current.direction, current.cost + 1)
            val nextTurnCW = Path(current.position, current.direction.clockwise90(), current.cost + 1000)
            val nextTurnCCW = Path(current.position, current.direction.anticlockwise90(), current.cost + 1000)

            if (input.getOr(nextMove.position, '#') != '#') {
                if (!seen.contains(nextMove.toPair()) || seen[nextMove.toPair()]!! > current.cost + 1) {
                    queue.add(nextMove)
                    seen[nextMove.toPair()] = current.cost + 1
                }
            }

            listOf(nextTurnCW, nextTurnCCW).forEach {
                if ((seen[it.toPair()] ?: Int.MAX_VALUE) > it.cost) {
                    queue.add(it)
                    seen[it.toPair()] = it.cost
                }
            }
        }

        return queue.first().cost
    }

    data class Path(val position: Vec2, val direction: Direction, val cost: Int): Comparable<Path> {
        fun toPair() = position to direction

        override fun compareTo(other: Path): Int {
            return cost.compareTo(other.cost)
        }
    }
}
