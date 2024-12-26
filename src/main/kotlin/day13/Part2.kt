package day13

import util.*
import util.SimultaneousBuilder.*
import java.math.BigInteger

fun main() {
    println(Part2.calc(testData))
    println(Part2.calc(data))
    println(Part2UsingUtil.calc(data))
}

object Part2 {
    fun calc(input: List<String>): BigInteger {
        val games = load(input)

        return games.sumOf { numTokensToWin(it) }
    }

    private fun load(input: List<String>): List<Game> {
        return input.map {
            val a = "Button A: X\\+(\\d+), Y\\+(\\d+)".toRegex().find(it)!!.groupValues
            val b = "Button B: X\\+(\\d+), Y\\+(\\d+)".toRegex().find(it)!!.groupValues
            val p = "Prize: X=(\\d+), Y=(\\d+)".toRegex().find(it)!!.groupValues

            Game(Button(a[1].toBigInteger(), a[2].toBigInteger()), Button(b[1].toBigInteger(), b[2].toBigInteger()),
                Prize(p[1].toBigInteger(), p[2].toBigInteger()))
        }
    }

    private fun numTokensToWin(game: Game): BigInteger {
        val offset = 10_000_000_000_000L.toBigInteger()
        val newPrize = Prize(game.prize.x + offset, game.prize.y + offset)

        val topb = (newPrize.x * game.buttonA.y) - (newPrize.y * game.buttonA.x)
        val subb = (game.buttonA.y * game.buttonB.x) - (game.buttonA.x * game.buttonB.y)
        var win = topb.remainder(subb) == BigInteger.ZERO
        val b = topb.div(subb)
        if (win) {
            val topa = newPrize.y - game.buttonB.y * b
            val suba = game.buttonA.y
            win = topa.remainder(suba) == BigInteger.ZERO

            if (win) {
                val a  = topa.div(suba)
                return  (3.toBigInteger() * a) + b
            }
        }

        return BigInteger.ZERO
    }

    data class Game(val buttonA: Button, val buttonB: Button, val prize: Prize)

    data class Button(val x: BigInteger, val y: BigInteger)

    data class Prize(val x: BigInteger, val y: BigInteger)
}

object Part2UsingUtil {
    fun calc(input: List<String>): BigInteger = load(input).sumOf { numTokensToWin(it) }

    private fun load(input: List<String>): List<Game> {
        return input.map {
            val (_, ax, ay) = "Button A: X\\+(\\d+), Y\\+(\\d+)".toRegex().find(it)!!.groupValues
            val (_, bx, by) = "Button B: X\\+(\\d+), Y\\+(\\d+)".toRegex().find(it)!!.groupValues
            val (_, px, py)  = "Prize: X=(\\d+), Y=(\\d+)".toRegex().find(it)!!.groupValues

            Game(Button(ax.toBigInteger(), ay.toBigInteger()), Button(bx.toBigInteger(), by.toBigInteger()),
                Prize(px.toBigInteger(), py.toBigInteger()))
        }
    }

    private fun numTokensToWin(game: Game): BigInteger {
        val offset = 10_000_000_000_000L.toBigInteger()

        val simResult = solveSimultaneous {
            A * game.buttonA.x + B * game.buttonB.x eq game.prize.x + offset
            A * game.buttonA.y + B * game.buttonB.y eq game.prize.y + offset
        }

        return if (simResult.first.remainder == BigInteger.ZERO && simResult.second.remainder == BigInteger.ZERO) {
            3.toBigInteger() * simResult.first.quotient + simResult.second.quotient } else BigInteger.ZERO
    }

    data class Game(val buttonA: Button, val buttonB: Button, val prize: Prize)

    data class Button(val x: BigInteger, val y: BigInteger)

    data class Prize(val x: BigInteger, val y: BigInteger)
}