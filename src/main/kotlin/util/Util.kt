package util

import java.math.BigInteger

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

enum class Direction(val x: Int, val y: Int) {
    NORTH(0, -1), EAST(1, 0), SOUTH(0, 1), WEST(-1, 0);

    fun clockwise90(): Direction =
        when (this) {
            NORTH -> EAST
            EAST -> SOUTH
            SOUTH -> WEST
            WEST -> NORTH
    }

    companion object {
        val ALL = listOf(NORTH, EAST, SOUTH, WEST)
    }
}

operator fun Vec2.plus(direction: Direction): Vec2 = Vec2(this.x + direction.x, this.y + direction.y)
operator fun Vec2.plus(other: Vec2): Vec2 = Vec2(this.x + other.x, this.y + other.y)
operator fun Vec2.minus(direction: Direction): Vec2 = Vec2(this.x - direction.x, this.y - direction.y)
operator fun Vec2.minus(other: Vec2): Vec2 = Vec2(this.x - other.x, this.y - other.y)

operator fun Direction.plus(vector: Vec2): Vec2 = Vec2(this.x + vector.x, this.y + vector.y)
operator fun Direction.plus(other: Direction): Vec2 = Vec2(this.x + other.x, this.y + other.y)
operator fun Direction.minus(vector: Vec2): Vec2 = Vec2(this.x - vector.x, this.y - vector.y)
operator fun Direction.minus(other: Direction): Vec2 = Vec2(this.x - other.x, this.y - other.y)

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