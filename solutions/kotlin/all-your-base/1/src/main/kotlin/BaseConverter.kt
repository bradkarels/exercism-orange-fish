class BaseConverter(val i: Int, val intArrayOf: IntArray) {
    init {
        if (intArrayOf.isEmpty()) {
            throw java.lang.IllegalArgumentException("You must supply at least one digit.")
        } else if (intArrayOf.size > 1 && intArrayOf.takeWhile { it == 0 }.size > 0) {
            throw IllegalArgumentException("Digits may not contain leading zeros.")
        } else if (i < 2) {
            throw IllegalArgumentException("Bases must be at least 2.")
        } else if (intArrayOf.filter { it < 0 }.size > 0) {
            throw IllegalArgumentException("Digits may not be negative.")
        } else if (intArrayOf.filterNot { it < i }.size > 0) {
            throw IllegalArgumentException("All digits must be strictly less than the base.")
        }
    }

    fun convertToBase(newBase: Int): IntArray {
        if (newBase < 2) throw IllegalArgumentException("Bases must be at least 2.")
        val value = getValue(this)
        val maxExp = getMaxExponent(value, newBase)
        return reBase(value, newBase, maxExp)
    }

    private tailrec fun reBase(value: Int, base: Int, exponent: Int, result: IntArray = intArrayOf()): IntArray {
        return if (exponent < 0) result
        else {
            val units = pow(base, exponent)
            var nbrOfUnits = 0
            for (i in 1..base) {
                val testNumber = i * units
                if (value - testNumber < 0) {
                    nbrOfUnits = i - 1
                    break
                } else continue
            }
            val nextValue = value - (units * nbrOfUnits)
            reBase(nextValue, base, exponent - 1, result.plus(nbrOfUnits))
        }

    }

    private tailrec fun getMaxExponent(target: Int, base: Int, exp: Int = 0): Int {
        return if (pow(base, exp + 1) > target) exp
        else getMaxExponent(target, base, exp + 1)
    }

    // not good for anything more than small numbers...but allows for Int w/o Double conversion
    private fun pow(base: Int, exponent: Int): Int =
        if (exponent != 0 ) base * pow(base, exponent - 1)
        else 1

    companion object {
        fun getValue(baseConverter: BaseConverter): Int {
            val lastIndex = baseConverter.intArrayOf.lastIndex
            return (0..lastIndex).sumOf { exponent ->
                val digit = baseConverter.intArrayOf[lastIndex - exponent]
                digit * (baseConverter.pow(baseConverter.i, exponent))
            }
        }
    }
}
