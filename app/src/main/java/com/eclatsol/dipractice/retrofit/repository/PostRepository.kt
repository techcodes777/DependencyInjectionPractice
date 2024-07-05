package com.eclatsol.dipractice.retrofit.repository

import com.eclatsol.dipractice.retrofit.model.Post
import com.eclatsol.dipractice.retrofit.network.PostServiceImp
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class PostRepository @Inject constructor(private val postServiceImp: PostServiceImp){

    //Function nu name //Flow Return karshe ,Emit name nu function use karishu //Asynchronous task ne bg ma perfrom karavishu tena mate flowOn no use thay che
    fun getPost() : Flow<List<Post>> = flow {
        val response = postServiceImp.getPostData()
        emit(response)
    }.flowOn(Dispatchers.IO)

}