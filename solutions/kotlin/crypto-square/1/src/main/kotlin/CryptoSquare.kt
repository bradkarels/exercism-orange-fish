object CryptoSquare {

    fun ciphertext(plaintext: String): String {
        // drop whitespace, punctuation, --> lowercase
        // determin r x c
        // fill rows of width column
        // read down the columns to get "words"
        // list of words separated by spaces is result
        // mind very short strings and handle empty
        return if (plaintext.isEmpty()) ""
        else {
            val norml = normalize(plaintext.lowercase().toCharArray())
//            println(norml)
            val len = norml.length
            val c = findC(len)
            val rows = mkRows(norml, c)

            val columnarWords = mutableListOf<String>()
            for (col in rows[0].indices) {
                var word = ""
                for (r in rows) {
                    if (r.length <= col) word += " "
                    else word += r[col]
                }
                columnarWords.add(word)
            }
            columnarWords.joinToString(separator = " ")
        }
    }

    private fun mkRows(s: String, c: Int, rows: List<String> = listOf()): List<String> {
       return if (s.isEmpty()) rows
       else {
           val nextRow = if (c > s.length) s else s.slice(0..c-1)
           val rest = s.slice(c..s.lastIndex)
           mkRows(rest, c, rows.plus(nextRow))
       }
    }

    private fun findC(len: Int): Int {
        var c = 1
        val squared = { n: Int -> n  * n }
        var i = squared(c)
        while (i < len) {
            i = squared(++c)
        }
        return c
    }

    private fun normalize(input: CharArray, output: CharArray = charArrayOf()): String {
        return if (input.isEmpty()) String(output)
        else {
            val head = input.first()
            val tail = input.sliceArray(1..input.lastIndex)
            if (head.isLetter() || head.isDigit()) normalize(tail, output.plus(head))
            else normalize(tail, output)
        }
    }
}
