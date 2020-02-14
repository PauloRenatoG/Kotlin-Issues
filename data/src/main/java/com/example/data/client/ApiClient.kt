package com.example.data.client

import com.example.data.entity.ApiIssueDetail
import com.example.data.entity.ApiReponseIssues
import io.reactivex.Single
import javax.inject.Inject

class ApiClient @Inject constructor(
    private val apiService: ApiService
) {

    internal fun getListIssues(): Single<List<ApiReponseIssues>> {
        return apiService.getListIssues()
    }

    internal fun getIssueDetail(numberIssue: Long?): Single<ApiIssueDetail> {
        return apiService.getIssueDetail(numberIssue)
    }
}