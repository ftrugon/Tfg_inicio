package com.example.pmdm_persistencia.Screens.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.sp
import com.example.pmdm_persistencia.Constantes
import com.example.pmdm_persistencia.Navegation.AppScreen
import com.example.pmdm_persistencia.ViewModel.LoginViewModel
import com.example.pmdm_persistencia.datastore.StoreUserEmail
import com.example.pmdm_persistencia.datastore.StoreUserPass
import com.example.pmdm_persistencia.datastore.StoreUserRemember
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
//@Preview
@Composable
fun Login(modifier: Modifier,navController: NavController,viewModel: LoginViewModel){
//fun Login(){

    val username by viewModel.user
    val password by viewModel.pass
    val canLogIn by viewModel.canLogIn

    var rememberMe by remember { mutableStateOf(false) }

    val scope = rememberCoroutineScope()

    val emailDataStore = StoreUserEmail(LocalContext.current)
    val passDataStore = StoreUserPass(LocalContext.current)
    val rememberMeDataStore = StoreUserRemember(LocalContext.current)


    var showError by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text("Log in", color = Color.Black)

        if (showError){
            ShowError("Any of the fields are incorrect or the user does not exist in the database")
        }

        Column(
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
                .clip(RoundedCornerShape(16.dp))
                .background(Color(0xFFCDCDCD)),
        ) {

            UsernameField("Username",username,{
                viewModel.changeUser(it)
                viewModel.checkLogin()
            },Constantes.textFieldColorValues())

            PasswordField(password,{
                viewModel.changePass(it)
                viewModel.checkLogin()
            }, Constantes.textFieldColorValues())

            //Todo --> Campo de remember me

            RememberMe(rememberMe) { rememberMe = it }
        }

        LoginButton(canLogIn){
            if (viewModel.existUser()){
                if (viewModel.correctPassword()){

                    scope.launch {
                        emailDataStore.saveEmail(username)
                        passDataStore.savePass(password)

                        if (rememberMe) rememberMeDataStore.saveRemember("s")
                        else rememberMeDataStore.saveRemember("n")

                    }
                    navController.navigate(AppScreen.ProfileScreen.route)
                }else{
                    showError = true
                    viewModel.resetUserAndPass()
                }
            }else{
                showError = true
                viewModel.resetUserAndPass()
            }
        }

        /*
        //Campo para skipear el login
        Button(
            onClick = {
                //val isLogged = false
                //navController.navigate(AppScreen.MainMenu.route + "/$isLogged")
                      },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFCDCDCD),
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier.align(Alignment.End).padding(10.dp)
        ){
            Text("Skip")
        }*/

        // Campo de no estas registrado?
        Button(
            onClick = {
                //val isLogged = false
                navController.navigate(AppScreen.RegisterScreen.route)
            },
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFCDCDCD),
                disabledContainerColor = Color.Transparent
            ),
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ){
            Text("Not registered yet?")
        }

        //Para probar el datastore
        Text("${emailDataStore.getEmail.collectAsState("").value},${passDataStore.getPass.collectAsState("").value},${rememberMeDataStore.getRemember.collectAsState("").value} ", color = Color.Black)
    }
}




