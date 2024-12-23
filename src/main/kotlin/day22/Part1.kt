package day22

fun main() {
    println(Part1.calc(testData))
    println(Part1.calc(data))
}

object Part1 {
    fun calc(input: List<String>): Long {
        return input.map { it.toLong() }.sumOf { next(it) }
    }

    fun next(number: Long): Long {
        var sn = number

        repeat(2000) {
            sn = (sn shl 6) xor sn
            sn = sn and 16777215

            sn = (sn shr 5) xor sn
            sn = sn and 16777215

            sn = (sn shl 11) xor sn
            sn = sn and 16777215
        }

        return sn
    }
}