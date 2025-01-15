package com.example.pmdm_persistencia.Screens.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.pmdm_persistencia.Navegation.AppScreen
import com.example.pmdm_persistencia.R
import com.example.pmdm_persistencia.datastore.StoreUserEmail
import com.example.pmdm_persistencia.datastore.StoreUserPass
import com.example.pmdm_persistencia.datastore.StoreUserRemember
import kotlinx.coroutines.launch


@Composable
// TODO: hacer un viewmodel de profile screen
fun Profile(navController: NavController) {

    val emailDataStore = StoreUserEmail(LocalContext.current)
    val passDataStore = StoreUserPass(LocalContext.current)
    val rememberMeDataStore = StoreUserRemember(LocalContext.current)

    val scope = rememberCoroutineScope()


    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.padding(16.dp)
            .fillMaxSize()
            .background(Color(0xFFEEEEEE)),

    ) {
        // Imagen de perfil
        Image(
            painter = painterResource(id = R.drawable.ficha_roja),
            contentDescription = "Imagen de perfil",
            modifier = Modifier
                .size(120.dp)
                .clip(CircleShape)
                .background(Color.Gray),
            contentScale = ContentScale.Crop
        )
        Spacer(modifier = Modifier.height(16.dp))

        // Nombre de usuario
        Text(
            text = emailDataStore.getEmail.collectAsState("").value!! ,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black
        )
        Spacer(modifier = Modifier.height(8.dp))

        // contraseña
        Text(
            text = passDataStore.getPass.collectAsState("").value!!,
            fontSize = 16.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(24.dp))

        
        Button(
            onClick = {
                scope.launch {
                    rememberMeDataStore.saveRemember("n")
                }
                navController.navigate(AppScreen.LoadScreen.route)
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
            shape = RoundedCornerShape(16.dp)
        ) {
            Text(
                text = "Log out",
                fontSize = 16.sp,
                color = Color.White
            )
        }
    }
}

