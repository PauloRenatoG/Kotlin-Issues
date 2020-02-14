package com.example.kotlinissues.presentation.view.issuedetail

import com.example.kotlinissues.presentation.util.NUMBER_ISSUE
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class IssueDetailProvider {

    @Provides
    @Named(NUMBER_ISSUE)
    fun provideNumberIssue(fragment: IssueDetailFragment): Long? {
        return fragment.numberIssue
    }
}