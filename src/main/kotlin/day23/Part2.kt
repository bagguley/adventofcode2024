package day23

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): String {
        val lan = input.map { it.split("-") }

        val map = mutableMapOf<String, MutableSet<String>>()

        lan.forEach { (a, b) ->
            if (map.containsKey(a)) {
                map[a]!!.add(b)
            } else {
                map[a] = mutableSetOf(b)
            }

            if (map.containsKey(b)) {
                map[b]!!.add(a)
            } else {
                map[b] = mutableSetOf(a)
            }
        }


        val max = bk(setOf(), map.keys.toMutableSet(), mutableSetOf(), map)
        return max.sorted().joinToString (",")
    }

    fun count(map: Map<String, MutableSet<String>>) {
        val countMap = mutableMapOf<String, Int>()

        for (f in map) {
            val s = f.key
            var count = 0
            for (t in f.value) {
                if (map[t]!!.contains(s)) {
                    count++
                }
            }
            countMap[s] = count
        }

        val max = countMap.maxBy { it.value }
        println(max)
    }

    private fun bk(r: Set<String>, p: MutableSet<String>, x: MutableSet<String>, edges: Map<String, Set<String>> ): Set<String> {
        if (p.isEmpty() && x.isEmpty()) {
            return r
        }

        var largest = setOf<String>()
        for (vertex in p.toMutableSet()) {
            val newR = r.toMutableSet()
            newR.add(vertex)

            val neighbours = edges[vertex]!!
            val newP = p.intersect(neighbours).toMutableSet()
            val newX = x.intersect(neighbours).toMutableSet()
            val group = bk(newR, newP, newX, edges)
            if (group.size > largest.size) {
                largest = group
            }

            p.remove(vertex)
            x.add(vertex)
        }

        return largest
    }
}