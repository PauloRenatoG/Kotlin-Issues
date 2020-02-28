package com.example.kotlinissues.presentation.graph.module

import com.example.kotlinissues.presentation.graph.scope.ActivityScope
import com.example.kotlinissues.presentation.graph.scope.FragmentScope
import com.example.kotlinissues.presentation.view.issuedetail.IssueDetailFragment
import com.example.kotlinissues.presentation.view.issuedetail.IssueDetailModule
import com.example.kotlinissues.presentation.view.issuedetail.IssueDetailProvider
import com.example.kotlinissues.presentation.view.listissues.ListIssuesFragment
import com.example.kotlinissues.presentation.view.listissues.ListIssuesModule
import com.example.kotlinissues.presentation.view.listissues.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityBindingModule {

    @ActivityScope
    @ContributesAndroidInjector
    fun contributeMainActivity(): MainActivity

    @FragmentScope
    @ContributesAndroidInjector(modules = [ListIssuesModule::class])
    fun contributeListIssuesFragment(): ListIssuesFragment

    @FragmentScope
    @ContributesAndroidInjector(modules = [IssueDetailProvider::class, IssueDetailModule::class])
    fun contributeIssueDetailFragment(): IssueDetailFragment
}