data class Note2(val title: String, val description: String, val type: NoteType)

data class Note(val title: String, val description: String, val type: Type) {
    enum class Type { TEXT, AUDIO }
}

val list = listOf(
    Note("Title 1", "Description 1", Note.Type.TEXT),
    Note("Title 2", "Description 2", Note.Type.AUDIO),
    Note("Title 3", "Description 3", Note.Type.AUDIO),
    Note("Title 4", "Description 4", Note.Type.TEXT),
    Note("Title 5", "Description 5", Note.Type.AUDIO)
)

enum class NoteType {
    TEXT, AUDIO
}