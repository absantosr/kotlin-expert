import kotlinx.coroutines.channels.BufferOverflow
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

//SharedFlows
//Es mucho más configurable, tiene muchos valores de configuuración
//Nos permite ser más flexibles en cuanto al número de elementos que almacenamos
//Y ocure cuando estamos consumiendo esos valores más lento que a la velocidad en las que se están emitiendo
//Y cuál es el número máximo de valores que queremos almacenar
//No tiene un valor inicial
//replay -> Cuántos valores queremos que almacene
//extraBufferCapacity -> Cuánta capacidad extra va a tener el buffer
//onBufferOverflow -> Realizamos una acción si superamos la capacidad del buffer

class ViewModel2 {
    //Backing properties
    private val _state = MutableSharedFlow<Note>(replay = 3, extraBufferCapacity = 3, onBufferOverflow = BufferOverflow.DROP_OLDEST)
    val state = _state.asSharedFlow()

    suspend fun update() {
        var count = 1
        while (true) {
            delay(500)
            _state.emit(Note("Title $count", "Description $count", Note.Type.TEXT))
            println("Emitting Title $count")
            count++
        }
    }

}

fun main(): Unit = runBlocking {
    val viewModel = ViewModel2()
    launch {
        viewModel.update()
    }
    delay(2100)
    viewModel.state.collect{
        delay(1000)
        println(it)
    }
}