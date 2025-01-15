package com.example.pmdm_persistencia

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color


object Constantes{

    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun textFieldColorValues() = TextFieldDefaults.outlinedTextFieldColors(
        focusedTextColor = Color.Black,
        unfocusedTextColor = Color.Black,
        focusedBorderColor = Color.Black,
        unfocusedBorderColor = Color.Black,
        cursorColor = Color.Black,
        focusedLabelColor = Color.Black,
        unfocusedLabelColor = Color.Black
    )
}

