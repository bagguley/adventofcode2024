package day2

import kotlin.math.abs
import kotlin.math.sign

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
    println(Part2a.calc(data))
    println(Part2b.calc(data))
    println(Part2c.calc(data))
}

object Part2 {
    fun calc(input: List<String>): Int {
        val list = load(input)

        return list.count { it.isNearlySafe() }
    }

    private fun load(input: List<String>): List<List<Int>> {
        return input.map { it.split(" ").map { it.toInt() } }
    }

    private fun List<Int>.isNearlySafe(): Boolean {
        return isSafe() || indices.map { removeAt(it) }.any { it.isSafe() }
    }

    private fun List<Int>.isSafe(): Boolean {
        val validGap = windowed(2) { abs(it[0] - it[1]) }.all { it <= 3 }
        val validDirection = windowed(2) { (it[0] - it[1]).sign }.toSet().size == 1
        return validGap && validDirection
    }

    private fun List<Int>.removeAt(removeIndex: Int): List<Int> = filterIndexed { index, _ -> index != removeIndex }
}

object Part2a {
    fun calc(input: List<String>): Int =
        input.map { it.split(" ").map { it.toInt() } }.count {
            (it.windowed(2) { abs(it[0] - it[1]) }.all { it <= 3 } &&
             it.windowed(2) { (it[0] - it[1]).sign }.toSet().size == 1) ||
                it.indices.map { r -> it.filterIndexed { index, _ -> index != r } }
                .any { it.windowed(2) { abs(it[0] - it[1]) }.all { it <= 3 } &&
                       it.windowed(2) { (it[0] - it[1]).sign }.toSet().size == 1 }
    }
}

object Part2b {
    fun calc(input: List<String>): Int = input.map{it.split(" ").map{it.toInt()}}.count{
            it.isSafe()||it.indices.map{r->it.filterIndexed{index,_->index!=r}}.any{ it.isSafe()}}

    private fun List<Int>.isSafe(): Boolean = windowed(2) { abs(it[0] - it[1]) }.all { it <= 3 } &&
            windowed(2) { (it[0] - it[1]).sign }.toSet().size == 1
}

object Part2c {
    fun calc(input: List<String>): Int {
        fun List<Int>.isSafe() = windowed(2){abs(it[0]-it[1])}.all{it<=3}&&
                windowed(2){(it[0]-it[1]).sign}.toSet().size==1
        return input.map{it.split(" ").map{it.toInt()}}.count{it.isSafe()||
                it.indices.map{r->it.filterIndexed{index,_->index!=r}}.any{it.isSafe()}}
    }
}