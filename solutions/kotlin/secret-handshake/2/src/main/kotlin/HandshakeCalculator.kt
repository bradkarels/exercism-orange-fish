object HandshakeCalculator {
    fun calculateHandshake(number: Int): List<Signal> {
        return if (number < 1 || number > 32) listOf()
        else {
            val code = number.toString(2).padStart(5, '0')

            val signals = mutableListOf<Signal>()
            for (i in code.lastIndex downTo 0 ) {
                when (code[i]) {
                    '1' -> {
                        when (i) {
                            4 -> signals.add(Signal.WINK)
                            3 -> signals.add(Signal.DOUBLE_BLINK)
                            2 -> signals.add(Signal.CLOSE_YOUR_EYES)
                            1 -> signals.add(Signal.JUMP)
                            else -> signals.reverse()
                        }
                    }
                }
            }
            signals
        }
    }
}
