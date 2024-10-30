package com.example.composepractice

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import com.example.composepractice.ui.theme.ComposePracticeTheme
import com.example.composepractice.ui.theme.MyGrey
import com.example.composepractice.ui.theme.MyRed


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        installSplashScreen()
        setContent {

            ComposePracticeTheme {
                ZomatoUI()
            }

        }
    }
}

//@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ZomatoUI() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Zomato", fontWeight = FontWeight.Bold) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MyRed,
                    titleContentColor = MyGrey
                ),
                actions = {
                    IconButton(onClick = {
                        TODO()
                    }) {
                        Image(
                            painter = painterResource(R.drawable.profile), contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .background(MyGrey)
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("Search Restaurants...") },
                shape = RoundedCornerShape(32.dp),
                trailingIcon = {
                    IconButton(onClick = {}, modifier = Modifier.padding(end = 8.dp)) {
                        Image(
                            painter = painterResource(R.drawable.search), contentDescription = null,
                            contentScale = ContentScale.Crop
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedLabelColor = MyRed,
                    unfocusedLabelColor = Color.Gray,
                    unfocusedBorderColor = Color.Gray,
                    focusedBorderColor = MyRed,
                    cursorColor = MyRed,
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Banner()
            Text("CATEGORIES", color = Color.Black, fontWeight = FontWeight.Bold, fontSize = 18.sp)
            ItemCardRowMaker(
                firstTitle = "Cake", R.drawable.cake,
                secondTitle = "Pizza", R.drawable.pizza,
                thirdTitle = "Sandwich", R.drawable.sandwiches
            )
            ItemCardRowMaker(
                firstTitle = "Noodles", R.drawable.noodles,
                secondTitle = "Pasta", R.drawable.pasta,
                thirdTitle = "Biryani", R.drawable.biryani
            )
            ItemCardRowMaker(
                firstTitle = "Burger", R.drawable.burger,
                secondTitle = "Ice Cream", R.drawable.icecream,
                thirdTitle = "Dal Rice", R.drawable.dalrice
            )
        }

    }
}

@Composable
fun ItemCardRowMaker(
    firstTitle: String, @DrawableRes firstImageRes: Int,
    secondTitle: String, @DrawableRes secondImageRes: Int,
    thirdTitle: String, @DrawableRes thirdImageRes: Int,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        ItemCard(firstTitle, firstImageRes)
        ItemCard(secondTitle, secondImageRes)
        ItemCard(thirdTitle, thirdImageRes)
    }

}

@Composable
fun ItemCard(title: String, @DrawableRes imageRes: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Card(
            modifier = Modifier.size(80.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {

            Box(contentAlignment = Alignment.Center) {
                Image(
                    modifier = Modifier
                        .padding(4.dp)
                        .fillMaxSize(),
                    painter = painterResource(imageRes),
                    contentDescription = null,
                    contentScale = ContentScale.Fit
                )
            }
        }
        Spacer(Modifier.height(4.dp))
        Text(title, color = Color.Black, fontWeight = FontWeight.Bold)

    }
}

@Composable
fun Banner() {
    Card(
        modifier = Modifier
            .height(160.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MyRed
        ), shape = RoundedCornerShape(32.dp)
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight()
                    .weight(1f),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    "FLAT 50% OFF",
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )
                Text(
                    "Free Delivery + 10% CashBack",
                    fontSize = 11.sp,
                    color = MyGrey,
                    textAlign = TextAlign.Center
                )
                Spacer(Modifier.height(16.dp))
                Text(
                    "Coupon: FOOD50",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center
                )

            }
            Image(
                modifier = Modifier.weight(0.5f),
                painter = painterResource(R.drawable.bannerimg),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }

    }

}

