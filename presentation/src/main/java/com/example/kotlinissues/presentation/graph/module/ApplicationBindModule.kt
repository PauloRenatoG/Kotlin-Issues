package com.example.kotlinissues.presentation.graph.module

import androidx.lifecycle.ViewModelProvider
import com.example.data.repository.DefaultGetIssueDetail
import com.example.data.repository.DefaultGetListIssuesRepository
import com.example.domain.boundary.GetIssueDetailRepository
import com.example.domain.boundary.GetListIssuesRepository
import com.example.kotlinissues.presentation.util.base.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ApplicationBindModule {

    @Binds
    abstract fun bindsGetListIssuesRepository(repository: DefaultGetListIssuesRepository): GetListIssuesRepository

    @Binds
    abstract fun bindsGetIssueDetail(repository: DefaultGetIssueDetail): GetIssueDetailRepository

    @Binds
    abstract fun bindsViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}