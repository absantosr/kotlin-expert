import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App(appState: AppState2) {
    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = appState.text.value,
                onValueChange = { appState.text.value = it },
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = getGreeting(appState.text.value),
                modifier = Modifier.padding(25.dp).align(Alignment.CenterHorizontally),
                color = Color.Blue
            )
            Button(
                onClick = { appState.text.value = "" },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                enabled = appState.buttonEnabled
            ) {
                Text("Clean")
            }
        }
    }
}

fun main() {
    val appState = AppState2()

    application {
        Window(onCloseRequest = ::exitApplication, title = "My Application") {
            App(appState)
        }
    }
}

fun getGreeting(name: String) = "Hola $name!"

class AppState2 {
    val text = mutableStateOf("")
    val buttonEnabled: Boolean
        get() = text.value.isNotEmpty()
}
