package com.example.medbot

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/signup") // Replace with your actual endpoint
    fun signUp(@Body userData: UserData): Call<ApiResponse> // Replace with your data classes
    
}