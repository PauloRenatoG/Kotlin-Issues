package com.example.kotlinissues.presentation.view.listissues.paging

import androidx.paging.PageKeyedDataSource
import com.example.domain.entity.ResponseIssues
import com.example.domain.interactors.GetListIssues
import io.reactivex.disposables.CompositeDisposable

class ListIssuesDataSource constructor(
    private val getListIssues: GetListIssues,
    private val disposable: CompositeDisposable
) : PageKeyedDataSource<Long, ResponseIssues>() {
    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ResponseIssues>
    ) {
        disposable.add(
            getListIssues.execute(0, params.requestedLoadSize).subscribe({ apiResponseIssues ->
                callback.onResult(apiResponseIssues, null, 1)
            }, { throwable ->
                callback.onError(throwable)
            })
        )
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ResponseIssues>) {
        disposable.add(
            getListIssues.execute(
                params.key,
                params.requestedLoadSize
            ).subscribe({ responseIssues ->
                callback.onResult(responseIssues, params.key + 1)
            }, { throwable ->
                callback.onError(throwable)
            })
        )
    }

    override fun loadBefore(
        params: LoadParams<Long>,
        callback: LoadCallback<Long, ResponseIssues>
    ) {
        /* do nothing */
    }
}