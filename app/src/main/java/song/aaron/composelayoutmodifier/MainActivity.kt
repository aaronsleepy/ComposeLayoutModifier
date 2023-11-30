package song.aaron.composelayoutmodifier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import song.aaron.composelayoutmodifier.ui.theme.ComposeLayoutModifierTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeLayoutModifierTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                }
            }
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier) {
    Box(modifier = Modifier
        .padding(1.dp)
        .size(width = 50.dp, height = 10.dp)
        .then(modifier))
}

@Composable
fun MainScreen() {
    Box(modifier = Modifier.size(120.dp, 80.dp)) {
        ColorBox(
            modifier = Modifier
                .exampleLayout(90, 50)
                .background(Color.Blue)
        )
    }
}

fun Modifier.exampleLayout(x: Int, y: Int) = layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)

    layout(placeable.width, placeable.height) {
        placeable.placeRelative(x, y)
    }
}

@Composable
@Preview(showBackground = true, showSystemUi = true)
fun DefaultPreview() {
    MainScreen()
}