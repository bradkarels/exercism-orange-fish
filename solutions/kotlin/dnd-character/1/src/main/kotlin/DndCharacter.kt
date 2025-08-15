import kotlin.random.Random
import kotlin.random.nextInt

class DndCharacter {

    val strength: Int = ability()
    val dexterity: Int = ability()
    val constitution: Int = ability()
    val intelligence: Int = ability()
    val wisdom: Int = ability()
    val charisma: Int = ability()
    val hitpoints: Int = 10 + modifier(constitution)

    companion object {
        val role = { Random.nextInt(1..6) }

        fun ability(): Int {
            val roles: List<Int> = listOf(role(), role(), role(), role())

            var min =  roles[0]
            for (i in 1..roles.lastIndex) {
               if (roles[i] < min) min = roles[i]
            }
            return roles.sum() - min
        }

        fun modifier(score: Int): Int = Math.floorDiv(score - 10, 2)
    }
}
