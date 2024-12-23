package day21

import util.*
import util.Direction.*

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Long {
        var sum = 0L
        for (code in input) {
            val shortest = shortest(25, code)
            sum += shortest * code.dropLast(1).toLong()
        }
        return sum
    }

    private fun shortest(depth: Int, code: String): Long {
        return "A$code".toList().windowed(2, 1) {
            (a, b) ->
            val paths = NumPad.paths(a, b)
            val shortest = paths.map { path -> KeyPad.shortestKeyPad(path, depth) }.min()
            shortest
        }.sum()
    }

    object NumPad {
        private val numPad = """
            789
            456
            123
            #0A
        """.trimIndent().split("\n")

        private val paths = mutableMapOf<Pair<Char,Char>, List<String>>()

        fun paths(start: Char, end: Char): List<String> {
            if (paths.containsKey(start to end)) return paths[start to end]!!

            val result = mutableListOf<String>()

            val startPos = numPad.findChar(start).first()
            val endPos = numPad.findChar(end).first()

            val stack = mutableListOf(startPos to "")

            while (stack.isNotEmpty()) {
                val next = stack.removeFirst()
                if (next.first == endPos) {
                    result.add(next.second + "A")
                    continue
                }

                if (next.first.x > endPos.x) {
                    if (numPad.getOr(next.first + WEST, '#') != '#') {
                        stack.add(next.first + WEST to next.second + "<")
                    }
                }
                if (next.first.x < endPos.x) {
                    stack.add(next.first + EAST to next.second + ">")
                }
                if (next.first.y > endPos.y) {
                    stack.add(next.first + NORTH to next.second + "^")
                }
                if (next.first.y < endPos.y) {
                    if (numPad.getOr(next.first + SOUTH, '#') != '#') {
                        stack.add(next.first + SOUTH to next.second + "v")
                    }
                }
            }

            paths[start to end] = result

            return result
        }
    }

    object KeyPad {
        private val shortest = mutableMapOf<Pair<String, Int>, Long>()

        private fun paths(start: Char, end: Char): List<String> {
            return when (start) {
                '^' -> when (end) {
                    '^' -> listOf("A")
                    'A' -> listOf(">A")
                    '<' -> listOf("v<A")
                    'v' -> listOf("vA")
                    '>' -> listOf(">vA", "v>A")
                    else -> throw IllegalStateException()
                }
                'A' -> when (end) {
                    '^' -> listOf("<A")
                    'A' -> listOf("A")
                    '<' -> listOf("<v<A", "v<<A")
                    'v' -> listOf("<vA", "v<A")
                    '>' -> listOf("vA")
                    else -> throw IllegalStateException()
                }
                '<' -> when (end) {
                    '^' -> listOf(">^A")
                    'A' -> listOf(">^>A", ">>^A")
                    '<' -> listOf("A")
                    'v' -> listOf(">A")
                    '>' -> listOf(">>A")
                    else -> throw IllegalStateException()
                }
                'v' -> when (end) {
                    '^' -> listOf("^A")
                    'A' -> listOf("^>A", ">^A")
                    '<' -> listOf("<A")
                    'v' -> listOf("A")
                    '>' -> listOf(">A")
                    else -> throw IllegalStateException()
                }
                '>' -> when (end) {
                    '^' -> listOf("<^A", "^<A")
                    'A' -> listOf("^A")
                    '<' -> listOf("<<A")
                    'v' -> listOf("<A")
                    '>' -> listOf("A")
                    else -> throw IllegalStateException()
                }
                else -> throw IllegalArgumentException()
            }
        }

        fun shortestKeyPad(path: String, depth: Int): Long {
            if (shortest.containsKey(path to depth)) return shortest[path to depth]!!

            if (depth == 0) {
                //println("$path $depth " + path.length.toLong())
                shortest[path to 0] = path.length.toLong()
                return path.length.toLong()
            }

            val nextPaths = "A$path".toList().windowed(2, 1) { (a, b) ->
                val paths = paths(a, b)

                val min = paths.map { p ->
                    shortestKeyPad(p, depth - 1)
                }.min()

                min
            }

            //println("$path $depth " + nextPaths.sum())
            shortest[path to depth] = nextPaths.sum()
            return nextPaths.sum()
        }
    }
}