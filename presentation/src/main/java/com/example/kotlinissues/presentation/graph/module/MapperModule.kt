package com.example.kotlinissues.presentation.graph.module

import com.example.data.entity.ApiIssueDetail
import com.example.data.entity.ApiReponseIssues
import com.example.data.entity.ApiUser
import com.example.data.mappers.ApiIssueDetailToIssueDetailMapper
import com.example.data.mappers.ApiResponseIssuesToResponseIssuesMapper
import com.example.data.mappers.ApiUserToUserMapper
import com.example.data.util.Mapper
import com.example.domain.entity.IssueDetail
import com.example.domain.entity.ResponseIssues
import com.example.domain.entity.User
import dagger.Binds
import dagger.Module

@Module
interface MapperModule {

    @Binds
    fun bindsApiResponseIssuesToResponseIssuesMapper(mapper: ApiResponseIssuesToResponseIssuesMapper): Mapper<ApiReponseIssues, ResponseIssues>

    @Binds
    fun bindsApiIssueDetailToIssueDetailMapper(mapper: ApiIssueDetailToIssueDetailMapper): Mapper<ApiIssueDetail, IssueDetail>

    @Binds
    fun bindsApiUserToUserMapper(mapper: ApiUserToUserMapper): Mapper<ApiUser, User>
}