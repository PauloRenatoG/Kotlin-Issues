package com.example.kotlinissues.presentation.view.listissues

import androidx.lifecycle.ViewModel
import com.example.kotlinissues.presentation.graph.scope.ViewModelKey
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ListIssuesModule {

    @Binds
    @IntoMap
    @ViewModelKey(ListIssuesFragmentViewModel::class)
    abstract fun bindsListIssuesViewModel(viewModel: ListIssuesFragmentViewModel): ViewModel
}