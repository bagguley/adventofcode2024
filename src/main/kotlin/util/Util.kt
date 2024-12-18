package util

import java.math.BigInteger
import java.util.*
import kotlin.collections.LinkedHashMap

data class Vec2(val x: Int, val y: Int)

fun List<String>.findChar(char: Char): List<Vec2> =
    this.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }.filter { it.second == char }.map { Vec2(it.first, y) } }

fun List<String>.getOr(position: Vec2, default: Char): Char =
    this.getOrNull(position.y)?.getOrNull(position.x) ?: default

fun List<String>.setAt(position: Vec2, char: Char) =
    this.toMutableList().apply { this[position.y] = StringBuilder(this[position.y])
        .also { it.setCharAt(position.x, char) }.toString() }

fun <T> List<String>.toVec2Map(transform: (Char) -> T): Map<Vec2, T> =
    this.flatMapIndexed { y, l -> l.mapIndexed { x, c -> Vec2(x, y) to (transform(c)) } }.associate { it }

fun List<String>.print() {
    for (y in indices) {
        val row = get(y)
        for (x in row.indices) {
            print(get(y)[x])
        }
        println()
    }
}

enum class Direction(val x: Int, val y: Int) {
    NORTH(0, -1), EAST(1, 0), SOUTH(0, 1), WEST(-1, 0);

    fun clockwise90(): Direction =
        when (this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
        }

    fun anticlockwise90(): Direction =
        when (this) {
            NORTH -> WEST
            EAST -> NORTH
            SOUTH -> EAST
            WEST -> SOUTH
        }

    companion object {
        val ALL = listOf(NORTH, EAST, SOUTH, WEST)
    }
}

operator fun Vec2.plus(direction: Direction): Vec2 = Vec2(this.x + direction.x, this.y + direction.y)
operator fun Vec2.plus(other: Vec2): Vec2 = Vec2(this.x + other.x, this.y + other.y)
operator fun Vec2.minus(direction: Direction): Vec2 = Vec2(this.x - direction.x, this.y - direction.y)
operator fun Vec2.minus(other: Vec2): Vec2 = Vec2(this.x - other.x, this.y - other.y)
operator fun Vec2.times(times: Int): Vec2 = Vec2(this.x * times, this.y * times)

operator fun Direction.plus(vector: Vec2): Vec2 = Vec2(this.x + vector.x, this.y + vector.y)
operator fun Direction.plus(other: Direction): Vec2 = Vec2(this.x + other.x, this.y + other.y)
operator fun Direction.minus(vector: Vec2): Vec2 = Vec2(this.x - vector.x, this.y - vector.y)
operator fun Direction.minus(other: Direction): Vec2 = Vec2(this.x - other.x, this.y - other.y)
operator fun Direction.times(times: Int): Vec2 = Vec2(this.x * times, this.y * times)

class Counter {
    private var value = 0

    fun getValue() = value

    fun increment() { value++ }

    operator fun plus(toAdd: Int) { value += toAdd }
    operator fun plus(toAdd: Counter) { value += toAdd.value }
}

val COMPASS_8_INT: List<Pair<Int, Int>> = listOf(0 to -1, 1 to -1, 1 to 0, 1 to 1, 0 to 1, -1 to 1, -1 to 0, -1 to -1)
val COMPASS_8_VEC2: List<Vec2> = listOf(Vec2(0, -1), Vec2(1, -1), Vec2(1, 0), Vec2(1, 1), Vec2(0, 1), Vec2(-1, 1), Vec2(-1, 0), Vec2(-1, -1))

fun solveSimultaneous(block: SimultaneousBuilder.() -> Unit): Pair<SimultaneousResult, SimultaneousResult> {
    val builder = SimultaneousBuilder()
    builder.apply(block)
    return builder.solve()
}

class SimultaneousBuilder {
    private val listA: MutableList<BigInteger> = mutableListOf()
    private val listB: MutableList<BigInteger> = mutableListOf()
    private val listZ: MutableList<BigInteger> = mutableListOf()

    object A
    object B
    object Z

    operator fun A.times(value: BigInteger): A {
        listA.add(value)
        return A
    }

    operator fun B.times(value: BigInteger): B {
        listB.add(value)
        return B
    }

    @Suppress("UNUSED_PARAMETER")
    operator fun A.plus(b: B): Z {
        return Z
    }

    infix fun Z.eq(value: BigInteger) {
        listZ.add(value)
    }

    fun solve(): Pair<SimultaneousResult, SimultaneousResult> {
        val bTop = (listZ[0] * listA[1]) - (listZ[1] * listA[0])
        val bSub = (listA[1] * listB[0]) - (listA[0] * listB[1])
        val bQuot = bTop.div(bSub)
        val bRem = bTop.rem(bSub)


        val aTop = listZ[1] - listB[1] * bQuot
        val aSub = listA[1]
        val aQuot = aTop.div(aSub)
        val aRem = aTop.remainder(aSub)

        return SimultaneousResult(aQuot, aRem) to SimultaneousResult(bQuot, bRem)
    }
}

data class SimultaneousResult(val quotient: BigInteger, val remainder: BigInteger)

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
}

data class Path(val position: Vec2, val cost: Int): Comparable<Path> {
    override fun compareTo(other: Path): Int = cost.compareTo(other.cost)
}