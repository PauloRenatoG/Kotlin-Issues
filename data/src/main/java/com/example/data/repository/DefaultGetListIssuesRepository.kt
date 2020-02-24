package com.example.data.repository

import com.example.data.client.ApiClient
import com.example.data.entity.ApiResponseIssues
import com.example.data.util.Mapper
import com.example.domain.boundary.GetListIssuesRepository
import com.example.domain.entity.ResponseIssues
import io.reactivex.Observable
import javax.inject.Inject

class DefaultGetListIssuesRepository @Inject constructor(
    private val apiClient: ApiClient,
    private val mapper: Mapper<ApiResponseIssues, ResponseIssues>
) : GetListIssuesRepository {

    override fun getListIssues(page: Long, perPage: Int): Observable<List<ResponseIssues>> {
        return apiClient.getListIssues(page, perPage).map(mapper::transformList)
    }
}