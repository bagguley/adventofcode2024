package day20

import util.*

fun main() {
    println(Part1.calc(testData, 2))
    println(Part1.calc(data, 100))
}

object Part1 {
    fun calc(input: List<String>, limit: Int): Int {
        val width = input[0].length
        val height = input.size
        val map = BoundedMap(width, height, '#')
        val walls = input.findChar('#')
        val start = input.findChar('S').first()
        val end = input.findChar('E').first()

        walls.forEach { map[it] = '#' }

        val costFromEnd = map.findAllCost(end) { path -> Direction.ALL.map { Path(path.position + it, path.cost + 1) } }
        val normalPath = map.findBestPath(start, end) { path -> Direction.ALL.map { Path(path.position + it, path.cost + 1) } }
        val normalCost = normalPath.size - 1

        val moves = Direction.ALL.map { it * 2 }
        println("Normal cost $normalCost")
        val res = normalPath.map { p ->
            moves.count { m -> normalPath.contains(p + m) && (costFromEnd[p]!! - 2 >= costFromEnd[p + m]!! + limit) }
        }.sum()

        return res
    }
}
