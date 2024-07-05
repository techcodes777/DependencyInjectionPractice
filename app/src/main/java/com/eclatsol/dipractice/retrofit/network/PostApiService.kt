package com.eclatsol.dipractice.retrofit.network

import com.eclatsol.dipractice.retrofit.model.Post
import retrofit2.http.GET

interface PostApiService {

    @GET("posts")
    suspend fun getIdApi() : List<Post>

    //Interface nu implementation pan devu padshe

}