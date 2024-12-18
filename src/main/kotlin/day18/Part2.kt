package day18

import util.*
import java.util.*

fun main() {
    println(Part2.calc(testData, 7))
    println(Part2.calc(data, 71))
    println(Part2UsingUtil.calc(data, 71))
}

object Part2 {
    fun calc(input: List<String>, dimensions: Int): Vec2 {
        val allCorruptions = load(input)
        val start = Vec2(0, 0)
        val end = Vec2(dimensions - 1, dimensions - 1)

        for (i in 1..dimensions * dimensions) {
            val corruptions = allCorruptions.take(i)
            val map = BoundedMap(dimensions, dimensions, '#')
            corruptions.forEach { map[it] = '#' }

            val exits = exits(map, start, end)
            if (!exits) return corruptions.last()
        }
        return Vec2(0,0)
    }

    private fun exits(map: BoundedMap<Char>, start: Vec2, end: Vec2): Boolean {
        val seen = mutableMapOf(start to 0)

        val queue = PriorityQueue<Path>().apply { add(Path(start, 0)) }

        while (queue.isNotEmpty()) {
            val path = queue.remove()
            val next = Direction.ALL.map { path.position + it }.filter { map.getOrDefault(it, '.') == '.' }.filter { !seen.containsKey(it) }
            next.forEach {
                queue.add(Path(it, path.cost + 1))
                seen[it] = path.cost + 1
            }
            if (seen[end] != null) return true
        }
        return false
    }

    private fun load(input: List<String>): List<Vec2> = input.map { it.split(",").let { Vec2(it[0].toInt(), it[1].toInt()) } }

    private data class Path(val position: Vec2, val cost: Int): Comparable<Path> {
        override fun compareTo(other: Path): Int = cost.compareTo(other.cost)
    }
}

object Part2UsingUtil {
    fun calc(input: List<String>, dimensions: Int): Vec2 {
        val allCorruptions = load(input)
        val start = Vec2(0, 0)
        val end = Vec2(dimensions - 1, dimensions - 1)

        for (i in 1..dimensions * dimensions) {
            val corruptions = allCorruptions.take(i)
            val map = BoundedMap(dimensions, dimensions, '#')
            corruptions.forEach { map[it] = '#' }

            val cost = map.findPath(start, end) { path -> Direction.ALL.map { Path(path.position + it, path.cost + 1) } }
            if (cost == null) return corruptions.last()
        }
        return Vec2(0,0)
    }

    private fun load(input: List<String>): List<Vec2> = input.map { it.split(",").let { Vec2(it[0].toInt(), it[1].toInt()) } }
}