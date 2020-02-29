package com.example.kotlinissues.presentation.view.listissues.paging

import androidx.paging.DataSource
import com.example.domain.entity.ResponseIssues
import com.example.domain.interactors.GetListIssues
import io.reactivex.disposables.CompositeDisposable

class ListIssuesDataSourceFactory constructor(
    private val getListIssues: GetListIssues,
    private val disposable: CompositeDisposable
) : DataSource.Factory<Long, ResponseIssues>() {

    override fun create(): DataSource<Long, ResponseIssues> {
        return ListIssuesDataSource(getListIssues, disposable)
    }
}