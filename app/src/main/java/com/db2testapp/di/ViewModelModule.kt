package com.db2testapp.di

import androidx.lifecycle.ViewModelProvider
import com.db2testapp.presentation.MainViewModelFactory
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(factory: MainViewModelFactory) : ViewModelProvider.Factory
}