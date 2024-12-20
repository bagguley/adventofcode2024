package util

import java.math.BigInteger

data class SimultaneousResult(val quotient: BigInteger, val remainder: BigInteger)

class SimultaneousBuilder {
    private val listA: MutableList<BigInteger> = mutableListOf()
    private val listB: MutableList<BigInteger> = mutableListOf()
    private val listZ: MutableList<BigInteger> = mutableListOf()

    object A
    object B
    object Z

    operator fun A.times(value: BigInteger): A {
        listA.add(value)
        return A
    }

    operator fun B.times(value: BigInteger): B {
        listB.add(value)
        return B
    }

    @Suppress("UNUSED_PARAMETER")
    operator fun A.plus(b: B): Z {
        return Z
    }

    infix fun Z.eq(value: BigInteger) {
        listZ.add(value)
    }

    fun solve(): Pair<SimultaneousResult, SimultaneousResult> {
        val bTop = (listZ[0] * listA[1]) - (listZ[1] * listA[0])
        val bSub = (listA[1] * listB[0]) - (listA[0] * listB[1])
        val bQuot = bTop.div(bSub)
        val bRem = bTop.rem(bSub)


        val aTop = listZ[1] - listB[1] * bQuot
        val aSub = listA[1]
        val aQuot = aTop.div(aSub)
        val aRem = aTop.remainder(aSub)

        return SimultaneousResult(aQuot, aRem) to SimultaneousResult(bQuot, bRem)
    }
}

fun solveSimultaneous(block: SimultaneousBuilder.() -> Unit): Pair<SimultaneousResult, SimultaneousResult> {
    val builder = SimultaneousBuilder()
    builder.apply(block)
    return builder.solve()
}