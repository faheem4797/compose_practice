package com.example.composepractice

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.composepractice.ui.theme.ComposePracticeTheme
import com.example.composepractice.ui.theme.GreenPracticeCompose

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {

            ComposePracticeTheme {
//NavComponenet()
                LearnCheckBoxes()
//                CardMaker()
//                Box(
////                    modifier = Modifier.fillMaxSize(),
////                    contentAlignment = Alignment.BottomEnd
//                ) {
////                    Counter()
////                    LearnFAB()
////                    LearnExtendedFAB()
//
//                    YouTubeCard(
//                        YouTubeDataClass(R.drawable.zombatar, "Zombatar", "pheeem")
//                    )
//                }
            }

//            ComposePracticeTheme{ NavDrawer() }

//            ComposePracticeTheme { AppBar(){} }

//            ComposePracticeTheme {
//                Box(
//                    modifier = Modifier.fillMaxSize()
//                        .paint(
//                            painterResource(R.drawable.zombatar),
//                            contentScale = ContentScale.FillBounds
//                        )
//                ){
//                    val navigationController = rememberNavController()
//                    NavGraphMaker(navigationController)
//                }
//            }
        }
    }
}

@Composable
fun LearnCheckBoxes() {
    val todoList: List<String> = listOf(
        "Eat Breakfast", "Buy Groceries", "Go to Gym", "Eat Dinner"
    )
    val context = LocalContext.current.applicationContext
    Column(
        Modifier
            .fillMaxSize()
            .padding(32.dp)) {
        todoList.forEach { it ->
            var checkedItem by remember { mutableStateOf(false) }
            Row {
                Checkbox(


                    checked = checkedItem, onCheckedChange = { checkedStatus ->
                        checkedItem = checkedStatus
                        Toast.makeText(
                            context,
                            "$it is $checkedStatus", Toast.LENGTH_SHORT
                        ).show()
                    }
                )
                Text(
                    it, fontSize = 22.sp,
                    modifier = Modifier.align(Alignment.CenterVertically)
                )
            }
        }

    }
}

//@Composable
//fun CardMaker() {
//    val videoList = listOf(
//        YouTubeDataClass(R.drawable.zombatar, "Zombatar", "pheeem"),
//        YouTubeDataClass(R.drawable.whatsapp, "WhatsApp", "pheeem"),
//        YouTubeDataClass(R.drawable.zombatar, "Zombatar", "pheeem"),
//        YouTubeDataClass(R.drawable.whatsapp, "WhatsApp", "pheeem"),
//        YouTubeDataClass(R.drawable.zombatar, "Zombatar", "pheeem"),
//        YouTubeDataClass(R.drawable.whatsapp, "WhatsApp", "pheeem")
//    )
//
//    LazyColumn(
//        Modifier
//            .fillMaxHeight()
//            .padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)
//    ) {
//        items(videoList) { it ->
//            YouTubeCard(it)
//        }
//    }
//}
//
//@Composable
//fun YouTubeCard(youTubeDataClass: YouTubeDataClass) {
//
//    Card(
//        modifier = Modifier
//            .padding(horizontal = 16.dp, vertical = 10.dp)
//            .fillMaxWidth(),
//        elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
//    ) {
//        Column(
//            modifier = Modifier.background(GreenPracticeCompose)
//        ) {
//            Image(
//                painter = painterResource(youTubeDataClass.thumbnail),
//                contentDescription = null,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .fillMaxSize()
//                    .aspectRatio(16f / 9f)
//            )
//            Column(
//                Modifier
//                    .fillMaxWidth()
//                    .padding(18.dp)
//            ) {
//                Text(
//                    youTubeDataClass.videoTitle,
//                    color = Color.White,
//                    fontWeight = FontWeight.Bold,
//                    fontSize = 18.sp,
//                )
//                Spacer(Modifier.height(4.dp))
//                Text(
//                    youTubeDataClass.channelName,
//                    color = Color.White,
//                    maxLines = 1,
////                    fontWeight = FontWeight.Bold,
//                    fontSize = 14.sp,
//                )
//            }
//        }
//    }
//}

//@Composable
//fun LearnFAB(){
//    val context = LocalContext.current.applicationContext
//    FloatingActionButton(
//        modifier = Modifier.padding(16.dp),
//        containerColor = GreenPracticeCompose,
//        onClick = {
//            Toast.makeText(context,"FAB CLICKED", Toast.LENGTH_SHORT).show()
//        }
//    ) {
//        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
//    }
//}

//@Composable
//fun LearnExtendedFAB() {
//    val context = LocalContext.current.applicationContext
//    ExtendedFloatingActionButton(
//        modifier = Modifier.padding(16.dp),
//        containerColor = GreenPracticeCompose,
//        onClick = {
//            Toast.makeText(context, " Extended FAB CLICKED", Toast.LENGTH_SHORT).show()
//        }
//    ) {
//        Icon(imageVector = Icons.Filled.Add, contentDescription = null)
//        Text("FAB")
//    }
//
//}

//@Composable
//fun Counter(myViewModel: MyViewModel = viewModel()){
//    Button(onClick = {
//       myViewModel. incrementCounter()
//    }) {
//        Text("Count: " + myViewModel.count)
//    }
//}

//@Composable
//fun NavComponenet(){
//    val navigationController = rememberNavController()
//
//    NavHost( navigationController,startDestination = Screens.Home.screen) {
//        composable(Screens.Home.screen) { Home(navigationController)  }
//        composable(Screens.Profile.screen) { Profile()  }
//    }
//}

//@Composable
//fun LearnConstraintLayout() {
//
//    ConstraintLayout(Modifier.fillMaxSize()) {
//        val (redButton, greenButton, blueButton, blackButton) = createRefs()
//        createHorizontalChain(greenButton, blueButton, chainStyle = ChainStyle.Spread)
//        val guideLineForBlackButton = createGuidelineFromBottom(0.5f)
//        Button(onClick = {},
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Red),
//            modifier = Modifier.constrainAs(redButton) {
//                top.linkTo(parent.top)
//                start.linkTo(parent.start)
//                end.linkTo(parent.end)
//                width = Dimension.matchParent
//                height = Dimension.fillToConstraints
//            }
//        ) {
//            Text("Red")
//        }
//
//        Button(onClick = {},
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
//            modifier = Modifier.constrainAs(greenButton) {
//                top.linkTo(redButton.bottom)
////                    start.linkTo(parent.start)
////                    end.linkTo(parent.end)
//            }
//        ) {
//            Text("Green")
//        }
//        Button(onClick = {},
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
//            modifier = Modifier.constrainAs(blueButton) {
//                top.linkTo(redButton.bottom)
////                    start.linkTo(parent.start)
////                    end.linkTo(parent.end)
//            }
//        ) {
//            Text("Blue")
//        }
//        Button(onClick = {},
//            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
//            modifier = Modifier.constrainAs(blackButton) {
//                bottom.linkTo(guideLineForBlackButton)
//                start.linkTo(parent.start)
//                end.linkTo(parent.end)
//            }
//        ) {
//            Text("Black")
//        }
//
//
//    }
//
//}

//@Composable
//fun DisplayList(listOfFruits: List<String>) {
//    LazyRow() {
//        items(count = listOfFruits.size) {
//            Text(listOfFruits[it] + " ", fontSize = 32.sp, color = Color.Red)
//        }
//    }
//}
//
//@Composable
//fun LoginScreen(onLoginSuccess: () -> Unit) {
//    var username by remember { mutableStateOf("") }
//    var password by remember { mutableStateOf("") }
//    val context = LocalContext.current.applicationContext
//
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(horizontal = 26.dp, vertical = 140.dp),
//        verticalArrangement = Arrangement.Bottom,
//        horizontalAlignment = Alignment.CenterHorizontally
//    ) {
//        OutlinedTextField(
//            value = username,
//            onValueChange = {
//                username = it
//            }, label = { Text("Username") },
//            shape = RoundedCornerShape(20.dp),
//            colors = TextFieldDefaults.colors(
//                focusedTextColor = Color.Black,
//                unfocusedTextColor = Color.Black,
//                focusedLeadingIconColor = GreenPracticeCompose,
//                unfocusedLeadingIconColor = GreenPracticeCompose,
//                focusedLabelColor = GreenPracticeCompose,
//                unfocusedLabelColor = GreenPracticeCompose,
//                focusedContainerColor = Color.White,
//                unfocusedContainerColor = Color.White,
//                focusedIndicatorColor = GreenPracticeCompose,
//                unfocusedIndicatorColor = GreenPracticeCompose,
//                unfocusedPlaceholderColor = GreenPracticeCompose
//            ),
//            leadingIcon = {
//                Icon(imageVector = Icons.Default.Person, contentDescription = null)
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 8.dp)
//        )
//        OutlinedTextField(
//            value = password,
//            onValueChange = {
//                password = it
//            }, label = { Text("Password") },
//            shape = RoundedCornerShape(20.dp),
//            colors = TextFieldDefaults.colors(
//                focusedTextColor = Color.Black,
//                unfocusedTextColor = Color.Black,
//                focusedLeadingIconColor = GreenPracticeCompose,
//                unfocusedLeadingIconColor = GreenPracticeCompose,
//                focusedLabelColor = GreenPracticeCompose,
//                unfocusedLabelColor = GreenPracticeCompose,
//                focusedContainerColor = Color.White,
//                unfocusedContainerColor = Color.White,
//                focusedIndicatorColor = GreenPracticeCompose,
//                unfocusedIndicatorColor = GreenPracticeCompose,
//                unfocusedPlaceholderColor = GreenPracticeCompose
//            ),
//            leadingIcon = {
//                Icon(imageVector = Icons.Default.Lock, contentDescription = null)
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 8.dp),
//            visualTransformation = PasswordVisualTransformation()
//        )
//        Button(
//            onClick = {
//                if (authenticate(username = username, password = password)) {
//                    onLoginSuccess()
//                    Toast.makeText(context, "Login Successful", Toast.LENGTH_SHORT).show()
//                } else {
//                    Toast.makeText(context, "Invalid Credentials", Toast.LENGTH_SHORT).show()
//
//                }
//            },
//            colors = ButtonDefaults.buttonColors(
//                GreenPracticeCompose, Color.White
//            ),
//            contentPadding = PaddingValues(horizontal = 60.dp, vertical = 8.dp),
//            modifier = Modifier.padding(top = 18.dp)
//        ) {
//            Text("Login", fontSize = 22.sp)
//        }
//    }
//}

//@Composable
//fun NavGraphMaker(navigationController: NavHostController) {
//    NavHost(
//        navController = navigationController,
//        startDestination = "login"
//    ) {
//        composable("login") {
//            LoginScreen(onLoginSuccess = {
//                navigationController.navigate("home") {
//                    popUpTo(0)
//                }
//            })
//        }
//        composable("home") { Home() }
//    }
//}
//
//private fun authenticate(username: String, password: String): Boolean {
//    val validUsername = "admin"
//    val validPassword = "admin123"
//    return username == validUsername && password == validPassword
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyApp() {
//    val navigationController = rememberNavController()
//    val context = LocalContext.current.applicationContext
//    val selected = remember {
//        mutableStateOf(Icons.Default.Home)
//    }
//    val sheetState = rememberModalBottomSheetState()
//    var showBottomSheet by remember { mutableStateOf(false) }
//    val coroutineScope = rememberCoroutineScope()
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//
//    ModalNavigationDrawer(
//        drawerContent = {
//            ModalDrawerSheet(
//                modifier = Modifier.padding(0.dp, 0.dp, 50.dp, 0.dp)
//            ) {
//                Box(
//                    modifier = Modifier
//                        .background(GreenPracticeCompose)
//                        .fillMaxWidth()
//                        .height(150.dp)
//                )
//                HorizontalDivider()
//                NavigationDrawerItem(
//                    label = { Text("Home", color = GreenPracticeCompose) },
//                    selected = false,
//                    icon = {
//                        Icon(
//                            imageVector = Icons.Default.Home,
//                            contentDescription = "Home Icon",
//                            tint = GreenPracticeCompose
//                        )
//                    },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        selected.value = Icons.Default.Home
//                        navigationController.navigate(Screens.Home.screen) {
//                            popUpTo(0)
//                        }
//                    },
//                )
//                NavigationDrawerItem(
//                    label = { Text("Profile", color = GreenPracticeCompose) },
//                    selected = false,
//                    icon = {
//                        Icon(
//                            imageVector = Icons.Default.Person,
//                            contentDescription = "Profile Icon",
//                            tint = GreenPracticeCompose
//                        )
//                    },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        selected.value = Icons.Default.Person
//                        navigationController.navigate(Screens.Profile.screen) {
//                            popUpTo(0)
//                        }
//                    },
//                )
//                NavigationDrawerItem(
//                    label = { Text("Settings", color = GreenPracticeCompose) },
//                    selected = false,
//                    icon = {
//                        Icon(
//                            imageVector = Icons.Default.Home,
//                            contentDescription = "Settings Icon",
//                            tint = GreenPracticeCompose
//                        )
//                    },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        selected.value = Icons.Default.Settings
//                        navigationController.navigate(Screens.Settings.screen) {
//                            popUpTo(0)
//                        }
//                    },
//                )
//                NavigationDrawerItem(
//                    label = { Text("Notifications", color = GreenPracticeCompose) },
//                    selected = false,
//                    icon = {
//                        Icon(
//                            imageVector = Icons.Default.Notifications,
//                            contentDescription = "Notifications Icon",
//                            tint = GreenPracticeCompose
//                        )
//                    },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        selected.value = Icons.Default.Notifications
//                        navigationController.navigate(Screens.Notifications.screen) {
//                            popUpTo(0)
//                        }
//                    },
//                )
//                NavigationDrawerItem(
//                    label = { Text("Logout", color = GreenPracticeCompose) },
//                    selected = false,
//                    icon = {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
//                            contentDescription = "Logout Icon",
//                            tint = GreenPracticeCompose
//                        )
//                    },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        Toast.makeText(context, "User logged out", Toast.LENGTH_SHORT).show()
//                    },
//                )
//            }
//        },
//        drawerState = drawerState,
//        gesturesEnabled = true,
//    )
//    {
//        Scaffold(
//            topBar = {
//                AppBar(onPressed = {
//                    coroutineScope.launch {
//                        drawerState.open()
//                    }
//                })
//            },
//            containerColor = MaterialTheme.colorScheme.background,
//
//            bottomBar = {
//                BottomAppBar(
//                    containerColor = GreenPracticeCompose
//                ) {
//                    IconButton(
//                        onClick = {
//                            selected.value = Icons.Default.Home
//                            navigationController.navigate(Screens.Home.screen) {
//                                popUpTo(0)
//                            }
//                        },
//                        modifier = Modifier.weight(1f),
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.Home,
//                            contentDescription = "Home Icon",
//                            modifier = Modifier.size(26.dp),
//                            tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
//                        )
//                    }
//                    IconButton(
//                        onClick = {
//                            selected.value = Icons.Default.Settings
//                            navigationController.navigate(Screens.Settings.screen) {
//                                popUpTo(0)
//                            }
//                        },
//                        modifier = Modifier.weight(1f),
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.Settings,
//                            contentDescription = "Settings Icon",
//                            modifier = Modifier.size(26.dp),
//                            tint = if (selected.value == Icons.Default.Settings) Color.White else Color.DarkGray
//                        )
//                    }
//                    //
//                    //
//                    Box(
//                        modifier = Modifier
//                            .weight(1f)
//                            .padding(16.dp),
//                    ) {
//                        FloatingActionButton(onClick = {
//                            showBottomSheet = true
//
//
//                        }, modifier = Modifier.align(Alignment.Center)) {
//                            Icon(
//                                imageVector = Icons.Default.Add,
//                                contentDescription = "Add Icon",
//                                tint = GreenPracticeCompose
//                            )
//                        }
//                    }
//                    //
//                    //
//                    IconButton(
//                        onClick = {
//                            selected.value = Icons.Default.Person
//                            navigationController.navigate(Screens.Profile.screen) {
//                                popUpTo(0)
//                            }
//                        },
//                        modifier = Modifier.weight(1f),
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.Person,
//                            contentDescription = "Profile Icon",
//                            modifier = Modifier.size(26.dp),
//                            tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray
//                        )
//                    }
//
//                    IconButton(
//                        onClick = {
//                            selected.value = Icons.Default.Notifications
//                            navigationController.navigate(Screens.Notifications.screen) {
//                                popUpTo(0)
//                            }
//                        },
//                        modifier = Modifier.weight(1f),
//                    ) {
//                        Icon(
//                            imageVector = Icons.Default.Notifications,
//                            contentDescription = "Notifications Icon",
//                            modifier = Modifier.size(26.dp),
//                            tint = if (selected.value == Icons.Default.Notifications) Color.White else Color.DarkGray
//                        )
//                    }
//                }
//            }) { paddingValues ->
//            NavHost(
//                navController = navigationController,
//                startDestination = Screens.Home.screen,
//                modifier = Modifier.padding(paddingValues)
//            ) {
//                composable(Screens.Home.screen) { Home() }
//                composable(Screens.Profile.screen) { Profile() }
//                composable(Screens.Settings.screen) { Settings() }
//                composable(Screens.Notifications.screen) { Notifications() }
//                composable(Screens.Post.screen) { Post() }
//            }
//
//        }
//    }
//    if (showBottomSheet) {
//        ModalBottomSheet(
//            onDismissRequest = { showBottomSheet = false },
//            sheetState = sheetState,
//            windowInsets = BottomSheetDefaults.windowInsets.add(
//                WindowInsets(
//                    left = 0.dp,
//                    right = 0.dp,
//                    top = 0.dp,
//                    bottom = 50.dp
//                )
//            )
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(18.dp),
//                verticalArrangement = Arrangement.spacedBy(20.dp)
//            ) {
//                BottomSheetItem(
//                    icon = Icons.Default.ThumbUp, title = "Create a Post",
//                ) {
//                    showBottomSheet = false
//                    navigationController.navigate(Screens.Post.screen) {
//                        popUpTo(0)
//                    }
//                }
//                BottomSheetItem(
//                    icon = Icons.Default.Star, title = "Add a Story",
//                ) {
//                    showBottomSheet = false
//                    Toast.makeText(context, "Add a Story", Toast.LENGTH_SHORT).show()
//                }
//                BottomSheetItem(
//                    icon = Icons.Default.PlayArrow, title = "Create a Reel",
//                ) {
//                    showBottomSheet = false
//                    Toast.makeText(context, "Create a Reel", Toast.LENGTH_SHORT).show()
//                }
//                BottomSheetItem(
//                    icon = Icons.Default.Favorite, title = "Go Live",
//                ) {
//                    showBottomSheet = false
//                    Toast.makeText(context, "Go Live", Toast.LENGTH_SHORT).show()
//                }
//
//            }
//
//        }
//    }
//}

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun MyBottomAppBar() {
//    val navigationController = rememberNavController()
//    val context = LocalContext.current.applicationContext
//    val selected = remember {
//        mutableStateOf(Icons.Default.Home)
//    }
//    val sheetState = rememberModalBottomSheetState()
//    var showBottomSheet by remember { mutableStateOf(false) }
//    Scaffold(bottomBar = {
//        BottomAppBar(
//            containerColor = GreenPracticeCompose
//        ) {
//            IconButton(
//                onClick = {
//                    selected.value = Icons.Default.Home
//                    navigationController.navigate(Screens.Home.screen) {
//                        popUpTo(0)
//                    }
//                },
//                modifier = Modifier.weight(1f),
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Home,
//                    contentDescription = "Home Icon",
//                    modifier = Modifier.size(26.dp),
//                    tint = if (selected.value == Icons.Default.Home) Color.White else Color.DarkGray
//                )
//            }
//            IconButton(
//                onClick = {
//                    selected.value = Icons.Default.Settings
//                    navigationController.navigate(Screens.Settings.screen) {
//                        popUpTo(0)
//                    }
//                },
//                modifier = Modifier.weight(1f),
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Settings,
//                    contentDescription = "Settings Icon",
//                    modifier = Modifier.size(26.dp),
//                    tint = if (selected.value == Icons.Default.Settings) Color.White else Color.DarkGray
//                )
//            }
//            //
//            //
//            Box(
//                modifier = Modifier
//                    .weight(1f)
//                    .padding(16.dp),
//            ) {
//                FloatingActionButton(onClick = {
//                    showBottomSheet = true
//
//
//                }, modifier = Modifier.align(Alignment.Center)) {
//                    Icon(
//                        imageVector = Icons.Default.Add,
//                        contentDescription = "Add Icon",
//                        tint = GreenPracticeCompose
//                    )
//                }
//            }
//            //
//            //
//            IconButton(
//                onClick = {
//                    selected.value = Icons.Default.Person
//                    navigationController.navigate(Screens.Profile.screen) {
//                        popUpTo(0)
//                    }
//                },
//                modifier = Modifier.weight(1f),
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Person,
//                    contentDescription = "Profile Icon",
//                    modifier = Modifier.size(26.dp),
//                    tint = if (selected.value == Icons.Default.Person) Color.White else Color.DarkGray
//                )
//            }
//
//            IconButton(
//                onClick = {
//                    selected.value = Icons.Default.Notifications
//                    navigationController.navigate(Screens.Notifications.screen) {
//                        popUpTo(0)
//                    }
//                },
//                modifier = Modifier.weight(1f),
//            ) {
//                Icon(
//                    imageVector = Icons.Default.Notifications,
//                    contentDescription = "Notifications Icon",
//                    modifier = Modifier.size(26.dp),
//                    tint = if (selected.value == Icons.Default.Notifications) Color.White else Color.DarkGray
//                )
//            }
//        }
//    }) { paddingValues ->
//        NavHost(
//            navController = navigationController,
//            startDestination = Screens.Home.screen,
//            modifier = Modifier.padding(paddingValues)
//        ) {
//            composable(Screens.Home.screen) { Home() }
//            composable(Screens.Profile.screen) { Profile() }
//            composable(Screens.Settings.screen) { Settings() }
//            composable(Screens.Notifications.screen) { Notifications() }
//            composable(Screens.Post.screen) { Post() }
//        }
//
//    }
//    if (showBottomSheet) {
//        ModalBottomSheet(
//            onDismissRequest = { showBottomSheet = false },
//            sheetState = sheetState,
//            windowInsets = BottomSheetDefaults.windowInsets.add(
//                WindowInsets(
//                    left = 0.dp,
//                    right = 0.dp,
//                    top = 0.dp,
//                    bottom = 50.dp
//                )
//            )
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .padding(18.dp),
//                verticalArrangement = Arrangement.spacedBy(20.dp)
//            ) {
//                BottomSheetItem(
//                    icon = Icons.Default.ThumbUp, title = "Create a Post",
//                ) {
//                    showBottomSheet = false
//                    navigationController.navigate(Screens.Post.screen) {
//                        popUpTo(0)
//                    }
//                }
//                BottomSheetItem(
//                    icon = Icons.Default.Star, title = "Add a Story",
//                ) {
//                    showBottomSheet = false
//                    Toast.makeText(context, "Add a Story", Toast.LENGTH_SHORT).show()
//                }
//                BottomSheetItem(
//                    icon = Icons.Default.PlayArrow, title = "Create a Reel",
//                ) {
//                    showBottomSheet = false
//                    Toast.makeText(context, "Create a Reel", Toast.LENGTH_SHORT).show()
//                }
//                BottomSheetItem(
//                    icon = Icons.Default.Favorite, title = "Go Live",
//                ) {
//                    showBottomSheet = false
//                    Toast.makeText(context, "Go Live", Toast.LENGTH_SHORT).show()
//                }
//
//            }
//
//        }
//    }
//}

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


//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
//@Composable
//fun NavDrawer() {
//    val navigationController = rememberNavController()
//    val coroutineScope = rememberCoroutineScope()
//    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
//    val context = LocalContext.current.applicationContext
//
//    ModalNavigationDrawer(
//        drawerContent = {
//            ModalDrawerSheet(
//                modifier = Modifier.padding(0.dp, 0.dp, 50.dp, 0.dp)
//            ) {
//                Box(
//                    modifier = Modifier
//                        .background(GreenPracticeCompose)
//                        .fillMaxWidth()
//                        .height(150.dp)
//                )
//                HorizontalDivider()
//                NavigationDrawerItem(
//                    label = { Text("Home", color = GreenPracticeCompose) },
//                    selected = false,
//                    icon = {
//                        Icon(
//                            imageVector = Icons.Default.Home,
//                            contentDescription = "Home Icon",
//                            tint = GreenPracticeCompose
//                        )
//                    },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        navigationController.navigate(Screens.Home.screen) {
//                            popUpTo(0)
//                        }
//                    },
//                )
//                NavigationDrawerItem(
//                    label = { Text("Profile", color = GreenPracticeCompose) },
//                    selected = false,
//                    icon = {
//                        Icon(
//                            imageVector = Icons.Default.Person,
//                            contentDescription = "Profile Icon",
//                            tint = GreenPracticeCompose
//                        )
//                    },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        navigationController.navigate(Screens.Profile.screen) {
//                            popUpTo(0)
//                        }
//                    },
//                )
//                NavigationDrawerItem(
//                    label = { Text("Settings", color = GreenPracticeCompose) },
//                    selected = false,
//                    icon = {
//                        Icon(
//                            imageVector = Icons.Default.Home,
//                            contentDescription = "Settings Icon",
//                            tint = GreenPracticeCompose
//                        )
//                    },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        navigationController.navigate(Screens.Settings.screen) {
//                            popUpTo(0)
//                        }
//                    },
//                )
//                NavigationDrawerItem(
//                    label = { Text("Logout", color = GreenPracticeCompose) },
//                    selected = false,
//                    icon = {
//                        Icon(
//                            imageVector = Icons.AutoMirrored.Filled.ExitToApp,
//                            contentDescription = "Logout Icon",
//                            tint = GreenPracticeCompose
//                        )
//                    },
//                    onClick = {
//                        coroutineScope.launch {
//                            drawerState.close()
//                        }
//                        Toast.makeText(context, "User logged out", Toast.LENGTH_SHORT).show()
//                    },
//                )
//            }
//        },
//        drawerState = drawerState,
//        gesturesEnabled = true,
//    ) {
//
//        Scaffold(
//            topBar = {
//                AppBar(onPressed = {
//                    coroutineScope.launch {
//                        drawerState.open()
//                    }
//                })
//            },
//            containerColor = MaterialTheme.colorScheme.background,
//
//
//            ) {
//            NavHost(
//                navController = navigationController, startDestination = Screens.Home.screen
//            )
//
//            {
//
//                composable(Screens.Home.screen) { Home() }
//                composable(Screens.Profile.screen) { Profile() }
//                composable(Screens.Settings.screen) { Settings() }
//
//            }
//
//
//        }
//    }
//
//}

//@OptIn(ExperimentalMaterial3Api::class)
//@Composable
//fun AppBar(
//    onPressed: () -> Unit,
//) {
//    val contextHere = LocalContext.current.applicationContext
//    TopAppBar(title = { Text("WhatsApp") }, navigationIcon = {
//        IconButton(onClick = onPressed) {
//            Image(
//                painter = painterResource(R.drawable.whatsapp),
//                contentDescription = "whatsapp icon",
//                colorFilter = ColorFilter.tint(Color.White),
//                modifier = Modifier.size(24.dp)
//            )
//        }
//    }, colors = TopAppBarDefaults.topAppBarColors(
//        containerColor = GreenPracticeCompose,
//        titleContentColor = Color.White,
//        navigationIconContentColor = Color.White
//    ), actions = {
//        IconButton(onClick = {
//            Toast.makeText(contextHere, "Profile", Toast.LENGTH_SHORT).show()
//        }) {
//            Icon(
//                imageVector = Icons.Filled.Person,
//                contentDescription = "Profile Icon",
//                tint = Color.White
//            )
//        }
//        IconButton(onClick = {
//            Toast.makeText(contextHere, "Search", Toast.LENGTH_SHORT).show()
//        }) {
//            Icon(
//                imageVector = Icons.Filled.Search,
//                contentDescription = "Search Icon",
//                tint = Color.White
//            )
//        }
//        IconButton(onClick = {
//            Toast.makeText(contextHere, "Menu", Toast.LENGTH_SHORT).show()
//        }) {
//            Icon(
//                imageVector = Icons.Filled.MoreVert,
//                contentDescription = "Menu Icon",
//                tint = Color.White
//            )
//        }
//    })
//}
//
//@Composable
//fun AddThreeButtonRow(
//    first: String,
//    second: String,
//    operator: String,
//    isTopRow: Boolean,
//    buttonPressedNotation: (String) -> Unit,
//) {
//    Row(
//        horizontalArrangement = Arrangement.spacedBy(4.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(72.dp)
//    ) {
//        Button(
//            onClick = {
//                buttonPressedNotation(first)
//            },
//            colors = ButtonDefaults.buttonColors(containerColor = if (isTopRow) Color.Gray else Color.Black),
//            modifier = Modifier
//                .weight(2f)
//                .fillMaxHeight()
//        ) { Text(first, fontSize = 24.sp, fontWeight = FontWeight.Bold) }
//        Button(
//            onClick = {
//                buttonPressedNotation(second)
//            },
//            modifier = Modifier
//                .weight(1f)
//                .fillMaxHeight(),
//            colors = ButtonDefaults.buttonColors(containerColor = if (isTopRow) Color.Gray else Color.Black),
//
//            ) { Text(second, fontSize = 24.sp, fontWeight = FontWeight.Bold) }
//        Button(
//            onClick = {
//                buttonPressedNotation(operator)
//            }, modifier = Modifier
//                .weight(1f)
//                .fillMaxHeight(), colors = ButtonDefaults.buttonColors(
//                containerColor = Color(0xFFFFA500)
//            )
//
//        ) { Text(operator, fontSize = 24.sp, fontWeight = FontWeight.Bold) }
//    }
//}

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