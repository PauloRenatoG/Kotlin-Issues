package com.example.data.entity


import com.google.gson.annotations.SerializedName

data class ApiResponseIssues(
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("number")
    val number: Long? = null,
    @SerializedName("state")
    val state: String? = null,
    @SerializedName("title")
    val title: String? = null
)