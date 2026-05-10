object Series {

    fun slices(n: Int, s: String): List<List<Int>> {
        if (n <= 0 || s.length < n || s.isEmpty()) throw IllegalArgumentException()
        val digits = s.toCharArray().map { it.toString().toInt() }
        val lastIdx = digits.lastIndex
        val series = mutableListOf<List<Int>>()
        for (i in 0..lastIdx) {
            val limit = i + n - 1
            if (limit <= lastIdx) {
                val subSeriees: List<Int> = digits.slice(i..limit)
                series.add(subSeriees)
            }
        }
        return series
    }
}
