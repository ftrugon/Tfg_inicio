package com.example.pmdm_persistencia.Screens.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.pmdm_persistencia.R


@Composable
fun UsernameField(label:String,username:String,onValueChange:(String) -> Unit,textFieldColorValues: TextFieldColors){

    OutlinedTextField(
        value = username,
        onValueChange = {onValueChange(it)},
        label = { Text(label) },
        singleLine = true,
        colors = textFieldColorValues,
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp, top = 8.dp),
    )

}

@Composable
fun PasswordField(password:String, onValueChange: (String) -> Unit, textFieldColorValues: TextFieldColors){

    var passwordVisible by remember { mutableStateOf(false) }

    val canSeeIcon = @Composable {
        IconButton(onClick = { passwordVisible = !passwordVisible }) {
            Image(
                painter = if (passwordVisible) painterResource(R.drawable.ficha_roja) else painterResource(
                    R.drawable.ficha_negra) ,
                contentDescription = "Show password",
                modifier = Modifier
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )
        }
    }

    OutlinedTextField(
        value = password,
        onValueChange = { onValueChange(it) },
        label = { Text("Password") },
        singleLine = true,
        colors = textFieldColorValues,
        modifier = Modifier.fillMaxWidth().padding(start = 16.dp, end = 16.dp),
        trailingIcon = canSeeIcon,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation()

    )
}