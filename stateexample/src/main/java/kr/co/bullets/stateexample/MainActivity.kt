package kr.co.bullets.stateexample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import kr.co.bullets.stateexample.ui.theme.ComposeEssentialsTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeEssentialsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    DemoScreen()
                }
            }
        }
    }
}

@Composable
fun DemoScreen() {
    MyTextField()
}

@Composable
fun MyTextField() {
//    var textState = remember { mutableStateOf("") }
    var textState by remember { mutableStateOf("") }
//    var (textValue, setText) = remember { mutableStateOf("") }

    // onValueChange: (String) -> Unit
    val onTextChange = { text: String ->
//        textState.value = text
        textState = text
//        setText(text)
    }

//    TextField(value = textState.value, onValueChange = onTextChange)
    TextField(value = textState, onValueChange = onTextChange)
//    TextField(value = textValue, onValueChange = onTextChange)
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeEssentialsTheme {
        DemoScreen()
    }
}