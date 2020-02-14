package com.example.data.client

import com.example.data.entity.ApiIssueDetail
import com.example.data.entity.ApiReponseIssues
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    @GET("issues")
    fun getListIssues(): Single<List<ApiReponseIssues>>

    @GET("issues/{number}")
    fun getIssueDetail(@Path("number") numberIssue: Long?): Single<ApiIssueDetail>
}