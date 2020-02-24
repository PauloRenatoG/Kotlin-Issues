package com.example.kotlinissues.presentation.view.listissues

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import androidx.paging.PagedList
import androidx.paging.RxPagedListBuilder
import com.example.domain.entity.ResponseIssues
import com.example.domain.interactors.GetListIssues
import com.example.kotlinissues.presentation.util.base.BaseViewModel
import com.example.kotlinissues.presentation.view.listissues.paging.ListIssuesDataSourceFactory
import javax.inject.Inject

class ListIssuesFragmentViewModel @Inject constructor(
    private val getListIssues: GetListIssues
) : BaseViewModel() {

    val listIssues: LiveData<PagedList<ResponseIssues>> get() = _listIssues
    private val _listIssues: MutableLiveData<PagedList<ResponseIssues>> = MutableLiveData()

    val error: LiveData<Throwable> get() = _error
    private val _error: MutableLiveData<Throwable> = MutableLiveData()

    private val pagedListConfig = PagedList.Config.Builder()
        .setEnablePlaceholders(false)
        .setPageSize(PAGE_SIZE)
        .setInitialLoadSizeHint(PAGE_SIZE)
        .setPrefetchDistance(10)
        .build()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun getList() {
        RxPagedListBuilder(
            ListIssuesDataSourceFactory(getListIssues, disposable),
            pagedListConfig
        )
            .buildObservable()
            .subscribe(::onSuccess, ::handleError)
            .let(disposable::add)
    }

    private fun onSuccess(listIssues: PagedList<ResponseIssues>) {
        _listIssues.value = listIssues
    }

    private fun handleError(throwable: Throwable) {
        _error.value = throwable
    }

    companion object {
        private const val PAGE_SIZE = 30
    }
}