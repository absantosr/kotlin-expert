import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.runBlocking

fun main(): Unit = runBlocking {
    /*
    val res = flow {
        emit(3)
        delay(300)
        emit(5)
        delay(300)
        emit(7)
        delay(300)
        emit(8)
    }.filter { it % 2 == 0 }
        .map { "Item $it" }

    delay(1000)
    res.collect {
        println(it)
    }
    delay(1000)
    res.collect {
        println(it)
    }

    launch {
        res.collect {
            println(it)
        }
    }
    */

    /*
    val res = flow {
        emit(3)
        delay(300)
        emit(4)
        delay(300)
        emit(7)
        delay(300)
        emit(8)
    }.transform {
        if (it % 2 == 0) emit("Item $it")
    }

    launch {
        res.collect {
            println(it)
        }
    }
    */

    /*
    //emit -> Agrega valor a un flow
    //.collect -> Empieza a recolecta los valores de un flow
    //.toList -> Espera a obtener todos los valores para devolver una lista
    //.first -> Coger el primer elemento

    val flow1 = flowOf(1, 2, 3, 4).onEach { delay(300) }
    val flow2 = flowOf("a", "b", "c").onEach { delay(500) }

    //flow1.zip(flow2) { a, b -> "$a -> $b" }.collect { println(it) }
    //println(flow1.combine(flow2) { a, b -> "$a -> $b" }.first())
    flow1.combine(flow2) { a, b -> "$a -> $b" }.collect { println(it) }
    */

    //Restricciones:
    //Dentro de un flow no podemos cambiar de contexto, solo mediante .flowOn()
    //No deberíamos hacer un try catch dentro de un bloque de código que está emitiendo un valor, solo mediante .catch()

    val flow = flow {
        emit(2)
        throw IllegalStateException("Exception message")
    }

    flow
        .flowOn(Dispatchers.IO)
        .catch { throwable -> println(throwable.message) }
        .collect {
            println(it)
        }

}