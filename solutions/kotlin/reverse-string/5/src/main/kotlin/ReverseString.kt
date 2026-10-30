fun reverse(input: String): String {
    val chars = input.toCharArray()
    var i = 0
    var j = chars.lastIndex

    while (i < j) {
        val tmp = chars[i]
        chars[i] = chars[j]
        chars[j] = tmp
        i++
        j--
    }
    return chars.concatToString()
}
