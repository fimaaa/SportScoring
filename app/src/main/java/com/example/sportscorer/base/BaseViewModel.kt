package com.example.sportscorer.base

import androidx.lifecycle.ViewModel
import com.example.sportscorer.injection.component.DaggerViewModelInjector
import com.example.sportscorer.injection.component.ViewModelInjector
import com.example.sportscorer.injection.module.NetworkModule
import com.example.sportscorer.ui.activity.post.PostListViewModel

abstract class BaseViewModel: ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
        .builder()
        .networkModule(NetworkModule)
        .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is PostListViewModel -> injector.inject(this)

        }
    }
}