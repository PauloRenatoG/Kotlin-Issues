package com.example.data.entity


import com.google.gson.annotations.SerializedName

data class ApiUser(
    @SerializedName("avatar_url")
    val avatarUrl: String? = null,
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("login")
    val login: String? = null
)