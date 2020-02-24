package com.example.domain.boundary

import com.example.domain.entity.ResponseIssues
import io.reactivex.Observable

interface GetListIssuesRepository {
    fun getListIssues(page: Long, perPage: Int): Observable<List<ResponseIssues>>
}