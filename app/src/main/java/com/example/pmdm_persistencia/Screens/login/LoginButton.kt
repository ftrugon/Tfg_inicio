package com.example.pmdm_persistencia.Screens.login

import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun LoginButton(enabled:Boolean,onClic:()->Unit){


    val textColor = if (enabled) Color.Black else Color.White

    Button(
        onClick = {onClic()},
        colors = ButtonDefaults.buttonColors(
            containerColor = Color(0xFFCDCDCD),
            disabledContainerColor = Color.Transparent
        ),
        enabled = enabled
    ){
        Text("Log In!", color = textColor)
    }
}
