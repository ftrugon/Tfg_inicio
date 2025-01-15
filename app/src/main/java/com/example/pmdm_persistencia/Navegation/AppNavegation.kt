package com.example.pmdm_persistencia.Navegation

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pmdm_persistencia.Screens.loading.LoadScreen
import com.example.pmdm_persistencia.Screens.login.Login
import com.example.pmdm_persistencia.Screens.profile.Profile
import com.example.pmdm_persistencia.Screens.register.Register
import com.example.pmdm_persistencia.ViewModel.LoginViewModel
import com.example.pmdm_persistencia.ViewModel.RegisterViewModel

@RequiresApi(Build.VERSION_CODES.TIRAMISU)
@Composable
fun AppNavigation(modifier: Modifier){

    val navControlador = rememberNavController()

    val loginViewModel = LoginViewModel()
    val registerViewModel = RegisterViewModel()

    NavHost(
        navController = navControlador,
        startDestination = AppScreen.LoadScreen.route)
    {
        composable(AppScreen.LoadScreen.route){
            LoadScreen(Modifier,navControlador)
        }

        composable(AppScreen.LoginScreen.route){
            Login(Modifier, navControlador, loginViewModel)
        }

        composable(AppScreen.RegisterScreen.route){
            Register(Modifier,navControlador, registerViewModel)
        }

        composable(AppScreen.ProfileScreen.route){
            Profile(navControlador)

        }
    }
}