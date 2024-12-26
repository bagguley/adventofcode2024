package util

import util.Direction.*

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

operator fun Direction.plus(vector: Vec2): Vec2 = Vec2(this.x + vector.x, this.y + vector.y)
operator fun Direction.plus(other: Direction): Vec2 = Vec2(this.x + other.x, this.y + other.y)
operator fun Direction.minus(vector: Vec2): Vec2 = Vec2(this.x - vector.x, this.y - vector.y)
operator fun Direction.minus(other: Direction): Vec2 = Vec2(this.x - other.x, this.y - other.y)
operator fun Direction.times(times: Int): Vec2 = Vec2(this.x * times, this.y * times)

fun Char.toDirection() = when (this) {
    '^' -> NORTH
    '>' -> EAST
    'v' -> SOUTH
    '<' -> WEST
    else -> throw IllegalArgumentException("Bad direction: $this")
}

val COMPASS_8_INT: List<Pair<Int, Int>> = listOf(0 to -1, 1 to -1, 1 to 0, 1 to 1, 0 to 1, -1 to 1, -1 to 0, -1 to -1)
val COMPASS_8_VEC2: List<Vec2> = listOf(Vec2(0, -1), Vec2(1, -1), Vec2(1, 0), Vec2(1, 1), Vec2(0, 1), Vec2(-1, 1), Vec2(-1, 0), Vec2(-1, -1))
val NESW = listOf(Direction.NORTH, Direction.EAST, Direction.SOUTH, Direction.WEST)