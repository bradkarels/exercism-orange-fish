object ArmstrongNumber {

    fun check(input: Int): Boolean {
        val digits = getDigits(input)
        val power = digits.size
        val exponentiation: List<Int> = digits.map { pow(it, power) }
        return exponentiation.sum() == input
    }

    private tailrec fun getDigits(i: Int, digits: IntArray = intArrayOf()): IntArray =
        if (i == 0) digits
        else getDigits(i/10, digits.plus(i % 10))

    // not good for anything more than small numbers...
    private fun pow(base: Int, exponent: Int): Int =
        if (exponent != 0 ) base * pow(base, exponent - 1)
        else 1
}
