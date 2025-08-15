object Isogram {

    fun isIsogram(input: String): Boolean {
        return if (input.length <= 1) true
        else {
            val patternToClean = "[ -]".toRegex()
            val candidate = input.replace(patternToClean, "").lowercase()
            return doIsIsoGram(candidate.toCharArray())
        }
    }

    private tailrec fun doIsIsoGram(letters: CharArray, result: Boolean = true): Boolean  {
        return  if (letters.isEmpty()) result
        else {
            val head = letters.first()
            val tail = letters.sliceArray(1..letters.lastIndex)
            var headOk = true
            xxx@ for (i in tail.indices) {
                if (head == tail[i]) {
                    headOk = false
                    break@xxx
                }
            }
            if (headOk) doIsIsoGram(tail, true)
            else doIsIsoGram(charArrayOf(), false)
        }
    }
}
