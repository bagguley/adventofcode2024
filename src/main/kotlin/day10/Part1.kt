package day10

import util.*
import util.Direction.Companion.ALL

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
    println(Part1a.calc(data))
    println(Part1UsingUtil.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
        val points = input.flatMapIndexed{ y, l -> l.mapIndexed { x, c -> (x to y) to (c.digitToInt() to mutableSetOf<Pair<Int,Int>>()) } }.associate { it }
        val sortedPoints = points.entries.sortedByDescending { it.value.first }
        sortedPoints.forEach { p ->
            if (p.value.first == 9 ) p.value.second.add(p.key)
            else (listOf((0 to -1), (1 to 0), (0 to 1), (-1 to 0)).mapNotNull { points[it.first + p.key.first to it.second + p.key.second] })
                .filter{ it.first == p.value.first + 1 }.forEach { p.value.second.addAll(it.second) }
        }
        return sortedPoints.filter{ it.value.first == 0 }.sumOf { it.value.second.size }
    }
}

object Part1a {
    fun calc(input: List<String>): Int =
        input.flatMapIndexed{y,l->l.mapIndexed{x,c->(x to y) to (c.digitToInt() to mutableSetOf<Pair<Int,Int>>())}}
            .associate{it}.also{p->p.entries.sortedBy{-it.value.first}.forEach{e->if(e.value.first==9)e.value.second.add(e.key)
            else(listOf(0 to -1,1 to 0,0 to 1,-1 to 0).mapNotNull{p[it.first+e.key.first to it.second+e.key.second]}).filter{
            it.first==e.value.first+1}.forEach{e.value.second.addAll(it.second)}}}.entries.filter{it.value.first==0}.sumOf{it.value.second.size}
}

object Part1UsingUtil {
    fun calc(input: List<String>): Int {
        val vec2map = input.toVec2Map { it.digitToInt() to mutableSetOf<Vec2>() }
        val sorted = vec2map.entries.sortedBy { -it.value.first }
        sorted.forEach { p ->
            if (p.value.first == 9) p.value.second.add(p.key)
            else (ALL.mapNotNull { vec2map[p.key + it] })
                .filter{ it.first == p.value.first + 1 }.forEach { p.value.second.addAll(it.second) }
        }
        return sorted.filter{ it.value.first == 0 }.sumOf { it.value.second.size }
    }
}