package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()



        setContent {
            var color by remember{ mutableStateOf(Color.Yellow)}
            Column (Modifier.fillMaxSize()) {
                ColorBox(Modifier.weight(1f).fillMaxSize()){
                    color = it
                }
                Box(Modifier.weight(1f)
                    .fillMaxSize()
                    .background(color))
            }

        }
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier,
             updateColor: (Color) -> Unit

) {
    Box(
        modifier
            .background(Color.Red)
            .clickable (indication = null,
                interactionSource = remember { MutableInteractionSource() }) {
                updateColor(
                    Color(
                        Random.nextFloat(),
                        Random.nextFloat(),
                        Random.nextFloat(),
                        1f,
                    )
                )

            })
}


//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposePracticeTheme {
//        Greeting("Android")
//    }
//}