import kotlin.math.log2
import kotlin.math.pow

object EliudsEggs {
    const val ZERO = 0.0
    const val ONE = 1.0
    const val TWO = 2.0

    fun eggCount(number: Int): Int{
        return bitCount(number.toDouble())
    }

    tailrec fun bitCount(nbr: Double, cnt: Int = 0): Int {
        return if (nbr == ZERO) cnt
        else if (nbr == ONE) cnt + 1
        else {
            val exponent = log2(nbr).toInt()
            val nbrToDeduct = TWO.pow(exponent)
            bitCount(nbr - nbrToDeduct, cnt + 1)
        }
    }
}
