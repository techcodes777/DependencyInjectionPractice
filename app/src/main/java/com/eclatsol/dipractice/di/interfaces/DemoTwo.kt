package com.eclatsol.dipractice.di.interfaces

import android.util.Log
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Singleton

interface DemoTwo {
    fun demoTwo()
}

class DemoTwoImplementation @Inject constructor(): DemoTwo {
    override fun demoTwo() {
        Log.e("main", "demoTwo is Running")
    }
}

class MainTwo @Inject constructor(private val demoTwo: DemoTwo) {
    fun demoTwo() {
        demoTwo.demoTwo()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object AppModule2 {

    @Provides
    @Singleton
    fun providesDemoTwo(): DemoTwo = DemoTwoImplementation()

}