package day12

import util.Direction
import util.Direction.Companion.ALL
import util.Direction.*
import util.Vec2
import util.getOr
import util.plus

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(testData2))
    println(Part2.calc(testData3))
    println(Part2.calc(testData4))
    println(Part2.calc(testData5))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val map = mutableMapOf<Vec2, MutableSet<Pair<Vec2, Int>>>()

        for (y in input.indices) {
            for (x in input[y].indices) {
                val current = Vec2(x, y)
                val chr = input[y][x]

                val neighbours = ALL.map { current + it to input.getOr(current + it, '.') }.filter { it.second != '.' }
                val similar = neighbours.filter { it.second == chr }
                val edges = 4 - similar.size

                val left = input.getOr(current + WEST, '.')
                if (left == chr) {
                    val leftGroup = map[current + WEST]!!
                    leftGroup.add(current to edges)
                    map[current] = leftGroup
                } else {
                    val group = mutableSetOf(current to edges)
                    map[current] = group
                }
            }
        }

        val rows = map.entries.groupBy { it.key.y }.map { it.value.map { it.value }.distinct() }

        rows.forEach { row ->
            row.forEach { group ->
                val chr = input[group.first().first.y][group.first().first.x]
                val grp = map[group.first().first]!!
                val allBelowValues = group.mapNotNull {
                    map[it.first + SOUTH]
                }.distinct().flatten().filter {
                    input[it.first.y][it.first.x] == chr
                }

                grp.addAll(allBelowValues)
                allBelowValues.forEach { map[it.first] = grp }
            }
        }

        val distinctSets = map.values.distinct()

        val edges = distinctSets.map { group ->
            val edgeVectors = calcEdgeVectors(group, input)
            val mergedEdgeVectors = mergeEdgeVectors(edgeVectors)
            val count = group.count()
            println("$count, ${mergedEdgeVectors.size}")
            mergedEdgeVectors.size * count
        }

        return edges.sum()
    }

    private fun calcEdgeVectors(group: Set<Pair<Vec2, Int>>, garden: List<String>): List<Pair<Pair<Vec2, Vec2>, Direction>> {
        return group.flatMap {
            val x = it.first.x
            val y = it.first.y
            val list = mutableListOf<Pair<Pair<Vec2, Vec2>, Direction>>()
            val current = garden[y][x]
            val north = garden.getOr(it.first + NORTH, '.')
            val east = garden.getOr(it.first + EAST, '.')
            val west = garden.getOr(it.first + WEST, '.')
            val south = garden.getOr(it.first + SOUTH, '.')

            if (current != north) {
                list.add((Vec2(x, y) to Vec2(x + 1, y)) to NORTH)
            }
            if (current != east) {
                list.add((Vec2(x + 1, y) to Vec2(x + 1, y + 1)) to EAST)
            }
            if (current != south) {
                list.add((Vec2(x, y + 1) to Vec2(x + 1, y + 1)) to SOUTH)
            }
            if (current != west) {
                list.add((Vec2(x, y) to Vec2(x, y + 1)) to WEST)
            }
            list
        }
    }

    private fun mergeEdgeVectors(edgeVectors: List<Pair<Pair<Vec2, Vec2>, Direction>>): List<Pair<Pair<Vec2, Vec2>, Direction>> {
        var next = mutableListOf<Pair<Pair<Vec2, Vec2>, Direction>>()
        var remaining = edgeVectors.toMutableList()

        while (remaining.isNotEmpty()) {
            remaining.sortBy { it.first.first.x }
            val edge = remaining.first()
            val match = remaining.find { it != edge && edge.first.second == it.first.first && edge.first.first.y == edge.first.first.y && edge.second == it.second}
            if (match != null) {
                remaining.add((edge.first.first to match.first.second) to edge.second)
                remaining.remove(edge)
                remaining.remove(match)
            } else {
                remaining.remove(edge)
                next.add(edge)
            }
        }

        remaining = next.toMutableList()
        next = mutableListOf()

        while (remaining.isNotEmpty()) {
            remaining.sortBy { it.first.first.y }
            val edge = remaining.first()
            val match = remaining.find { it != edge && edge.first.second == it.first.first && edge.first.first.x == edge.first.second.x && edge.second == it.second}
            if (match != null) {
                remaining.add((edge.first.first to match.first.second) to edge.second)
                remaining.remove(edge)
                remaining.remove(match)
            } else {
                remaining.remove(edge)
                next.add(edge)
            }
        }

        return next
    }
}