object ResistorColor {

    fun colorCode(input: String): Int {
        var code: Int = 0
        for (idx in 0..colors().lastIndex) {
            if (input == colors()[idx]) {
                code = idx
                break
            }
        }
        return code
    }

    fun colors(): List<String> = listOf("black", "brown", "red", "orange", "yellow", "green", "blue", "violet", "grey", "white")
}
