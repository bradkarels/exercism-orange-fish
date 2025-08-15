enum class Classification {
    DEFICIENT, PERFECT, ABUNDANT
}

fun classify(naturalNumber: Int): Classification {
    return when {
        naturalNumber <= 0 -> throw RuntimeException("number must be greater than zero")
        else -> {
            val aliquotSum = aliquotSum(naturalNumber)
            when {
                aliquotSum < naturalNumber -> Classification.DEFICIENT
                aliquotSum == naturalNumber -> Classification.PERFECT
                else -> Classification.ABUNDANT
            }
        }
    }
}

private fun aliquotSum(n: Int): Int {
    return doAliquotSum(n)
}

private tailrec fun doAliquotSum(n: Int, d: Int = 1, factors: Set<Int> = setOf()): Int {
    return if (d > n/2) factors.sum()
    else {
        if (n % d == 0) doAliquotSum(n, d + 1, factors.plus(d))
        else doAliquotSum(n, d + 1, factors)
    }
}
