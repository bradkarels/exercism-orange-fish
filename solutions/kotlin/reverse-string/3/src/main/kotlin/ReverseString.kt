fun reverse(input: String): String {
    val length = input.length
    return when(length) {
        0 -> ""
        1 -> input
        else -> doReverse(input)
    }
}

fun doReverse(input: String): String {
    var i = 0
    var j = input.lastIndex
    val sa = input.toCharArray()
    while(j > i) {
        val temp = input[i]
        sa[i] = input[j]
        sa[j] = temp
        i++
        j--
    }
    return sa.joinToString("")
}
