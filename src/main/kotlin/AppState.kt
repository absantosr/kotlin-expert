import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

object AppState {

    /*
    companion object MyCompObj {
        var x = 20
        fun foo() {
            //
        }
    }
    */

    //Solo un companion object por clase
    /*
    companion object {
        var x = 40
        fun foo() {
            //
        }
    }
    */

    //val state: MutableState<UiState> = mutableStateOf(UiState())
    //var state by mutableStateOf(UiState())

    /*
    fun loadNotes() {
        thread {
            //state.value = UiState(loading = true)
            //state.update2 { UiState(loading = true) }
            //state.update2 { it.copy(loading = true) }
            state = UiState(loading = true)

            //getNotes { state.value = UiState(notes = it) }
            //getNotes { notes -> state.update2 { UiState(notes = notes) } }
            getNotes { notes -> state = UiState(notes = notes) }
        }
    }
    */

    private val _state = MutableStateFlow(UiState())
    val state = _state.asStateFlow()

    fun loadNotes(coroutineScope: CoroutineScope) {
        coroutineScope.launch {
            _state.value = UiState(loading = true)
            _state.value = UiState(notes = getNotes())
        }
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false
    )
}