package com.example.sesameassignment.network


import com.example.sesameassignment.model.Customer
import com.example.sesameassignment.model.SampleResponse
import com.example.sesameassignment.model.UserInfo
import retrofit2.Response
import retrofit2.http.*

interface RestApis {

    @GET("customer/get-details/")
    suspend fun getCustomers(): Response<Customer>

    @Headers("Content-Type: application/json")
    @POST("users")
    fun addUser(@Body userData: UserInfo): Response<SampleResponse>
}