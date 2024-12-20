package util

import java.util.*
import kotlin.collections.LinkedHashMap

class Counter {
    private var value = 0

    fun getValue() = value

    fun increment() { value++ }

    operator fun plus(toAdd: Int) { value += toAdd }
    operator fun plus(toAdd: Counter) { value += toAdd.value }
}

class BoundedMap<T>(private val width: Int, private val height: Int, private val wall: T): LinkedHashMap<Vec2, T>() {
    override fun get(key: Vec2): T? {
        if (key.x !in 0..< width || key.y !in 0..< height) return wall
        return super.get(key)
    }

    override fun getOrDefault(key: Vec2, defaultValue: T): T = if (get(key) == null) defaultValue else get(key)!!

    fun findPath(start: Vec2, end: Vec2, next: (Path) -> List<Path>): Int? {
        val seen = mutableMapOf(start to 0)
        val queue = PriorityQueue<Path>().apply { add(Path(start, 0)) }

        while (queue.isNotEmpty()) {
            val path = queue.remove()
            next(path).filter { get(it.position) != wall }.filter { !seen.containsKey(it.position) }.forEach {
                queue.add(it)
                seen[it.position] = it.cost
            }
            if (seen[end] != null) return seen[end]!!
        }

        return null
    }

    fun findBestPath(start: Vec2, end: Vec2, next: (Path) -> List<Path>): List<Vec2> {
        val seen = mutableMapOf(start to listOf(start))
        val queue = PriorityQueue<Path>().apply { add(Path(start, 0)) }

        while (queue.isNotEmpty()) {
            val path = queue.remove()
            next(path).filter { get(it.position) != wall }.filter { !seen.containsKey(it.position) }.forEach {
                queue.add(it)
                seen[it.position] = seen[path.position]!! + it.position
            }
            if (seen[end] != null) return seen[end]!!
        }

        return emptyList()
    }

    fun findAllCost(start: Vec2, next: (Path) -> List<Path>): Map<Vec2, Int> {
        val seen = mutableMapOf(start to 0)
        val queue = PriorityQueue<Path>().apply { add(Path(start, 0)) }

        while (queue.isNotEmpty()) {
            val path = queue.remove()
            next(path).filter { get(it.position) != wall }.filter { !seen.containsKey(it.position) }.forEach {
                queue.add(it)
                seen[it.position] = it.cost
            }
        }

        return seen
    }

    fun setWalls(walls: List<Vec2>) = walls.forEach { this[it] = wall }
}

data class Path(val position: Vec2, val cost: Int): Comparable<Path> {
    override fun compareTo(other: Path): Int = cost.compareTo(other.cost)
}

fun Path.nextNESW(): List<Path> = Direction.ALL.map { Path(position + it, cost + 1) }