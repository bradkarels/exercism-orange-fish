object Pangram {

    fun isPangram(input: String): Boolean {
        return doIsPangram(input.lowercase())
    }

    private tailrec fun doIsPangram(input: String, letters: Set<Char> = setOf()): Boolean {
        return if (letters.size == 26) true
        else if (input.isEmpty()) false
        else {
            val head = input.first()
            val tail = input.drop(1)
            if (head.isLetter()) doIsPangram(tail, letters.plus(head))
            else doIsPangram(tail, letters)
        }
    }
}
