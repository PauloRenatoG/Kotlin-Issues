package com.example.data.mappers

import com.example.data.entity.ApiIssueDetail
import com.example.data.entity.ApiUser
import com.example.data.util.Mapper
import com.example.domain.entity.IssueDetail
import com.example.domain.entity.User
import javax.inject.Inject

class ApiIssueDetailToIssueDetailMapper @Inject constructor(
    private val mapperUser: Mapper<ApiUser, User>
) : Mapper<ApiIssueDetail, IssueDetail>() {
    override fun transform(t: ApiIssueDetail) = IssueDetail(
        user = t.apiUser?.let { mapperUser.transform(it) },
        body = t.body,
        createdAt = t.createdAt,
        htmlUrl = t.htmlUrl,
        id = t.id,
        number = t.number,
        title = t.title
    )
}