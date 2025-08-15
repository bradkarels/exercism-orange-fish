class Squares(val n: Int) {
    val firstNNumbers: Array<Int> = firstNumbers(n)


    fun sumOfSquares(): Int {
        return doSumOfSquares(firstNNumbers)
    }

    private tailrec fun doSumOfSquares(nbrs: Array<Int>, sum: Int = 0): Int =
        if (nbrs.isEmpty()) sum
        else {
            val head = nbrs.first()
            val tail = nbrs.sliceArray(1..nbrs.lastIndex)
            doSumOfSquares(tail, square(head) + sum)
        }

    fun squareOfSum(): Int {
        return doSquareOfSum(firstNNumbers)
    }

    private tailrec fun doSquareOfSum(nbrs: Array<Int>, sum: Int = 0): Int =
        if (nbrs.isEmpty()) sum * sum
        else {
            val head = nbrs.first()
            val tail = nbrs.sliceArray(1..nbrs.lastIndex)
            doSquareOfSum(tail, head + sum)
        }

    fun difference() = squareOfSum() - sumOfSquares()

    private fun square(n: Int) = n * n

    private tailrec fun firstNumbers(n: Int, result: Array<Int> = arrayOf()): Array<Int> =
        if (n == 0) result
        else firstNumbers(n - 1, result.plus(n))
}
