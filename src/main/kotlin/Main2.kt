import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Title
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App(): Unit = with(AppState) {

    val state by state.collectAsState()

    // Lanza la acción por única vez
    LaunchedEffect(true) {
        loadNotes(this)
    }

    MaterialTheme {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxSize()
        ) {
            if (state.loading)
                CircularProgressIndicator()

            state.notes?.let { NoteList(it) }
        }
    }
}

@Composable
private fun NoteList(notes: List<Note>) {
    LazyColumn(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        items(notes) { note ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .fillMaxWidth(0.8f)
            ) {
                Column(
                    modifier = Modifier.padding(16.dp)
                ) {
                    Row {
                        Text(
                            text = note.title,
                            style = MaterialTheme.typography.h6,
                            modifier = Modifier.weight(1f)
                        )
                        if (note.type == Note.Type.AUDIO) {
                            Icon(
                                imageVector = Icons.Default.Mic,
                                contentDescription = "Audio"
                            )
                        } else {
                            Icon(
                                imageVector = Icons.Default.Title,
                                contentDescription = "Text"
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(note.description)
                }
            }
        }
    }
}

fun main() {
    /*
    AppState.x
    AppState.foo()
    */

    application {
        Window(onCloseRequest = ::exitApplication) {
            App()
        }
    }
}