import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//StateFlow
//Flow de tipo HOT(caliente)
//Los valores se van a ir emitiendo independientemente de que haya alguién escuchando
//Almacena el último valor que ha emitido
//Cuando nos subscribimos a este flow nos devolverá el último valor emitido, luego cuando
//se emitan nuevos valores los iremos recibiendo automáticamente
//Es una especialización del SharedFlow

class ViewModel {
    //Backing properties
    private val _state: MutableStateFlow<Note> = MutableStateFlow(Note("Title 1", "Description 1", Note.Type.TEXT))
    val state: StateFlow<Note> = _state.asStateFlow()

    suspend fun update() {
        var count = 1
        while (true) {
            delay(2000)
            count++
            _state.value = Note("Title $count", "Description $count", Note.Type.TEXT)
        }
    }

}

fun main(): Unit = runBlocking {
    val viewModel = ViewModel()
    launch {
        viewModel.update()
    }
    viewModel.state.collect(::println)
}