fun reverse(input: String): String {
    val iArray = input.toCharArray()
    var ridx = iArray.lastIndex
    var lidx = 0
    while (lidx < ridx) {
        val rVal = input[ridx]
        iArray[ridx] = iArray[lidx]
        iArray[lidx] = rVal
        ++lidx;--ridx;
    }
    return String(iArray)
}
