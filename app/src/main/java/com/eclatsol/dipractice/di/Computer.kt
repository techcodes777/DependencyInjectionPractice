package com.eclatsol.dipractice.di

import android.util.Log
import javax.inject.Inject

class Computer @Inject constructor(){

    fun getComputer(){
        Log.e("main", "getComputer: ")
    }

    //val computer = Computer()
}