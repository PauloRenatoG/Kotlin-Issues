package com.example.domain.interactors

import com.example.domain.boundary.GetListIssuesRepository
import javax.inject.Inject

class GetListIssues @Inject constructor(
    private val repository: GetListIssuesRepository
) {
    fun execute(page: Long, perPage: Int) = repository.getListIssues(page, perPage)
}