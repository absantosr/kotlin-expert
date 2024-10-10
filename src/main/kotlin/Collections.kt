fun main() {
    val list: List<Note3> = listOf(
        Note3("Title 1", "Description 1"),
        Note3("Title 2", "Description 2"),
        Note3("Title 5", "Description 5"),
        Note3("Title 4", "Description 4"),
        Note3("Title 3", "Description 3")
    )

    val emptyList: List<Note3> = emptyList()

    val mutableList: MutableList<Note3> = mutableListOf(
        Note3("Title 6", "Description 6"),
        Note3("Title 7", "Description 7")
    )
    mutableList.add(Note3("Title 8", "Description 8"))

    val setList = setOf(
        Note3("Title 9", "Description 9"),
        Note3("Title 9", "Description 9"),
        Note3("Title 10", "Description 10"),
        Note3("Title 9", "Description 9"),
        Note3("Title 10", "Description 10")
    )

    val map = mapOf(
        Pair(1, Note3("Title 1", "Description 1")),
        Pair(2, Note3("Title 3", "Description 3")),
        Pair(3, Note3("Title 4", "Description 4")),
        Pair(4, Note3("Title 7", "Description 7")),
        Pair(5, Note3("Title 0", "Description 0"))
    )

    val map2 = mapOf(
        1 to Note3("Title 1", "Description 1"),
        2 to Note3("Title 3", "Description 3"),
        3 to Note3("Title 4", "Description 4"),
        4 to Note3("Title 7", "Description 7"),
        5 to Note3("Title 0", "Description 0")
    )

    val result = list
        .filterNot { it.title.contains('3') }
        .sortedBy { it.title }
        .map { it.title }

    println(list)
    println(emptyList)
    println(mutableList)
    println(setList)
    println(map)
    println(map2)
    println(result)
}