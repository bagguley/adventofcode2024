package util

data class Vec2(val x: Int, val y: Int)

fun List<String>.findChar(char: Char): List<Vec2> =
    this.flatMapIndexed { y, s -> s.mapIndexed { x, c -> x to c }.filter { it.second == char }.map { Vec2(it.first, y) } }

fun List<String>.getOr(position: Vec2, default: Char): Char =
    this.getOrNull(position.y)?.getOrNull(position.x) ?: default

fun List<String>.setAt(position: Vec2, char: Char) =
    this.toMutableList().apply { this[position.y] = StringBuilder(this[position.y])
        .also { it.setCharAt(position.x, char) }.toString() }

fun <T> List<String>.toVec2Map(transform: (Char) -> T) =
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

operator fun Vec2.minus(other: Vec2): Vec2 = Vec2(this.x - other.x, this.y - other.y)

class Counter {
    private var value = 0

    fun getValue() = value

    fun increment() { value++ }

    operator fun plus(toAdd: Int) { value += toAdd }
    operator fun plus(toAdd: Counter) { value += toAdd.value }
}