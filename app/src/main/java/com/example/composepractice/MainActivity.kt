package com.example.composepractice

import android.annotation.SuppressLint

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.add
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ExitToApp
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.material3.rememberModalBottomSheetState
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.composepractice.ui.theme.ComposePracticeTheme
import com.example.composepractice.ui.theme.GreenPracticeCompose
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {

//            ComposePracticeTheme{ NavDrawer() }

//            ComposePracticeTheme { AppBar(){} }

            ComposePracticeTheme {
                MyApp()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyApp(){
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    val coroutineScope = rememberCoroutineScope()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.padding(0.dp, 0.dp, 50.dp, 0.dp)
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
                        selected.value = Icons.Default.Home
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
                        selected.value = Icons.Default.Person
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
                        selected.value = Icons.Default.Settings
                        navigationController.navigate(Screens.Settings.screen) {
                            popUpTo(0)
                        }
                    },
                )
                NavigationDrawerItem(
                    label = { Text("Notifications", color = GreenPracticeCompose) },
                    selected = false,
                    icon = {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications Icon",
                            tint = GreenPracticeCompose
                        )
                    },
                    onClick = {
                        coroutineScope.launch {
                            drawerState.close()
                        }
                        selected.value = Icons.Default.Notifications
                        navigationController.navigate(Screens.Notifications.screen) {
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
    )
    {
        Scaffold(
            topBar = {
                AppBar(onPressed = {
                coroutineScope.launch {
                    drawerState.open()
                }
                })
            },
            containerColor = MaterialTheme.colorScheme.background,

            bottomBar = {
                BottomAppBar(
                    containerColor = GreenPracticeCompose
                ) {
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Home
                            navigationController.navigate(Screens.Home.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Home Icon",
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                        )
                    }
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Settings
                            navigationController.navigate(Screens.Settings.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Settings,
                            contentDescription = "Settings Icon",
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Settings) Color.White else Color.DarkGray
                        )
                    }
                    //
                    //
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .padding(16.dp),
                    ) {
                        FloatingActionButton(onClick = {
                            showBottomSheet = true


                        }, modifier = Modifier.align(Alignment.Center)) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add Icon",
                                tint = GreenPracticeCompose
                            )
                        }
                    }
                    //
                    //
                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Person
                            navigationController.navigate(Screens.Profile.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Person,
                            contentDescription = "Profile Icon",
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray
                        )
                    }

                    IconButton(
                        onClick = {
                            selected.value = Icons.Default.Notifications
                            navigationController.navigate(Screens.Notifications.screen) {
                                popUpTo(0)
                            }
                        },
                        modifier = Modifier.weight(1f),
                    ) {
                        Icon(
                            imageVector = Icons.Default.Notifications,
                            contentDescription = "Notifications Icon",
                            modifier = Modifier.size(26.dp),
                            tint = if (selected.value == Icons.Default.Notifications) Color.White else Color.DarkGray
                        )
                    }
                }
            }) { paddingValues ->
            NavHost(
                navController = navigationController,
                startDestination = Screens.Home.screen,
                modifier = Modifier.padding(paddingValues)
            ) {
                composable(Screens.Home.screen) { Home() }
                composable(Screens.Profile.screen) { Profile() }
                composable(Screens.Settings.screen) { Settings() }
                composable(Screens.Notifications.screen) { Notifications() }
                composable(Screens.Post.screen) { Post() }
            }

        }
    }
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            windowInsets = BottomSheetDefaults.windowInsets.add(WindowInsets(left = 0.dp, right = 0.dp, top = 0.dp, bottom = 50.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                BottomSheetItem(
                    icon = Icons.Default.ThumbUp, title = "Create a Post",
                ) {
                    showBottomSheet = false
                    navigationController.navigate(Screens.Post.screen) {
                        popUpTo(0)
                    }
                }
                BottomSheetItem(
                    icon = Icons.Default.Star, title = "Add a Story",
                ) {
                    showBottomSheet = false
                    Toast.makeText(context,"Add a Story",Toast.LENGTH_SHORT).show()
                }
                BottomSheetItem(
                    icon = Icons.Default.PlayArrow, title = "Create a Reel",
                ) {
                    showBottomSheet = false
                    Toast.makeText(context,"Create a Reel",Toast.LENGTH_SHORT).show()
                }
                BottomSheetItem(
                    icon = Icons.Default.Favorite, title = "Go Live",
                ) {
                    showBottomSheet = false
                    Toast.makeText(context,"Go Live",Toast.LENGTH_SHORT).show()
                }

            }

        }
    }
}

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyBottomAppBar() {
    val navigationController = rememberNavController()
    val context = LocalContext.current.applicationContext
    val selected = remember {
        mutableStateOf(Icons.Default.Home)
    }
    val sheetState = rememberModalBottomSheetState()
    var showBottomSheet by remember { mutableStateOf(false) }
    Scaffold(bottomBar = {
        BottomAppBar(
            containerColor = GreenPracticeCompose
        ) {
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Home
                    navigationController.navigate(Screens.Home.screen) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.weight(1f),
            ) {
                Icon(
                    imageVector = Icons.Default.Home,
                    contentDescription = "Home Icon",
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
                )
            }
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Settings
                    navigationController.navigate(Screens.Settings.screen) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.weight(1f),
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings Icon",
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Settings) Color.White else Color.DarkGray
                )
            }
            //
            //
            Box(
                modifier = Modifier
                    .weight(1f)
                    .padding(16.dp),
            ) {
                FloatingActionButton(onClick = {
                    showBottomSheet = true


                }, modifier = Modifier.align(Alignment.Center)) {
                    Icon(
                        imageVector = Icons.Default.Add,
                        contentDescription = "Add Icon",
                        tint = GreenPracticeCompose
                    )
                }
            }
            //
            //
            IconButton(
                onClick = {
                    selected.value = Icons.Default.Person
                    navigationController.navigate(Screens.Profile.screen) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.weight(1f),
            ) {
                Icon(
                    imageVector = Icons.Default.Person,
                    contentDescription = "Profile Icon",
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray
                )
            }

            IconButton(
                onClick = {
                    selected.value = Icons.Default.Notifications
                    navigationController.navigate(Screens.Notifications.screen) {
                        popUpTo(0)
                    }
                },
                modifier = Modifier.weight(1f),
            ) {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications Icon",
                    modifier = Modifier.size(26.dp),
                    tint = if (selected.value == Icons.Default.Notifications) Color.White else Color.DarkGray
                )
            }
        }
    }) { paddingValues ->
        NavHost(
            navController = navigationController,
            startDestination = Screens.Home.screen,
            modifier = Modifier.padding(paddingValues)
        ) {
            composable(Screens.Home.screen) { Home() }
            composable(Screens.Profile.screen) { Profile() }
            composable(Screens.Settings.screen) { Settings() }
            composable(Screens.Notifications.screen) { Notifications() }
            composable(Screens.Post.screen) { Post()  }
        }

    }
    if (showBottomSheet) {
        ModalBottomSheet(
            onDismissRequest = { showBottomSheet = false },
            sheetState = sheetState,
            windowInsets = BottomSheetDefaults.windowInsets.add(WindowInsets(left = 0.dp, right = 0.dp, top = 0.dp, bottom = 50.dp))
            ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp)
            ) {
                BottomSheetItem(
                    icon = Icons.Default.ThumbUp, title = "Create a Post",
                    ) {
                    showBottomSheet = false
                    navigationController.navigate(Screens.Post.screen) {
                        popUpTo(0)
                    }
                }
                BottomSheetItem(
                    icon = Icons.Default.Star, title = "Add a Story",
                ) {
                    showBottomSheet = false
                    Toast.makeText(context,"Add a Story",Toast.LENGTH_SHORT).show()
                }
                BottomSheetItem(
                    icon = Icons.Default.PlayArrow, title = "Create a Reel",
                ) {
                    showBottomSheet = false
                    Toast.makeText(context,"Create a Reel",Toast.LENGTH_SHORT).show()
                }
                BottomSheetItem(
                    icon = Icons.Default.Favorite, title = "Go Live",
                ) {
                    showBottomSheet = false
                    Toast.makeText(context,"Go Live",Toast.LENGTH_SHORT).show()
                }

            }

        }
    }
}

@Composable
fun BottomSheetItem(icon: ImageVector, title: String, onClick: () -> Unit) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.clickable { onClick() }
    ) {
        Icon(icon, contentDescription = null, tint = GreenPracticeCompose)
        Text(text = title, color = GreenPracticeCompose, fontSize = 22.sp)
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
                modifier = Modifier.padding(0.dp, 0.dp, 50.dp, 0.dp)
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
                AppBar(onPressed = {
                    coroutineScope.launch {
                        drawerState.open()
                    }
                })
            },
            containerColor = MaterialTheme.colorScheme.background,


            ) {
            NavHost(
                navController = navigationController, startDestination = Screens.Home.screen
            )

            {

                composable(Screens.Home.screen) { Home() }
                composable(Screens.Profile.screen) { Profile() }
                composable(Screens.Settings.screen) { Settings() }

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
    TopAppBar(title = { Text("WhatsApp") }, navigationIcon = {
        IconButton(onClick = onPressed) {
            Image(
                painter = painterResource(R.drawable.whatsapp),
                contentDescription = "whatsapp icon",
                colorFilter = ColorFilter.tint(Color.White),
                modifier = Modifier.size(24.dp)
            )
        }
    }, colors = TopAppBarDefaults.topAppBarColors(
        containerColor = GreenPracticeCompose,
        titleContentColor = Color.White,
        navigationIconContentColor = Color.White
    ), actions = {
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
    })
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
            colors = ButtonDefaults.buttonColors(containerColor = if (isTopRow) Color.Gray else Color.Black),
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
            colors = ButtonDefaults.buttonColors(containerColor = if (isTopRow) Color.Gray else Color.Black),

            ) { Text(second, fontSize = 24.sp, fontWeight = FontWeight.Bold) }
        Button(
            onClick = {
                buttonPressedNotation(operator)
            }, modifier = Modifier
                .weight(1f)
                .fillMaxHeight(), colors = ButtonDefaults.buttonColors(
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
            }, modifier = Modifier
                .weight(1f)
                .fillMaxHeight(), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {

            Text(firstDigit, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Button(
            onClick = {
                buttonPressedNotation(secondDigit)
            }, modifier = Modifier
                .weight(1f)
                .fillMaxHeight(), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {

            Text(secondDigit, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Button(
            onClick = {
                buttonPressedNotation(thirdDigit)
            }, modifier = Modifier
                .weight(1f)
                .fillMaxHeight(), colors = ButtonDefaults.buttonColors(
                containerColor = Color.Black
            )
        ) {

            Text(thirdDigit, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        }
        Button(
            onClick = {
                buttonPressedNotation(operator)
            }, modifier = Modifier
                .weight(1f)
                .fillMaxHeight(), colors = ButtonDefaults.buttonColors(
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