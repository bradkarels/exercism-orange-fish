class Anagram(val source: String) {

    fun match(anagrams: Collection<String>): Set<String> {
        val result = mutableSetOf<String>()
        val ucSource = source.uppercase()
        for (anagram in anagrams) {
            if (isAnagram(ucSource, anagram.uppercase())) result.add(anagram)
        }
        return result
    }

    fun isAnagram(a: String, b: String): Boolean {
        return if (a.length != b.length)  false
        else if (a.compareTo(b) == 0) false
        else {
            val aa = a.toCharArray().sortedArray()
            val ba = b.toCharArray().sortedArray()
            doIsAnagram(aa, ba)
        }
    }

    fun doIsAnagram(a: CharArray, b: CharArray): Boolean {
        println("doIsAnagram: $a + $b")
        return if (a.isEmpty() && b.isEmpty()) true
        else {
            val aHead = a[0]
            val bHead = b[0]
            if (aHead != bHead) false
            else {
                val aTail = a.drop(1).toCharArray()
                val bTail = b.drop(1).toCharArray()
                doIsAnagram(aTail, bTail)
            }
        }
    }
}
