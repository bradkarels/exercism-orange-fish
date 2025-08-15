import YachtCategory.*

object Yacht {

    fun solve(category: YachtCategory, vararg dices: Int): Int {
        return when (category) {
            CHOICE          -> dices.sum()
            ONES            -> dices.filter { it == 1 }.size
            TWOS            -> dices.filter { it == 2 }.size * 2
            THREES          -> dices.filter { it == 3 }.size * 3
            FOURS           -> dices.filter { it == 4 }.size * 4
            FIVES           -> dices.filter { it == 5 }.size * 5
            SIXES           -> dices.filter { it == 6 }.size * 6
            YACHT           -> scoreYacht(dices)
            FULL_HOUSE      -> scoreFullHouse(dices)
            FOUR_OF_A_KIND  -> scoreFourOfaKind(dices)
            LITTLE_STRAIGHT -> scoreLittleStraight(dices)
            BIG_STRAIGHT    -> scoreBigStraight(dices)
        }
    }

    fun scoreYacht(dices: IntArray): Int {
       return if (isYacht(dices)) 50 else 0
    }

    fun isYacht(dices: IntArray): Boolean {
        val head = dices[0]
        var ok = true
        for (i in 1..dices.lastIndex) {
            if (dices[i] != head) {
                ok = false
                break
            }
        }
        return ok
    }

    infix fun <T> List<T>.equalsIgnoreOrder(other: List<T>) = this.size == other.size && this.toSet() == other.toSet()

    fun scoreLittleStraight(dices: IntArray): Int {
        val littleStraight = listOf(1,2,3,4,5)
        return if (dices.toList() equalsIgnoreOrder littleStraight) 30
        else 0
    }

    fun scoreBigStraight(dices: IntArray): Int {
        val bigStraight = listOf(2,3,4,5,6)
        return if (dices.toList() equalsIgnoreOrder bigStraight) 30
        else 0
    }

    fun scoreFullHouse(dices: IntArray): Int {
        val frequencies = IntArray(6)
        for (value in dices) frequencies[value] += 1
        return if (frequencies.filterNot { it == 0 }.equalsIgnoreOrder(listOf(3,2))) dices.sum()
        else 0
    }

    fun scoreFourOfaKind(dices: IntArray): Int {
        val frequencies = IntArray(6)
        for (value in dices) frequencies[value-1] += 1
        return if (frequencies.filter { it == 4 }.size == 1) {
            (frequencies.indexOf(4) + 1) * 4
        } else if (frequencies.filter { it == 5 }.size == 1) {
            (frequencies.indexOf(5) + 1) * 4
        } else 0
    }
}
