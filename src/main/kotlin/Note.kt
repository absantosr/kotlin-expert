import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext

data class Note2(val title: String, val description: String, val type: NoteType)

data class Note3(val title: String, val description: String)

enum class NoteType {
    TEXT, AUDIO
}

data class Note(val title: String, val description: String, val type: Type) {
    enum class Type { TEXT, AUDIO }
}

/*fun main() {
    val result = getNotes()
    println(result)
}*/

/*
fun getNotes(callback: (List<Note>) -> Unit) {
    Thread.sleep(2000)
    val notes = (1..10).map {
        Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )
    }
    callback.invoke(notes)
}
*/

fun getNotes(): Flow<List<Note>> = flow {
    delay(2000)
    var notes = emptyList<Note>()
    (1..10).forEach {
        notes = notes + Note(
            "Title $it",
            "Description $it",
            if (it % 3 == 0) Note.Type.AUDIO else Note.Type.TEXT
        )
        emit(notes)
        delay(500)
    }
}