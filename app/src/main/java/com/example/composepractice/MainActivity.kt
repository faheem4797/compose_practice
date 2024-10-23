package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredWidth
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composepractice.ui.theme.ComposePracticeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
            Column(
                modifier = Modifier

                    .background(Color.Green)
                    .fillMaxHeight(0.8f)
                    .fillMaxWidth()
                    .padding( start =  16.dp,top = 48.dp)
                    .background(Color.Cyan)
                    .border(5.dp,Color.Magenta,RoundedCornerShape(16.dp))
                    .background(Color.Black)
                    .padding( start =  5.dp,top = 5.dp)
                    .border(5.dp,Color.Yellow,RoundedCornerShape(16.dp))
                    .background(Color.White)
                    .padding( start =  5.dp,top = 5.dp)
                    .border(5.dp,Color.Blue,RoundedCornerShape(16.dp))
                    .background(Color.Red)
                    .padding( start =  5.dp,top = 5.dp)
                ,
//                    .requiredWidth(800.dp)
//                horizontalArrangement = Arrangement.SpaceAround,
//                verticalAlignment = Alignment.CenterVertically,
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "Hello" ,
//                    fontSize = 36.sp ,
                    modifier = Modifier
                        .clickable {

                        }

                )
                Spacer(modifier = Modifier.height(20.dp))
                Text(text = "World")
                Text(text = "Pheeem")
            }


        }
    }
}



//@Preview(showBackground = true)
//@Composable
//fun GreetingPreview() {
//    ComposePracticeTheme {
//        Greeting("Android")
//    }
//}