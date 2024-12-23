package day22

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(testData2))
    println(Part2.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Long {
        val pairs = input.map { it.toLong() }.map { next(it) }

        val fourChanges = pairs.map { p ->
            p.windowed(4, 1) {
                (a, b, c, d) -> listOf(a.second, b.second, c.second, d.second) to d.first
            }
        }

        val maps = fourChanges.map { ch ->
            val map = mutableMapOf<List<Long>, Long>()

            ch.forEach { p ->
                if (!map.contains(p.first)) {
                    map[p.first] = p.second
                }
            }
            map
        }

        val all = mutableMapOf<List<Long>, Long>()

        maps.forEach { map ->
            map.forEach { me ->
                if (all.containsKey(me.key)) {
                    all[me.key] = all[me.key]!! + me.value
                } else {
                    all[me.key] = me.value
                }
            }
        }

        return all.entries.maxOf { it.value }
    }

    fun next(number: Long): List<Pair<Long, Long>> {
        val result = mutableListOf(number)

        var sn = number
        repeat(2000) {
            sn = (sn shl 6) xor sn
            sn = sn and 16777215

            sn = (sn shr 5) xor sn
            sn = sn and 16777215

            sn = (sn shl 11) xor sn
            sn = sn and 16777215

            result.add(sn)
        }

        return result.map { it.mod(10L) }.windowed(2,1) { (a,b) -> b to b - a }
    } // 4122 high 2096 low
}