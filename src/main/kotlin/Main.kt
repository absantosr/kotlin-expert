import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("") }
    val message = "Hola $text!"
    val buttonEnabled = text.isNotEmpty()

    MaterialTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(40.dp),
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = message,
                modifier = Modifier.padding(25.dp).align(Alignment.CenterHorizontally),
                color = Color.Blue
            )
            Button(
                onClick = { text = "" },
                modifier = Modifier.align(Alignment.CenterHorizontally),
                enabled = buttonEnabled
            ) {
                Text("Clean")
            }
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication, title = "My Application") {
        App()
    }
}
