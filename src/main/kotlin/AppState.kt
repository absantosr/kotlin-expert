import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import kotlin.concurrent.thread

class AppState {
    val state: MutableState<UiState> = mutableStateOf(UiState())

    fun loadNotes() {
        thread {
            //state.value = UiState(loading = true)
            //state.update2 { UiState(loading = true) }
            state.update2 { it.copy(loading = true) }
            //getNotes { state.value = UiState(notes = it) }
            getNotes { notes -> state.update2 { UiState(notes = notes) }}
        }
    }

    data class UiState(
        val notes: List<Note>? = null,
        val loading: Boolean = false
    )
}