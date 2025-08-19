object SumOfMultiples {

    fun sum(factors: Set<Int>, limit: Int): Int = getMultipleMultiples(factors.toList(), limit).sum()

    tailrec fun getMultipleMultiples(nbrs: List<Int>, limit: Int, results: List<Int> = emptyList()): Set<Int> {
        return if (nbrs.isEmpty()) results.toSet()
        else {
            val head = nbrs.first()
            val tail = nbrs.drop(1)
            val multiples = getMultiples(head, limit)
            getMultipleMultiples(tail, limit, results.plus(multiples))
        }
    }

    tailrec fun getMultiples(i: Int, limit: Int, m: Int = 1, results: List<Int> = emptyList()): List<Int> {
        return if (m * i >= limit || i == 0) results
        else getMultiples(i, limit, m + 1, results + (m * i))
    }
}
