package com.example.kotlinissues.presentation.view.issuedetail

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.OnLifecycleEvent
import com.example.domain.entity.IssueDetail
import com.example.domain.interactors.GetIssueDetail
import com.example.kotlinissues.presentation.util.NUMBER_ISSUE
import com.example.kotlinissues.presentation.util.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class IssueDetailViewModel @Inject constructor(
    private val getIssueDetail: GetIssueDetail,
    @Named(NUMBER_ISSUE) private val numberIssue: Long?
) : BaseViewModel() {

    val issueDetail: LiveData<IssueDetail> get() = _issueDetail
    private val _issueDetail: MutableLiveData<IssueDetail> = MutableLiveData()

    val error: LiveData<Throwable> get() = _error
    private val _error: MutableLiveData<Throwable> = MutableLiveData()

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    private fun getIssueDetail() {
        getIssueDetail
            .execute(numberIssue)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(::onSuccess, ::handleError)
            .let(disposable::add)
    }

    private fun onSuccess(issueDetail: IssueDetail) {
        _issueDetail.value = issueDetail
    }

    private fun handleError(throwable: Throwable) {
        _error.value = throwable
    }
}