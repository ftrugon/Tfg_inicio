package com.example.pmdm_persistencia

object db {

    val imaginaryDb = mutableMapOf("fran" to "123456","pepe" to "123456", "chinoMillonario" to "chino1234")

    fun saveUser(userName:String,password:String){
        imaginaryDb[userName] = password
    }


    //TODO
    fun delUser(){

    }

}