const val CAP_H = 'H'
const val LOW_E = 'e'
const val LOW_L = 'l'
const val LOW_O = 'o'
const val COMMA = ','
const val CAP_W = 'W'
const val LOW_R = 'r'
const val LOW_D = 'd'
const val BANG = '!'
fun hello(): String {
    return greet()
}

fun greet(): String {
    val firstWord = listOfCharToString(listOf(CAP_H, LOW_E, LOW_L, LOW_L, LOW_O))
    val comma = listOfCharToString(listOf(COMMA), true)
    val secondWord = listOfCharToString(listOf(CAP_W, LOW_O, LOW_R, LOW_L, LOW_D))
    val bang = listOfCharToString(listOf(BANG))
    return buildShortPhrase(listOf(firstWord, comma, secondWord, bang))
}

fun listOfCharToString(list: List<Char>, addTrailingSpace: Boolean = false): String {
    val sb = StringBuilder()
    for (c in list) sb.append(c)
    if (addTrailingSpace) sb.append(' ')
    return sb.toString()
}

tailrec fun buildShortPhrase(words: List<String>, phrase: String = ""): String {
    return if (words.isEmpty()) phrase
    else {
        val next = words.first()
        val sb = StringBuilder(phrase)
        buildShortPhrase(words.drop(1), sb.append(next).toString())
    }
}