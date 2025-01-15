package com.example.pmdm_persistencia.Navegation

sealed class AppScreen(val route:String) {

    object LoadScreen:AppScreen("LoadScreen")
    object LoginScreen:AppScreen("LoginScreen")
    object RegisterScreen:AppScreen("RegisterScreen")
    object ProfileScreen:AppScreen("ProfileScreen")
}