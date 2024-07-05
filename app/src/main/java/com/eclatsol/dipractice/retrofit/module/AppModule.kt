package com.eclatsol.dipractice.retrofit.module

import com.eclatsol.dipractice.retrofit.network.PostApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    //Retrofit ni dependency provide karavish
    //PosApiService Interface ni dependnecy provides karavish
    @Provides
    @Singleton
    fun getRetrofitInstance() : Retrofit = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(GsonConverterFactory.create()).build()

    @Provides
    fun getPostApiService(retrofit: Retrofit) : PostApiService = retrofit.create(PostApiService::class.java)
}