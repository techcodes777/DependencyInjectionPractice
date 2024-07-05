package com.eclatsol.dipractice.retrofit.container

import android.app.Application
import com.eclatsol.dipractice.di.Car
import com.eclatsol.dipractice.di.Engine
import com.eclatsol.dipractice.di.UserRepository
import com.eclatsol.dipractice.di.Wheel
import com.eclatsol.dipractice.di.interfaces.AppModule
import com.eclatsol.dipractice.di.interfaces.AppModuleManually
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BaseApp : Application() { //External Source

    //External Source //Manually Dependency Injection
    val car = Car(Engine(), Wheel())

    //val computer = Computer()
    // java.lang.StackOverflowError: stack size 8MB Problem aa error tyare ave che jyare be var object create thata hoi framework

    //Interface ma baseapp per depend nathi revu padtu  //Tena mate module create karvi shavi then moduel depend karvi shavi baseapp ma
    val main = AppModule.main

    val data = AppModuleManually.data

    @Inject //This is Filed Injection //Filed Define kari che
    lateinit var userRepository: UserRepository  //Class ma pan use kari shako
    override fun onCreate() {
        super.onCreate()
        userRepository.saveUser("hello@gmail.com","123456")
    }
}