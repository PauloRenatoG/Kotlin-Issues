package com.example.kotlinissues.presentation

import com.example.kotlinissues.presentation.graph.component.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

class ApplicationComponent : DaggerApplication() {
    override fun applicationInjector(): AndroidInjector<ApplicationComponent> {
        return DaggerAppComponent.create()
    }
}