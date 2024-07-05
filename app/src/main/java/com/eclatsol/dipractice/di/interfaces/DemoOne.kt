package com.eclatsol.dipractice.di.interfaces

import android.util.Log
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

interface DemoOne{
    fun demoOne()
}

class DemoOneImplementation @Inject constructor(): DemoOne{
    override fun demoOne() {
        Log.e("main", "demoOne is Running")
    }
}

class MainOne @Inject constructor(private val demoOne: DemoOne){
    fun demoOne(){
        demoOne.demoOne()
    }
}

@Module
@InstallIn(SingletonComponent::class)
abstract class AppModule1{

    @Binds
    @Singleton
    abstract fun providesDemoOne(demoOneImplementation: DemoOneImplementation) : DemoOne
}