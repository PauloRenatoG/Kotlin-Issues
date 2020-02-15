package com.example.kotlinissues.presentation.view.listissues

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.example.domain.entity.ResponseIssues
import com.example.domain.interactors.GetListIssues
import com.example.kotlinissues.presentation.util.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListIssuesFragmentViewModel @Inject constructor(
    private val getListIssues: GetListIssues
) : BaseViewModel() {

    val listIssues: LiveData<List<ResponseIssues>> get() = _listIssues
    private val _listIssues: MutableLiveData<List<ResponseIssues>> = MutableLiveData()

    val error: LiveData<Throwable> get() = _error
    private val _error: MutableLiveData<Throwable> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun getList() {
        getListIssues
            .execute()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::handleError)
            .let(disposable::add)
    }

    private fun onSuccess(listIssues: List<ResponseIssues>) {
        _listIssues.value = listIssues
    }

    private fun handleError(throwable: Throwable) {
        _error.value = throwable
    }
}