package com.example.data.mappers

import com.example.data.entity.ApiResponseIssues
import com.example.data.util.Mapper
import com.example.domain.entity.ResponseIssues
import javax.inject.Inject

class ApiResponseIssuesToResponseIssuesMapper @Inject constructor(

) : Mapper<ApiResponseIssues, ResponseIssues>() {
    override fun transform(t: ApiResponseIssues) = ResponseIssues(
        id = t.id,
        number = t.number,
        state = t.state,
        title = t.title
    )
}