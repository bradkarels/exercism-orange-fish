import java.util.Locale.getDefault

class Anagram(source: String) {
    val lSource = source.lowercase(getDefault())
    val caSource: CharArray = lSource.sortedChars()
    val length = source.length

    fun String.sortedChars() = toCharArray().apply { sort() }

    fun match(anagrams: Collection<String>): Set<String> {
        val result = mutableSetOf<String>()
        for (candidate in anagrams) {
            var isAnagram = true
            if (candidate.length == length) {
                val lCandidate = candidate.lowercase(getDefault())
                if (lCandidate != lSource) {
                    val caCandidate = lCandidate.sortedChars()
                    for (i in caCandidate.indices) {
                        if (caCandidate[i] == caSource[i]) continue
                        else {
                            isAnagram = false
                            break
                        }
                    }
                } else isAnagram = false
            } else isAnagram = false
            if (isAnagram) result += candidate
        }
        return result
    }
}
