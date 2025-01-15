package com.example.pmdm_persistencia.Screens.login

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun ShowError(text:String){
    Column(
        modifier = Modifier
            .padding(50.dp)
            //.background(Color.)
            .border(BorderStroke(2.dp, Color.Red))
            .clip(RoundedCornerShape(16.dp))
    ) {
        Text(text,
            color = Color.Red,
            modifier = Modifier.padding(20.dp))
    }
}


