package com.example.data.client

import com.example.data.entity.ApiIssueDetail
import com.example.data.entity.ApiResponseIssues
import io.reactivex.Observable
import io.reactivex.Single
import javax.inject.Inject

class ApiClient @Inject constructor(
    private val apiService: ApiService
) {

    internal fun getListIssues(page: Long, perPage: Int): Observable<List<ApiResponseIssues>> {
        return apiService.getListIssues(page, perPage)
    }

    internal fun getIssueDetail(numberIssue: Long?): Single<ApiIssueDetail> {
        return apiService.getIssueDetail(numberIssue)
    }
}