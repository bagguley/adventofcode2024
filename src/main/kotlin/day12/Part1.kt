package day12

import util.*
import util.Direction.*
import util.Direction.Companion.ALL

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
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

        return distinctSets.sumOf { group ->
            val perimeter = group.sumOf { it.second }
            val count = group.count()
            perimeter * count
        }
    }
}
