package com.example.data.repository

import com.example.data.client.ApiClient
import com.example.data.entity.ApiReponseIssues
import com.example.data.util.Mapper
import com.example.domain.boundary.GetListIssuesRepository
import com.example.domain.entity.ResponseIssues
import io.reactivex.Single
import javax.inject.Inject

class DefaultGetListIssuesRepository @Inject constructor(
    private val apiClient: ApiClient,
    private val mapper: Mapper<ApiReponseIssues, ResponseIssues>
) : GetListIssuesRepository {
    override fun getListIssues(): Single<List<ResponseIssues>> {
        return apiClient.getListIssues().map(mapper::transformList)
    }
}