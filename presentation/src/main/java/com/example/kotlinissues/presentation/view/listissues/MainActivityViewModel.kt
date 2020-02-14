package com.example.kotlinissues.presentation.view.listissues

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.ResponseIssues
import com.example.domain.interactors.GetListIssues
import com.example.kotlinissues.presentation.util.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivityViewModel @Inject constructor(
    private val getListIssues: GetListIssues
) : BaseViewModel() {

    val listIssues: LiveData<List<ResponseIssues>> get() = _listIssues
    val error: LiveData<Throwable> get() = _error
    private val _listIssues: MutableLiveData<List<ResponseIssues>> = MutableLiveData()
    private val _error: MutableLiveData<Throwable> = MutableLiveData()

    private val disposable = CompositeDisposable()

    internal fun getList() {
        disposable.add(
            getListIssues
                .execute()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onSuccess, ::handleError)
        )
    }

    internal fun clearDisposable() {
        disposable.clear()
    }

    private fun onSuccess(listIssues: List<ResponseIssues>) {
        _listIssues.value = listIssues
    }

    private fun handleError(throwable: Throwable) {
        _error.value = throwable
    }
}