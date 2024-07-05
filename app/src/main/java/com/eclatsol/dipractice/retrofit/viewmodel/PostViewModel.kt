package com.eclatsol.dipractice.retrofit.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.eclatsol.dipractice.retrofit.model.Post
import com.eclatsol.dipractice.retrofit.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import javax.inject.Inject

@HiltViewModel
class PostViewModel @Inject constructor(private val postRepository: PostRepository) : ViewModel() {

    val response: LiveData<List<Post>> = postRepository.getPost().catch { e ->
        Log.e("main", "${e.message}")
    }.asLiveData()
}