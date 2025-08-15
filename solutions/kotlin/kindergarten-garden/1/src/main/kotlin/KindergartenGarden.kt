class KindergartenGarden(private val diagram: String) {
    val cups: Array<Array<Plant>>
    val studentColumnMap: Map<Int, Student>

    init {
        val rawRows: List<String> = diagram.split("\n")
        val numberOfColumns = rawRows[0].length
        val numberOfRows = rawRows.size
        cups = Array(numberOfColumns) {
            Array(numberOfRows) {
                Plant.G
            }
        }
        for (c in 0 until numberOfColumns) {
            for (r in 0 until numberOfRows) {
                cups[c][r] = enumValueOf<Plant>(rawRows[r][c].toString())
            }
        }
        var column = 0
        val studentColumns: MutableList<Pair<Int, Student>> = mutableListOf()
        for (student in Student.values()) {
            val studentColumn0 = Pair(column++, student)
            val studentColumn1 = Pair(column++, student)
            studentColumns.add(studentColumn0)
            studentColumns.add(studentColumn1)
        }
        studentColumnMap = studentColumns.toMap()
    }

    enum class Student {
        ALICE,
        BOB,
        CHARLIE,
        DAVID,
        EVE,
        FRED,
        GINNY,
        HARRIET,
        ILEANA,
        JOSEPH,
        KINCAID,
        LARRY,
    }

    enum class Plant(val plantName: String) {
        G("grass"),
        C("clover"),
        R("radishes"),
        V("violets"),
    }

    fun getPlantsOfStudent(student: String): List<String> {
        val cols: Set<Int> = studentColumnMap.filter {
          it.value == enumValueOf<Student>(student.uppercase())
        }.keys
        val studentPlants = mutableListOf<String>()
        for (r in 0..1) {
            for (c in cols) {
                studentPlants.add(cups[c][r].plantName)
            }
        }
        return studentPlants
    }
}
