package day20

import util.*

fun main() {
    println(Part2.calc(testData, 50))
    println(Part2.calc(data, 100))
    println(Part2a.calc(data, 100))
}

object Part2 {
    fun calc(input: List<String>, saving: Int, cheatLength: Int = 20): Int {
        val (width, height) = input.dimensions()
        val map = BoundedMap(width, height, '#').apply { setWalls(input.findChar('#')) }
        val start = input.findChar('S').first()
        val end = input.findChar('E').first()

        val costFromEnd = map.findAllCost(end) { it.nextNESW() }
        val normalPath = map.findBestPath(start, end) { it.nextNESW() }

        val allPairs = normalPath.allLaterPairs(cheatLength).filter { it.first distanceTo it.second <= cheatLength }

        return allPairs.filter { costFromEnd[it.first]!! - (it.first distanceTo it.second) >= costFromEnd[it.second]!! + saving }.size
    }
}

object Part2a {
    fun calc(input: List<String>, saving: Int, cheatLength: Int = 20): Int {
        val map = input.toBoundedMap('#')
        val start = input.findChar('S').first()
        val end = input.findChar('E').first()

        val costFromEnd = map.findAllCost(end) { it.nextNESW() }
        val normalPath = map.findBestPath(start, end) { it.nextNESW() }

        val allPairs = normalPath.allLaterPairs(cheatLength).filter { it.first distanceTo it.second <= cheatLength }

        return allPairs.filter { costFromEnd[it.first]!! - (it.first distanceTo it.second) >= costFromEnd[it.second]!! + saving }.size
    }
}