package com.example.pmdm_persistencia.Screens.login

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.example.pmdm_persistencia.Navegation.AppScreen

@Composable
fun NotRegisteredYetButton(modifier: Modifier,onClic:() -> Unit){
    Button(
        onClick = {
            //val isLogged = false
            onClic()
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFCDCDCD),
            disabledContainerColor = Color.Transparent
        ),
        modifier = modifier
    ){
        Text("Not registered yet?")
    }

}