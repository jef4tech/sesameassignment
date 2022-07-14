package com.example.sesameassignment.model


import com.google.gson.annotations.SerializedName

data class Customer(
    @SerializedName("cust_list")
    val custList: List<Cust>,
    @SerializedName("status")
    val status: Boolean
)