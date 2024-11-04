import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//CallbackFlow
//Nos permite convertir cualquier callback en un flow para comenzar a trabajar con el y el resto de flows de forma natural

class ViewModel3 {

    fun update(callback: (Note) -> Unit) {
        var count = 1
        while (true) {
            Thread.sleep(500)
            callback(Note("Title $count", "Description $count", Note.Type.TEXT))
            println("Emitting Title $count")
            count++
        }
    }

}

fun ViewModel3.updatesFlow(): Flow<Note> = callbackFlow {
    update { trySend(it) }
}

fun main(): Unit = runBlocking {
    val viewModel = ViewModel3()
    launch(Dispatchers.Default) {
        viewModel.updatesFlow().collect {
            println(it)
        }
    }
}

/*
fun main(): Unit = runBlocking {
    val viewModel = ViewModel3()
    viewModel.updatesFlow().collect {
        println(it)
    }
}
 */