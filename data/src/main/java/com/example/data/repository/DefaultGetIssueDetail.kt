package com.example.data.repository

import com.example.data.client.ApiClient
import com.example.data.entity.ApiIssueDetail
import com.example.data.util.Mapper
import com.example.domain.boundary.GetIssueDetailRepository
import com.example.domain.entity.IssueDetail
import io.reactivex.Single
import javax.inject.Inject

class DefaultGetIssueDetail @Inject constructor(
    private val apiClient: ApiClient,
    private val mapper: Mapper<ApiIssueDetail, IssueDetail>
) : GetIssueDetailRepository {
    override fun getIssueDetail(numberIssue: Long?): Single<IssueDetail> {
        return apiClient.getIssueDetail(numberIssue).map(mapper::transform)
    }
}