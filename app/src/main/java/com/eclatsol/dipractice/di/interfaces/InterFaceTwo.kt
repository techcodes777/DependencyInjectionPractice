package com.eclatsol.dipractice.di.interfaces

import android.util.Log


interface InterFaceTwo{
    fun dataTwo()
}

class DataTwoImplementation : InterFaceTwo{
    override fun dataTwo() {
        Log.e("main", "dataTwo: ")
    }
}

