class EmptyBufferException: Throwable()

class BufferFullException: Throwable()

class CircularBuffer<T>(val size: Int) {
    val buffer = mutableListOf<T?>()
    val isEmpty = {
        var allNull = true
        for (i in 0..size-1) {
            if (buffer[i] != null) {
                allNull = false
                break
            }
        }
        allNull
    }
    private var readIdx = -1
    private var writeIdx = -1
    init {
        for (i in 0..size-1){
            buffer.add(null)
        }
    }

    fun read() : T {
        if (isEmpty()) throw EmptyBufferException()
        else {
            val readValue = buffer[readIdx]!!
            buffer[readIdx] = null
            readIdx = advance(readIdx)
            return readValue
        }
    }

    fun write(value: T) {
        writeIdx = advance(writeIdx)
        if (buffer[writeIdx] != null) throw BufferFullException()
        else {
            buffer[writeIdx] = value
            readable()
        }
    }

    fun overwrite(value: T) {
        val nextIdx = advance(writeIdx)
        if (buffer[nextIdx] == null)  write(value)
        else {
            buffer[nextIdx] = value
            writeIdx = nextIdx
            readIdx = advance(readIdx)
        }
    }

    private fun readable() {
        if (readIdx == -1) {
            readIdx = if (writeIdx == -1) 0 else writeIdx
        }
    }

    fun clear() {
        if (!isEmpty()) {
            buffer[readIdx] = null
            readIdx = advance(readIdx)
        }
    }

    fun advance(i: Int): Int {
        return if (i < size - 1) i + 1
        else 0
    }
}