package day18

import util.*
import java.util.PriorityQueue

fun main() {
    println(Part1.calc(testData, 7, 12))
    println(Part1.calc(data, 71, 1024))
    println(Part1UsingUtil.calc(data, 71, 1024))
}

object Part1 {
    fun calc(input: List<String>, dimensions: Int, count: Int): Int {
        val corruptions = load(input).take(count)
        val map = BoundedMap(dimensions, dimensions, '#')

        corruptions.forEach { map[it] = '#' }

        val start = Vec2(0, 0)
        val end = Vec2(dimensions - 1, dimensions - 1)
        val seen = mutableMapOf(start to 0)

        val queue = PriorityQueue<Path>().apply { add(Path(start, 0)) }

        while (queue.isNotEmpty()) {
            val path = queue.remove()
            val next = Direction.ALL.map { path.position + it }.filter { map.getOrDefault(it, '.') == '.' }.filter { !seen.containsKey(it) }
            next.forEach {
                queue.add(Path(it, path.cost + 1))
                seen[it] = path.cost + 1
            }
            if (seen[end] != null) return seen[end]!!
        }

        return -1
    }

    private fun load(input: List<String>): List<Vec2> = input.map { it.split(",").let { Vec2(it[0].toInt(), it[1].toInt()) } }

    private data class Path(val position: Vec2, val cost: Int): Comparable<Path> {
        override fun compareTo(other: Path): Int = cost.compareTo(other.cost)
    }
}

object Part1UsingUtil {
    fun calc(input: List<String>, dimensions: Int, count: Int): Int {
        val start = Vec2(0, 0)
        val end = Vec2(dimensions - 1, dimensions - 1)
        val map = BoundedMap(dimensions, dimensions, '#')
        val corruptions = load(input).take(count)

        corruptions.forEach { map[it] = '#' }

        val score = map.findPath(start, end) { path -> Direction.ALL.map { Path(path.position + it, path.cost + 1) } }

        return score ?: -1
    }

    private fun load(input: List<String>): List<Vec2> = input.map { it.split(",").let { Vec2(it[0].toInt(), it[1].toInt()) } }
}