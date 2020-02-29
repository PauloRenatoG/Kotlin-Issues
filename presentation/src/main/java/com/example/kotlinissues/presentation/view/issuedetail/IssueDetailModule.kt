package com.example.kotlinissues.presentation.view.issuedetail

import androidx.lifecycle.ViewModel
import com.example.kotlinissues.presentation.graph.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class IssueDetailModule {

    @Binds
    @IntoMap
    @ViewModelKey(IssueDetailViewModel::class)
    abstract fun bindsViewModel(viewModel: IssueDetailViewModel): ViewModel
}