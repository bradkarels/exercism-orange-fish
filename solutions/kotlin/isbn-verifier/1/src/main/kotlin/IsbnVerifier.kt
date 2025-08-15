class IsbnVerifier {

    fun isValid(number: String): Boolean {
        val pattern = ("[0-9X-]*").toRegex()
        val hyphen = "[-]".toRegex()

        return if (number.matches(pattern)) {
            val cleaned = number.replace(hyphen, "")
            val xat = cleaned.indexOf('X')
            if (xat == -1 || xat == 9) {
                if (cleaned.length == 10) {
                    val chars = cleaned.map { it }
                    val ints: List<Int> = chars.map { c ->
                        if (c == 'X') 10
                        else c.digitToInt()
                    }
                    println(ints.joinToString(":"))
                    println(sumByDescCount(ints))
                    return sumByDescCount(ints) % 11 == 0
                } else false
            } else false
        } else false
    }

    tailrec fun sumByDescCount(ints: List<Int>, sum: Int = 0): Int {
        return if (ints.isEmpty()) sum
        else sumByDescCount(ints.drop(1), ints.first() * ints.size + sum)
    }
}
