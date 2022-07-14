package com.example.sesameassignment.model


import com.google.gson.annotations.SerializedName

data class UserInfo(
    @SerializedName("custAddress")
    val custAddress: String,
    @SerializedName("custName")
    val custName: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("phoneNo")
    val phoneNo: String
)