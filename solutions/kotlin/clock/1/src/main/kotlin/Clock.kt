import kotlin.math.min
import kotlin.time.Duration.Companion.minutes

class Clock(val hour: Int, val minute: Int) {
    val aHour: Int
    val aMinute: Int

    init {
        val minutes: Int = minute % 60
        val extraHoursFromMintutes = minute / 60
        val hours = (hour + extraHoursFromMintutes) % 24

        val negativeStates: Int = getNegativeStates(hours, minutes)

        when (negativeStates) {
            3 -> {
                aHour = hours
                aMinute = minutes
            }
            2 -> {
                aHour = hours - 1
                aMinute = minutes + 60
            }
            1 -> {
                aHour = hours + 24
                aMinute = minutes
            }
            else -> {
                aHour = hours + 23
                aMinute = minutes + 60
            }
        }
    }

    fun getNegativeStates(h: Int, m: Int): Int {
        val minutesAreNegative = m < 0
        val hoursAreNegative = h < 0
        return if (minutesAreNegative && hoursAreNegative) 0
        else if (hoursAreNegative) 1
        else if (minutesAreNegative) 2
        else 3
    }

    override fun toString(): String {
        val hh = "$aHour".padStart(2, '0')
        val mm = "$aMinute".padStart(2, '0')
        return "$hh:$mm"
    }

//    fun subtract(minutes: Int) {
//        TODO("Implement the function to complete the task")
//    }

//    fun add(minutes: Int) {
//        TODO("Implement the function to complete the task")
//    }
}
