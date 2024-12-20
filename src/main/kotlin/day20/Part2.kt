package day20

import util.*

fun main() {
    println(Part2.calc(testData, 50))
    println(Part2.calc(data, 100))
}

object Part2 {
    fun calc(input: List<String>, saving: Int, cheatLength: Int = 20): Int {
        val width = input[0].length
        val height = input.size
        val map = BoundedMap(width, height, '#').apply { setWalls(input.findChar('#')) }
        val start = input.findChar('S').first()
        val end = input.findChar('E').first()

        val costFromEnd = map.findAllCost(end) { it.nextNESW() }
        val normalPath = map.findBestPath(start, end) { it.nextNESW() }

        val allPairs = normalPath.allLaterPairs().filter { it.first distanceTo it.second <= cheatLength }

        return allPairs.filter { costFromEnd[it.first]!! - (it.first distanceTo it.second) >= costFromEnd[it.second]!! + saving }.size
    }
}