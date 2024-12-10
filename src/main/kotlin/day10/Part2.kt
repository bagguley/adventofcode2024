package day10

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
    println(Part2a.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val points = input.flatMapIndexed{ y, l -> l.mapIndexed { x, c -> (x to y) to (c.digitToInt() to mutableListOf<Pair<Int,Int>>()) } }.associate { it }
        val sortedPoints = points.entries.sortedByDescending { it.value.first }
        sortedPoints.forEach { p ->
            if (p.value.first == 9 ) p.value.second.add(p.key)
            else (listOf((0 to -1), (1 to 0), (0 to 1), (-1 to 0)).mapNotNull { points[it.first + p.key.first to it.second + p.key.second] })
                .filter{ it.first == p.value.first + 1 }.forEach { p.value.second.addAll(it.second) }
        }
        return sortedPoints.filter{ it.value.first == 0 }.sumOf { it.value.second.size }
    }
}

object Part2a {
    fun calc(input: List<String>): Int =
        input.flatMapIndexed{y,l->l.mapIndexed{x,c->(x to y) to (c.digitToInt() to mutableListOf<Pair<Int,Int>>())}}
            .associate{it}.also{p->p.entries.sortedBy{-it.value.first}.forEach{e->if(e.value.first==9)e.value.second.add(e.key)
            else(listOf(0 to -1,1 to 0,0 to 1,-1 to 0).mapNotNull{p[it.first+e.key.first to it.second+e.key.second]}).filter{
            it.first==e.value.first+1}.forEach{e.value.second.addAll(it.second)}}}.entries.filter{it.value.first==0}.sumOf{it.value.second.size}
}