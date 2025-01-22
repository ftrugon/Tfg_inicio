package com.example.pmdm_persistencia.Screens.loading

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.navigation.NavController
import com.example.pmdm_persistencia.Navegation.AppScreen
import com.example.pmdm_persistencia.R
import com.example.pmdm_persistencia.datastore.StoreUserRemember

@Composable
fun LoadScreen(modifier: Modifier, navController: NavController){

    val rememberMeDataStore = StoreUserRemember(LocalContext.current)
    val text by remember { mutableStateOf("Welcome back!")}

    var hasCharged by remember { mutableStateOf(false) }


    if (rememberMeDataStore.getRemember.collectAsState("").value == "s" && !hasCharged){
        navController.navigate(AppScreen.ProfileScreen.route)
        hasCharged = true
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
            .clickable {
                navController.navigate(AppScreen.LoginScreen.route)
                       }
            .testTag("ColumnClic")
        ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(R.drawable.ficha_negra),
            contentDescription = "foto de app",
            modifier = Modifier
                .padding(start = 10.dp, end = 10.dp)
                .size(300.dp)
                .clip(CircleShape),
            contentScale = ContentScale.Crop,
        )

        Text(
            modifier = Modifier.padding(10.dp).testTag("TextWelcome"),
            text =text,
            fontWeight = FontWeight(1000),
            fontSize = 5.em,
            color = Color.Black)
    }

}