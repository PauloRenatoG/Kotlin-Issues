package com.example.data.entity


import com.google.gson.annotations.SerializedName
import java.util.*

data class ApiIssueDetail(
    @SerializedName("user")
    val apiUser: ApiUser? = null,
    @SerializedName("body")
    val body: String? = null,
    @SerializedName("created_at")
    val createdAt: Date? = null,
    @SerializedName("html_url")
    val htmlUrl: String? = null,
    @SerializedName("id")
    val id: Long? = null,
    @SerializedName("number")
    val number: Long? = null,
    @SerializedName("title")
    val title: String? = null
)