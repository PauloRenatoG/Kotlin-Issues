package com.example.domain.boundary

import com.example.domain.entity.ResponseIssues
import io.reactivex.Single

interface GetListIssuesRepository {
    fun getListIssues(): Single<List<ResponseIssues>>
}