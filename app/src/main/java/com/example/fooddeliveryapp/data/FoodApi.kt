package com.example.fooddeliveryapp.data

import com.example.fooddeliveryapp.data.models.AuthResponse
import com.example.fooddeliveryapp.data.models.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.POST

interface FoodApi {
   @POST("auth/signup")
   suspend fun signUp(@Body signUpRequest: SignUpRequest):AuthResponse

   @POST("auth/signup")
   suspend fun logIn(@Body signUpRequest: SignUpRequest):AuthResponse

}