package com.example.kotlinissues.presentation.view.issuedetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.domain.entity.IssueDetail
import com.example.domain.interactors.GetIssueDetail
import com.example.kotlinissues.presentation.util.NUMBER_ISSUE
import com.example.kotlinissues.presentation.util.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Named

class IssueDetailViewModel @Inject constructor(
    private val getIssueDetail: GetIssueDetail,
    @Named(NUMBER_ISSUE) private val numberIssue: Long?
) : BaseViewModel() {

    val issueDetail: LiveData<IssueDetail> get() = _issueDetail
    val error: LiveData<Throwable> get() = _error
    private val _issueDetail: MutableLiveData<IssueDetail> = MutableLiveData()
    private val _error: MutableLiveData<Throwable> = MutableLiveData()
    private val disposable = CompositeDisposable()

    internal fun getIssueDetail() {
        disposable.add(
            getIssueDetail
                .execute(numberIssue)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(::onSuccess, ::handleError)
        )
    }

    internal fun clearDisposables() {
        disposable.clear()
    }

    private fun onSuccess(issueDetail: IssueDetail) {
        _issueDetail.value = issueDetail
    }

    private fun handleError(throwable: Throwable) {
        _error.value = throwable
    }
}