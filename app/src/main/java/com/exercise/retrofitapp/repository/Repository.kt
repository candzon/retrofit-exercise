package com.exercise.retrofitapp.repository

import com.exercise.retrofitapp.api.RetrofitInstance
import com.exercise.retrofitapp.model.Post
import retrofit2.Response

class Repository {
    suspend fun getPost(): Response<Post> {
        return RetrofitInstance.api.getPost()
    }
}