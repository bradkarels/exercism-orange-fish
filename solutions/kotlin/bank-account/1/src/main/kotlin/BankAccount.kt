import java.util.concurrent.locks.ReentrantLock

class BankAccount {
    var isOpen: Boolean = true

    var balance: Long = 0
        get() {
            if (!isOpen) throw IllegalStateException("cannot adjust balance on a closed account")
            return field
        }
        set(value) {
            field = value
        }
    val balanceLock = ReentrantLock()

    fun adjustBalance(amount: Long){
        if (isOpen == false) throw IllegalStateException("cannot adjust balance on a closed account")
        else {
            balanceLock.lock()
            balance += amount
            balanceLock.unlock()
        }
    }

    fun close() {
        isOpen = false
    }
}
