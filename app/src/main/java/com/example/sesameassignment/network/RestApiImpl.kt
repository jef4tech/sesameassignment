package com.example.sesameassignment.network

object RestApiImpl {
    suspend fun getCustomers() = RetrofitClientFactory.restApis.getCustomers()
}