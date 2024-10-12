import androidx.compose.runtime.MutableState

fun MutableState<AppState.UiState>.update(produceValue: () -> AppState.UiState) {
    this.value = produceValue()
}

fun <T> MutableState<T>.update2(produceValue: (T) -> T) {
    value = produceValue(value)
}