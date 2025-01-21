package com.example.fooddeliveryapp.data

import com.example.fooddeliveryapp.data.models.AuthResponse
import com.example.fooddeliveryapp.data.models.LogInRequest
import com.example.fooddeliveryapp.data.models.SignUpRequest
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface FoodApi {
    @POST("auth/signup")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): AuthResponse

    @POST("auth/login")
    suspend fun logIn(
        @Body logInRequest: LogInRequest,
        @Header("Authorization") authHeader: String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJrdG9yLmlvIiwiYXVkIjoia3Rvci1hdWRpZW5jZSIsInVzZXJJZCI6ImZiOWZjY2QyLTc1Y2ItNDA4NS04MTFiLTJjNzJkNTIxODllOCIsImV4cCI6MTczNzMyNzUwMH0.NqZ2QTnAA70ULAHZ-aA4_Qpg15w3GebC8S6fxHrm1bA"
    ): AuthResponse

}