package com.example.kotlinissues.presentation.graph.module

import com.example.kotlinissues.presentation.graph.scope.ActivityScope
import com.example.kotlinissues.presentation.graph.scope.FragmentScope
import com.example.kotlinissues.presentation.view.issuedetail.IssueDetailFragment
import com.example.kotlinissues.presentation.view.issuedetail.IssueDetailProvider
import com.example.kotlinissues.presentation.view.listissues.ListIssuesFragment
import com.example.kotlinissues.presentation.view.listissues.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity

    @FragmentScope
    @ContributesAndroidInjector
    fun contributeListIssuesFragment(): ListIssuesFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [IssueDetailProvider::class])
    fun contributeIssueDetailFragment(): IssueDetailFragment
}