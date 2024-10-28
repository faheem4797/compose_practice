package com.example.composepractice

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Divider
import androidx.compose.material3.DrawerDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavGraph
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.ui.theme.ComposePracticeTheme
import com.example.composepractice.ui.theme.GreenPracticeCompose
import kotlinx.coroutines.launch
import net.objecthunter.exp4j.ExpressionBuilder
import java.util.Locale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {

            ComposePracticeTheme{ NavDrawer() }

//            ComposePracticeTheme { AppBar(){} }
        }
    }
}


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun NavDrawer() {
    val navigationController = rememberNavController()
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val context = LocalContext.current.applicationContext

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.padding (0.dp, 0.dp, 50.dp, 0.dp)
                ) {
                Box(
                    modifier = Modifier
                        .background(GreenPracticeCompose)
                        .fillMaxWidth()
                        .height(150.dp)
                )
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text("Home", color = GreenPracticeCompose) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home Icon",
                            tint = GreenPracticeCompose
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Home.screen) {
                            popUpTo(0)
                        }
                    },
                )
                NavigationDrawerItem(
                    label = { Text("Profile", color = GreenPracticeCompose) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile Icon",
                            tint = GreenPracticeCompose
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Profile.screen) {
                            popUpTo(0)
                        }
                    },
                )
                NavigationDrawerItem(
                    label = { Text("Settings", color = GreenPracticeCompose) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Settings Icon",
                            tint = GreenPracticeCompose
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        navigationController.navigate(Screens.Settings.screen) {
                            popUpTo(0)
                        }
                    },
                )
                NavigationDrawerItem(
                    label = { Text("Logout", color = GreenPracticeCompose) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
                            contentDescription = "Logout Icon",
                            tint = GreenPracticeCompose
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        Toast.makeText(context, "User logged out", Toast.LENGTH_SHORT).show()
                    },
                )
            }
        },
        drawerState = drawerState,
        gesturesEnabled = true,
    ) {

        Scaffold(
            topBar = {
                AppBar(
                    onPressed = {
                        coroutineScope.launch {
                            drawerState.open()
                        }
                    }
                )
            }, containerColor = MaterialTheme.colorScheme.background,


        ) {
            NavHost(navController = navigationController,
                startDestination = Screens.Home.screen)

                {

                    composable(Screens.Home.screen){Home()}
                    composable(Screens.Profile.screen){Profile()}
                    composable(Screens.Settings.screen){ Settings()}

            }


        }
    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppBar(
    onPressed: () -> Unit,
) {
    val contextHere = LocalContext.current.applicationContext
    TopAppBar(
        title = { Text("WhatsApp") },
        navigationIcon = {
            IconButton(onClick = onPressed) {
                Image(
                    painter = painterResource(R.drawable.whatsapp),
                    contentDescription = "whatsapp icon",
                    colorFilter = ColorFilter.tint(Color.White),
                    modifier = Modifier.size(24.dp)
                )
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = GreenPracticeCompose,
            titleContentColor = Color.White,
            navigationIconContentColor = Color.White
        ),
        actions = {
            IconButton(onClick = {
                Toast.makeText(contextHere, "Profile", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profile Icon",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                Toast.makeText(contextHere, "Search", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search Icon",
                    tint = Color.White
                )
            }
            IconButton(onClick = {
                Toast.makeText(contextHere, "Menu", Toast.LENGTH_SHORT).show()
            }) {
                Icon(
                    imageVector = Icons.Filled.MoreVert,
                    contentDescription = "Menu Icon",
                    tint = Color.White
                )
            }
        }
    )
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