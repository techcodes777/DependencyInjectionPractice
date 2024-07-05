package com.eclatsol.dipractice.retrofit.network

import com.eclatsol.dipractice.retrofit.model.Post
import javax.inject.Inject

class PostServiceImp @Inject constructor(private val postApiService: PostApiService) {
    suspend fun getPostData() : List<Post> = postApiService.getIdApi()
}