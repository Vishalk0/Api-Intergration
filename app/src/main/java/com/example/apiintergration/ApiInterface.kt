package com.example.apiintergration

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    //that is basically used to define the
    @GET("products")
    fun getProductData():Call<MobileData>
}