package com.example.pmdm_persistencia.ViewModel

import androidx.compose.runtime.mutableStateMapOf
import androidx.compose.runtime.mutableStateOf
import com.example.pmdm_persistencia.db

class RegisterViewModel() {

    private var _canRegister = mutableStateOf(false)
    var canRegister = _canRegister

    private var _user = mutableStateOf("")
    val user = _user

    private val _pass = mutableStateOf("")
    val pass = _pass


    fun changeUser(newValue: String){
        _user.value = newValue
    }

    fun changePass(newValue: String){
        _pass.value = newValue
    }

    fun resetUserAndPass(){
        _pass.value = ""
        _user.value = ""
        _canRegister.value = false
    }

    fun checkRegister(){
        _canRegister.value = _user.value.isNotEmpty() && validatePass()
    }

    fun validateUser():Boolean{
        return !existUser() && validatePass()
    }

    private fun existUser():Boolean{
        return db.imaginaryDb.contains(user.value)
    }

    fun validatePass():Boolean{
        return _pass.value.length >= 6
    }

    fun clicRegister(){
        db.saveUser(user.value,pass.value)
    }

}