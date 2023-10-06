package com.munmundev.belajargit.data.database.api

import com.munmundev.belajargit.data.model.ApiModel
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/get.php")
    fun getData():Call<ArrayList<ApiModel>>

    @GET("api/get.php")
    fun getData(@Query("get_user") get_user:String,
                @Query("user_id") user_id:String,
                @Query("pass_id") pass_id:String
    ):Call<ArrayList<ApiModel>>
}