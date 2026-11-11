object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int {
        val factorSet = mutableSetOf<Int>()
        for (f in factors) {
            if (f > 0) factorSet.addAll(getMultiples(f, limit))
        }
        return factorSet.sum()
    }

    fun getMultiples(factor:Int, limit: Int): List<Int> {
        val result = mutableListOf<Int>()
        var multiplier = 1
        var multiple = factor * multiplier
        while (multiple < limit) {
            result.add(multiple)
            multiplier += 1
            multiple = factor * multiplier
        }
        return result
    }
}
