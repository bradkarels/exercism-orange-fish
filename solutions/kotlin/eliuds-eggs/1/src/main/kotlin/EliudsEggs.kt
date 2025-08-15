object EliudsEggs {

    fun eggCount(number: Int): Int{
        val binString = number.toString(2).toCharArray()
        var cnt = 0
        for (i in 0..binString.lastIndex) {
            if (binString[i] == '1') cnt++
        }
        return cnt
    }
}
