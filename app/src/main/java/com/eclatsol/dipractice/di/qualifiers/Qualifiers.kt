package com.eclatsol.dipractice.di.qualifiers

import android.content.Context
import android.util.Log
import android.widget.Toast
import com.eclatsol.dipractice.MainActivity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ActivityContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject
import javax.inject.Qualifier

class Testing @Inject constructor(
    @FName private val fNames: String, @LName private val lNames: String,
    @ActivityContext
    private val context: Context
) {

    fun getTesting() {
        Log.e("main", "$fNames $lNames")
        Toast.makeText(context, "Hello World", Toast.LENGTH_SHORT).show()
    }
}

@Module
@InstallIn(SingletonComponent::class)
object TestModule {

    @Provides
    @FName
    fun providesFName() = MainActivity.FName //Runtime per value assign kari shako
    //fun providesFName() = "Jemis" //CompileTime per value assign thay

    @Provides
    @LName
    fun providesLName() = MainActivity.LName //Runtime per value assign kari shako
    //fun providesLName() = "Virani" //CompileTime Per Value Assign thay che

}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class FName

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class LName

class Qualifiers {
}