data class MinesweeperBoard(val mineField: List<String>) {
    val nbrRows: Int
    val nbrCols: Int
    val board: Array<Array<Char>>
    val emptyField: Boolean

    init {
        emptyField = (mineField.size == 1 && mineField[0].isEmpty())

        nbrRows = if (mineField.isEmpty() || (mineField.size == 1 && mineField[0].isEmpty())) 0
        else mineField.size

        nbrCols = if (mineField.isEmpty()) 0
        else mineField.first().length

        board = Array(nbrCols) { Array(nbrRows) {' '} }

        mineField.forEachIndexed { yIdx, row ->
            row.forEachIndexed { xIdx, c ->
                board[xIdx][yIdx] = c
            }
        }
    }

    fun withNumbers(): List<String> {
        return if (emptyField) listOf("")
        else {
            val result = mutableListOf<String>()
            for (y in 0..(nbrRows-1)) {
                val row = StringBuilder()
                for (x in 0..(nbrCols-1))  {
                    row.append(numberOfAdjacentMines(x,y))
                }
                result.add(row.toString())
            }
            result.toList()
        }
    }

    fun isInBounds(x: Int, y: Int): Boolean {
        val inBounds = (x in 0 until nbrCols && y in 0 until nbrRows)
        return inBounds
    }

    fun hasMine(x: Int, y: Int): Boolean = board[x][y] == '*'

    fun numberOfAdjacentMines(x: Int, y: Int): Char {
        return if (hasMine(x,y)) '*'
        else {
            var mineCount = 0
            for (xIdx in (x-1)..(x+1)) {
                for (yIdx in (y-1)..(y+1)) {
                    if (!(xIdx == x && yIdx == y)) {
                        if (isInBounds(xIdx, yIdx)) {
                            if (hasMine(xIdx, yIdx)) {
                                ++mineCount
                            }
                        }
                    }
                }
            }
            if (mineCount == 0) ' '
            else mineCount.digitToChar()
        }
    }
}
