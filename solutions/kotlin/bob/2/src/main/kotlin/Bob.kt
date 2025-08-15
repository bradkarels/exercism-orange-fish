object Bob {

    const val SURE = "Sure." // This is his response if you ask him a question, such as "How are you?" The convention used for questions is that it ends with a question mark.
    const val CHILL = "Whoa, chill out!"//This is his answer if you YELL AT HIM. The convention used for yelling is ALL CAPITAL LETTERS.
    const val CALM = "Calm down, I know what I'm doing!"//This is what he says if you yell a question at him.
    const val FINE = "Fine. Be that way!"//This is how he responds to silence. The convention used for silence is nothing, or various combinations of whitespace characters.
    const val WHATEVS = "Whatever."// This is what he answers to anything else.

    fun hey(input: String): String {
        val inputIsBlank = input.isBlank()
        val isQuestion = input.trim().contains("\\?$".toRegex())
        val nonAlphaNumeric = "[^a-zA-Z]".toRegex()
        val upperCase = ("[A-Z]+").toRegex()
        val cleaned = input.replace(nonAlphaNumeric, "")
        val isYelling = cleaned.matches(upperCase)

        var score = 0;
        if (isYelling) score = score or Vibe.YELLING.score
        if (isQuestion) score = score or Vibe.QUESTION.score
        if (inputIsBlank) score = score or Vibe.SILENCE.score

        return when (score) {
            0 -> WHATEVS
            1 -> CHILL
            2 -> SURE
            3 -> CALM
            else -> FINE
        }
    }
}

enum class Vibe(val score: Int) {
    YELLING(1),
    QUESTION(2),
    SILENCE(4),
}