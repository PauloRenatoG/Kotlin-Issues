package com.example.domain.interactors

import com.example.domain.boundary.GetIssueDetailRepository
import javax.inject.Inject

class GetIssueDetail @Inject constructor(
    private val repository: GetIssueDetailRepository
) {

    fun execute(numberIssue: Long?) = repository.getIssueDetail(numberIssue)
}