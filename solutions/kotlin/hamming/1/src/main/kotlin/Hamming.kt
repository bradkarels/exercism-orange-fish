object Hamming {

    fun compute(leftStrand: String, rightStrand: String): Int {
        return if (leftStrand.length == rightStrand.length) doHamming(leftStrand, rightStrand)
        else throw IllegalArgumentException("left and right strands must be of equal length")
    }

    private tailrec fun doHamming(left: String, right: String, count: Int = 0): Int {
        return if (left.isEmpty() || right.isEmpty()) count
        else {
            if (left.first() != right.first()) doHamming(left.drop(1), right.drop(1), count + 1)
            else doHamming(left.drop(1), right.drop(1), count)
        }
    }
}
