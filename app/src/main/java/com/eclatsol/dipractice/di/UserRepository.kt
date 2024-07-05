package com.eclatsol.dipractice.di

import android.util.Log
import javax.inject.Inject

class UserRepository @Inject constructor(){ //This is Constructor Injection
    fun saveUser(email : String,password : String){
        Log.e("main", "saveUser:  $email,$password")
    }
}