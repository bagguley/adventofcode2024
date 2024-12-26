package day20

import util.*

fun main() {
    println(Part1.calc(testData, 2))
    println(Part1.calc(data, 100))
}

object Part1 {
    fun calc(input: List<String>, limit: Int): Int {
        val (width, height) = input.dimensions()
        val map = BoundedMap(width, height, '#').apply { setWalls(input.findChar('#')) }
        val start = input.findChar('S').first()
        val end = input.findChar('E').first()

        val costFromEnd = map.findAllCost(end) { it.nextNESW() }
        val normalPath = map.findBestPath(start, end) { it.nextNESW() }
        val moves = Direction.ALL.map { it * 2 }

        return normalPath.sumOf { p ->
            moves.count { m -> normalPath.contains(p + m) && (costFromEnd[p]!! - 2 >= costFromEnd[p + m]!! + limit) }
        }
    }
}
