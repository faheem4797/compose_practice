package com.example.composepractice

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()

        setContent {
            var textFieldState by remember { mutableStateOf("") }
            var errorField by remember { mutableStateOf("") }
            Column(
                verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.Bottom),

                modifier = Modifier
                    .fillMaxSize()
                    .background(Color.DarkGray)
                    .padding(16.dp)
            ) {

                Text(
                    errorField,
                    textAlign = TextAlign.Center,
                    color = Color.Red,
                    fontSize = 32.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                    )
                Text(
                    textFieldState,
                    textAlign = TextAlign.End,
                    color = Color.White,
                    fontSize = 32.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )

                AddThreeButtonRow(
                    "AC", "C", "/", true,
                    buttonPressedNotation = {

                        when (it) {
                            "AC" -> {
                                textFieldState = ""
                            }

                            "C" -> {
                                textFieldState = textFieldState.dropLast(1)
                            }

                            else -> {
                                textFieldState += it
                            }
                        }
                    },
                )
                AddDigitRow(
                    "7", "8", "9", "*",
                    buttonPressedNotation = {
                        textFieldState += it
                    },
                )
                AddDigitRow(
                    "4", "5", "6", "-",
                    buttonPressedNotation = {
                        textFieldState += it
                    },
                )
                AddDigitRow("1", "2", "3", "+",
                    buttonPressedNotation = {
                        textFieldState += it
                    })
                AddThreeButtonRow(
                    "0", ".", "=", false,
                    buttonPressedNotation = {
                        if (it == "=") {

                            try{
                                val result =
                                    ExpressionBuilder(textFieldState).build().evaluate()
                                val str = String.format(Locale.US,"%.2f", result)
                                textFieldState = if (str.contains(".")) {
                                    str.trimEnd('0').trimEnd('.') // Remove trailing zeros and decimal point if necessary
                                }else{
                                    str
                                }
                                errorField = ""
                            }catch (e: Exception){
                                textFieldState = ""
                                errorField = "Error Occurred"
                            }


                        } else {
                            textFieldState += it
                        }

                    },
                )
            }


        }
    }
}

@Composable
fun AddThreeButtonRow(
    first: String,
    second: String,
    operator: String,
    isTopRow: Boolean,
    buttonPressedNotation: (String) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
    ) {
        Button(
            onClick = {
                buttonPressedNotation(first)
            },
            colors = ButtonDefaults
                .buttonColors
                    (containerColor = if (isTopRow) Color.Gray else Color.Black),
            modifier = Modifier
                .weight(2f)
                .fillMaxHeight()
        ) { Text(first, fontSize = 24.sp, fontWeight = FontWeight.Bold) }
        Button(
            onClick = {
                buttonPressedNotation(second)
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            colors = ButtonDefaults
                .buttonColors
                    (containerColor = if (isTopRow) Color.Gray else Color.Black),

            ) { Text(second, fontSize = 24.sp, fontWeight = FontWeight.Bold) }
        Button(
            onClick = {
                buttonPressedNotation(operator)
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFA500)
            )

        ) { Text(operator, fontSize = 24.sp, fontWeight = FontWeight.Bold) }
    }
}

@Composable
fun AddDigitRow(
    firstDigit: String,
    secondDigit: String,
    thirdDigit: String,
    operator: String,
    buttonPressedNotation: (String) -> Unit,
) {
    Row(
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
    ) {

        Button(
            onClick = {
                buttonPressedNotation(firstDigit)
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {

            Text(firstDigit, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Button(
            onClick = {
                buttonPressedNotation(secondDigit)
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {

            Text(secondDigit, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Button(
            onClick = {
                buttonPressedNotation(thirdDigit)
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {

            Text(thirdDigit, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Button(
            onClick = {
                buttonPressedNotation(operator)
            },
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight(),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFFA500)
            )
        ) {

            Text(operator, fontSize = 24.sp, fontWeight = FontWeight.Bold)
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