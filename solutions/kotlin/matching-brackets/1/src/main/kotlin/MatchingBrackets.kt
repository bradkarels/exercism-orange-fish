object MatchingBrackets {
    private const val LEFT_PAREN = '('
    private const val RIGHT_PAREN = ')'
    private const val LEFT_BRACE = '['
    private const val RIGHT_BRACE = ']'
    private const val LEFT_CURLY_BRACE = '{'
    private const val RIGHT_CURLY_BRACE = '}'

    fun isValid(input: String): Boolean {
        val ca = input.toCharArray()
        return if (input.isEmpty()) true
        else {
            val braces = getBraces(ca)
            if (braces.size % 2 != 0 ) false
            else doIsValid(braces)
        }
    }

    private tailrec fun doIsValid(ca: CharArray, startIdx: Int = 0): Boolean {
        return if (ca.isEmpty()) true
        else if (startIdx >= ca.lastIndex) false
        else {
            val left = ca[startIdx]
            val right = ca[startIdx+1]
            if (isPair(left, right)) {
                val nextIdx = if (startIdx <= 0) 0 else startIdx - 1
                doIsValid(dropPairAtIndex(startIdx, ca), nextIdx)
            } else doIsValid(ca, startIdx + 1)
        }
    }

    private fun dropPairAtIndex(idx: Int, ca: CharArray): CharArray {
        return if (ca.size <= 2) charArrayOf()
        else {
            when (idx) {
                0 -> ca.sliceArray(2..ca.lastIndex)
                1 -> charArrayOf(ca.first()) + ca.sliceArray(idx + 2..ca.lastIndex)
                else -> ca.sliceArray(0 until idx) + ca.sliceArray(idx + 2..ca.lastIndex)
            }
        }
    }

    private fun getBraces(ca: CharArray): CharArray = ca.filter { isBrace(it) }.toCharArray()

    private fun isPair(left: Char, right: Char): Boolean {
        return when (left) {
            LEFT_PAREN -> right == RIGHT_PAREN
            LEFT_BRACE -> right == RIGHT_BRACE
            LEFT_CURLY_BRACE -> right == RIGHT_CURLY_BRACE
            else -> false
        }
    }

    private fun isBrace(c: Char): Boolean =
        when (c) {
            LEFT_PAREN -> true
            RIGHT_PAREN -> true
            LEFT_BRACE -> true
            RIGHT_BRACE -> true
            LEFT_CURLY_BRACE -> true
            RIGHT_CURLY_BRACE -> true
            else -> false
        }
}
