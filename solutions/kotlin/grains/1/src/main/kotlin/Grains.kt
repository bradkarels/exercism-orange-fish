import java.math.BigInteger

object Board {
    const val NUMBER_OF_SQUARES = 64

    fun getGrainCountForSquare(number: Int): BigInteger {
        if (number < 1 || number > 64) throw IllegalArgumentException()
        return BigInteger.valueOf(2).pow(number - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        return doGetTotalGrainCount()
    }

    private tailrec fun doGetTotalGrainCount(numberOfSquares: Int = NUMBER_OF_SQUARES, square: Int = 1, total: BigInteger = BigInteger.valueOf(0)): BigInteger {
        return if (square > numberOfSquares) total
        else doGetTotalGrainCount(numberOfSquares, square + 1, total.plus(getGrainCountForSquare(square)))
    }
}
