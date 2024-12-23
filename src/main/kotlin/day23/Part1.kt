package day23

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Int {
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

        var count = 0

        val seen = mutableSetOf<Set<String>>()
        for (e in map) {
            val f = e.key
            for (v in e.value) {
                for (p in map[v]!!) {
                    if (setOf(f,v,p).let { !seen.contains(it) && it.any { it.startsWith('t' ) } } ) {
                        if (map[p]!!.contains(f)) {
                            count++
                            seen.add(setOf(f, v, p))
                        }
                    }
                }
            }
        }

        return count
    }
}