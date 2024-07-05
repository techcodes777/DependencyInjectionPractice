package com.eclatsol.dipractice.di.interfaces

import android.util.Log
import javax.inject.Inject

interface InterFaceManually {
    fun addData()
}

class MainClass @Inject constructor() : InterFaceManually {
    override fun addData() {
        Log.e("main", "addData: ")
    }
}

class Data @Inject constructor(private val interFaceManually: InterFaceManually) {
    fun addData() {
        interFaceManually.addData()
    }
}

object AppModuleManually {

    val data = Data(MainClass())
}