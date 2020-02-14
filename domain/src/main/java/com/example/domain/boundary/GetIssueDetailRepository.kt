package com.example.domain.boundary

import com.example.domain.entity.IssueDetail
import io.reactivex.Single

interface GetIssueDetailRepository {
    fun getIssueDetail(numberIssue: Long?): Single<IssueDetail>
}