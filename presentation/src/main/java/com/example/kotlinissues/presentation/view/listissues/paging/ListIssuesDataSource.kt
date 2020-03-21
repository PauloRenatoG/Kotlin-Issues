package com.example.kotlinissues.presentation.view.listissues.paging

import androidx.paging.PageKeyedDataSource
import com.example.domain.entity.ResponseIssues
import com.example.domain.interactors.GetListIssues
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ListIssuesDataSource constructor(
    private val getListIssues: GetListIssues,
    private val disposable: CompositeDisposable,
    private val callbackError: (Throwable) -> Unit
) : PageKeyedDataSource<Long, ResponseIssues>() {
    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ResponseIssues>
    ) {
        disposable.add(
            getListIssues.execute(0, params.requestedLoadSize)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ apiResponseIssues ->
                    callback.onResult(apiResponseIssues, null, 1)
                }, { throwable ->
                    callbackError.invoke(throwable)
                })
        )
    }

    override fun loadAfter(params: LoadParams<Long>, callback: LoadCallback<Long, ResponseIssues>) {
        disposable.add(
            getListIssues.execute(
                params.key,
                params.requestedLoadSize
            )
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ responseIssues ->
                    callback.onResult(responseIssues, params.key + 1)
                }, { throwable ->
                    callbackError.invoke(throwable)
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