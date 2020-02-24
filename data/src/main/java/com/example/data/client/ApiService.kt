package com.example.data.client

import com.example.data.entity.ApiIssueDetail
import com.example.data.entity.ApiResponseIssues
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("issues")
    fun getListIssues(@Query("page") page: Long, @Query("per_page") perPage: Int): Observable<List<ApiResponseIssues>>

    @GET("issues/{number}")
    fun getIssueDetail(@Path("number") numberIssue: Long?): Single<ApiIssueDetail>
}