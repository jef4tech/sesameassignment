package com.example.sesameassignment.model


import com.google.gson.annotations.SerializedName

data class SampleResponse(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Boolean
)