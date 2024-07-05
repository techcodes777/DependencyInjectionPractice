package com.eclatsol.dipractice.di

import android.util.Log

class Car constructor(private val engine: Engine, private val wheel: Wheel) {

    fun getCar() {
        engine.getEngine()
        wheel.getWheel()
        Log.e("main", "getCar: Car is running..")
    }
}

class Engine {
    fun getEngine() {
        Log.e("main", "Engine is started")
    }
}

class Wheel {
    fun getWheel() {
        Log.e("main", "Wheel is started")
    }
}

