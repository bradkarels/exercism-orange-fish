import java.time.LocalDate
import java.time.LocalDateTime

class Gigasecond(d: Any) {
    val one_giga = 1_000_000_000L
    val date: LocalDateTime

    init {
        when (d) {
            is LocalDate -> date = d.atStartOfDay().plusSeconds(one_giga)
            is LocalDateTime -> date = d.plusSeconds(one_giga)
            else -> date = LocalDate.EPOCH.atStartOfDay()
        }
    }
}
