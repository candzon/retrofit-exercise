package com.exercise.retrofitapp.model

import retrofit2.http.Body

data class Post(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)
