package com.example.fooddeliveryapp.data

import retrofit2.http.GET

interface FoodApi {
   @GET
   suspend fun food():List<String>

}