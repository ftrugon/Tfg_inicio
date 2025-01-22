package com.example.pmdm_persistencia.TestProjecto

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertTextEquals
import androidx.compose.ui.test.click
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.test.performTouchInput
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.pmdm_persistencia.Constantes
import com.example.pmdm_persistencia.Navegation.AppScreen
import com.example.pmdm_persistencia.Screens.loading.LoadScreen
import com.example.pmdm_persistencia.Screens.login.Login
import com.example.pmdm_persistencia.Screens.login.LoginButton
import com.example.pmdm_persistencia.Screens.login.NotRegisteredYetButton
import com.example.pmdm_persistencia.Screens.login.PasswordField
import com.example.pmdm_persistencia.Screens.login.UsernameField
import com.example.pmdm_persistencia.Screens.profile.Profile
import com.example.pmdm_persistencia.Screens.register.Register
import com.example.pmdm_persistencia.ViewModel.LoginViewModel
import com.example.pmdm_persistencia.ViewModel.RegisterViewModel
import org.junit.Rule
import org.junit.Test


class TestsApp {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun existLoad(){
        composeTestRule.setContent {
            LoadScreen(Modifier, NavController(LocalContext.current))
        }

        composeTestRule.onNodeWithTag("TextWelcome")
        composeTestRule.onNodeWithText("Welcome back!")
        composeTestRule.onNodeWithContentDescription("foto de app")
    }


    @Test
    fun changeToLogIn(){

        composeTestRule.setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "LoadScreen") {
                composable(AppScreen.LoadScreen.route) { LoadScreen(Modifier, navController) }
                composable(AppScreen.LoginScreen.route) { Login(Modifier,navController,
                    LoginViewModel()
                ) }
            }
        }

        composeTestRule.onNodeWithTag("ColumnClic").performTouchInput {
            click()
        }
    }


    @Test
    fun UserFieldExist(){

        composeTestRule.setContent {
            UsernameField("","",{},Constantes.textFieldColorValues())
        }

        composeTestRule.onNodeWithTag("textField")

    }

    @Test
    fun PasswordFieldExist(){

        composeTestRule.setContent {
            PasswordField("",{},Constantes.textFieldColorValues())
        }

        composeTestRule.onNodeWithTag("textField")

    }

    @Test
    fun UserFieldCanWrite() {

        composeTestRule.setContent {
            var username by remember { mutableStateOf("") }

            UsernameField(
                label = "Usuario",
                username = username,
                onValueChange = { username = it },
                textFieldColorValues = Constantes.textFieldColorValues()
            )
        }

        composeTestRule.onNodeWithTag("textField").performTextInput("hola")


    }

    @Test
    fun PassFieldCanWrite() {

        composeTestRule.setContent {
            var pass by remember { mutableStateOf("") }

            PasswordField(
                password = pass,
                onValueChange = { pass = it },
                textFieldColorValues = Constantes.textFieldColorValues()
            )
        }

        composeTestRule.onNodeWithTag("textField").performTextInput("hola")

    }


    @Test
    fun testLoginButtonClick() {
        var clicked = false

        composeTestRule.setContent {
            LoginButton(
                enabled = true,
                onClic = { clicked = true }
            )
        }
        composeTestRule.onNodeWithText("Log In!").performClick()
    }

    @Test
    fun testRegisterButtonClick() {

        composeTestRule.setContent {
            NotRegisteredYetButton(Modifier) { }
        }
        composeTestRule.onNodeWithText("Not registered yet?").performClick()
    }



    @Test
    fun existProfileButton(){
        composeTestRule.setContent {
            Profile(navController = NavController(LocalContext.current))
        }

        composeTestRule.onNodeWithText("Log out")

    }

    @Test
    fun worksProfileButton(){
        composeTestRule.setContent {
            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = AppScreen.ProfileScreen.route) {
                composable(AppScreen.ProfileScreen.route) { Profile(navController) }
                composable(AppScreen.LoadScreen.route) { LoadScreen(Modifier, navController) }
            }
        }

        composeTestRule.onNodeWithText("Log out").performClick()
    }

}