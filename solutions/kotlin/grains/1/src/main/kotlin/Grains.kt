import java.math.BigInteger

object Board {
    val biTwo = BigInteger.valueOf(2)

    fun getGrainCountForSquare(number: Int): BigInteger {
        if (number !in 1..64) throw IllegalArgumentException()
        return biTwo.pow(number - 1)
    }

    fun getTotalGrainCount(): BigInteger {
        var sum = BigInteger.valueOf(0)
        for (e in 0..63) {
           sum += biTwo.pow(e)
        }
        return sum
    }
}
