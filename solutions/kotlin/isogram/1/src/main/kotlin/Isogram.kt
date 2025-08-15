object Isogram {

    fun isIsogram(input: String): Boolean {
        return if (input.length <= 1) true
        else {
            val patternToClean = "[ -]".toRegex()
            val candidate = input.replace(patternToClean, "").lowercase()
            return candidate.toCharArray().toSet().size == candidate.length
        }
    }
}
