object RunLengthEncoding {

    fun encode(input: String): String {
        return doEncode(input.toCharArray())
    }

    private tailrec fun doEncode(input: CharArray, currentLetter: String = "", currentCount: Int = 0, encoding: CharArray = charArrayOf()): String {
        return if (input.isEmpty()) {
            val appendEncodingWith = appendWith(currentCount, currentLetter)
            String(encoding.plus(appendEncodingWith.toCharArray()))
        } else {
            val newCurrentLetter = input.first().toString()
            val tail = input.sliceArray(1..input.lastIndex)

            if (currentLetter.isEmpty()) doEncode(tail, newCurrentLetter, 1, encoding)
            else {
                if (newCurrentLetter == currentLetter) {
                    doEncode(tail, currentLetter, currentCount + 1, encoding)
                } else {
                    val appendEncodingWith = appendWith(currentCount, currentLetter)
                    doEncode(tail, newCurrentLetter, 1, encoding.plus(appendEncodingWith.toCharArray()))
                }
            }
        }
    }

    private fun appendWith(cnt: Int, ltr: String): String {
        return when (cnt) {
            0 -> ""
            1 -> ltr
            else -> "$cnt$ltr"
        }
    }

    fun decode(input: String): String {
        return doDecode(input.toCharArray())
    }

    private tailrec fun doDecode(input: CharArray, nbr: Int = 0, output: CharArray = charArrayOf()): String {
        return if (input.isEmpty()) String(output)
        else {
            val head = input.first()
            val tail = input.sliceArray(1..input.lastIndex)
            if (head.isDigit()) {
                val nbrr = (nbr * 10) + head.digitToInt()
                doDecode(tail, nbrr, output)
            } else {
                val newEncoding = if (nbr == 0) output.plus(head.toString().toCharArray())
                else output.plus(head.toString().repeat(nbr).toCharArray())
                doDecode(tail, 0, newEncoding)
            }
        }
    }
}
