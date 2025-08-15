data class Tenth(var rollOne: Int = -1, var rollTwo: Int = -1, var rollThree: Int = -1) {
    fun ok(): Boolean {
        if (rollOne == -1 && rollTwo == -1 && rollThree == -1) {
            return true
        } else if (rollOne > -1 && rollTwo == -1 && rollThree == -1) {
            return true
        } else if (rollOne > -1 && rollTwo > -1 && rollThree == -1) {
            if (rollOne == 10) {
                return true
            } else {
                return rollOne + rollTwo <= 10
            }
        } else { //if (rollOne > -1 && rollTwo > -1 && rollThree > -1) {
            if (rollOne == 10 && rollTwo == 10) {
                return true
            } else if (rollOne == 10 && rollTwo < 10) {
                if (rollThree == -1) {
                    return true
                } else {
                    return rollTwo + rollThree <= 10
                }
            } else {
                val total = rollOne + rollTwo + rollThree
                return (total >= 10 && total <= 20)
            }
        }
    }
}

class BowlingGame {
    val rolls = mutableListOf<Int>()
    var frame = 1
    var framePins = 0
    var frameRolls = 0
    val tenth = Tenth()

    fun roll(pins: Int) {
        if (pins < 0 || pins > 10) throw IllegalStateException("Single roll cannot be greater than 10 or less than zero!")
        if (rolls.size > 21) throw IllegalStateException("More than max rolls...")
        rolls.add(pins)
        when (frame) {
            in 1..9 -> {
                if (pins == 10) {
                    frame++
                    frameRolls = 0
                    framePins = 0
                } else {
                    if (frameRolls == 0) {// first ball
                        framePins = pins
                        frameRolls = 1
                    } else {
                        framePins += pins
                        if (framePins > 10) throw IllegalStateException()
                        frame++
                        frameRolls = 0
                        framePins = 0
                    }
                }
            }
            10 -> {
                if (frameRolls == 0) {
                    tenth.rollOne = pins
                    if (!tenth.ok()) throw IllegalStateException()
                    frameRolls += 1
                    framePins += pins
                } else if (frameRolls == 1) {
                    tenth.rollTwo = pins
                    if (!tenth.ok()) throw IllegalStateException()
                    frameRolls += 1
                    framePins += pins
                } else if (frameRolls == 2) {
                    tenth.rollThree = pins
                    if (!tenth.ok()) throw IllegalStateException()
                }
            }
            else -> throw IllegalStateException()

        }
    }

    fun score(): Int {
        return doScore(rolls)
    }

    fun doScore(rolls: List<Int>, frame: Int = 1, score: Int = 0): Int {
        return if (rolls.isEmpty() && frame < 10) {
            throw IllegalStateException("too few frames to score game.")
        } else if (rolls.isEmpty()) {
            score
        } else {
            val current = rolls.first()
            return when (frame) {
                in 1..9 -> {
                    if (current == 10) {
                        val rollTotal = rolls.take(3).sum()
                        doScore(rolls.drop(1), frame + 1, score + rollTotal)
                    } else {
                        if (rolls.size < 2) throw IllegalStateException("Incomplete game!!!")
                        val next = rolls[1]
                        val frameTotal = current + next
                        if (frameTotal > 10 ) {
                            throw IllegalStateException("single frame total cannot be GT 10.")
                        }
                        if (frameTotal == 10) { // spare
                            val rollTotal = frameTotal + rolls[2]
                            doScore(rolls.drop(2), frame + 1, score + rollTotal)
                        } else {
                            doScore(rolls.drop(2), frame + 1, score + frameTotal)
                        }
                    }
                }
                10 -> {
                    if (rolls.size < 2 || rolls.size > 3) throw IllegalStateException()
                    val frameTotal = rolls.sum()
                    if (frameTotal >= 10 && rolls.size < 3) throw IllegalStateException()
                    doScore(listOf(), frame, score + frameTotal)
                }
                else -> throw IllegalStateException("More than ten frames.")
            }
        }
    }
}
