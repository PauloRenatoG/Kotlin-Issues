package com.example.kotlinissues.presentation.graph.component

import com.example.kotlinissues.presentation.ApplicationComponent
import com.example.kotlinissues.presentation.graph.module.ActivityBindingModule
import com.example.kotlinissues.presentation.graph.module.ApiProviderModule
import com.example.kotlinissues.presentation.graph.module.ApplicationBindModule
import com.example.kotlinissues.presentation.graph.module.MapperModule
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidInjectionModule::class,
        AndroidSupportInjectionModule::class,
        ApiProviderModule::class,
        MapperModule::class,
        ApplicationBindModule::class,
        ActivityBindingModule::class
    ]
)
interface AppComponent : AndroidInjector<ApplicationComponent>