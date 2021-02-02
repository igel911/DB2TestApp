package com.db2testapp.presentation.adapter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.db2testapp.domain.repository.BankRepository
import com.db2testapp.domain.usecase.BankUseCase
import com.db2testapp.presentation.MainViewModel

class MainViewModelFactory(private val repository: BankRepository) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(BankUseCase(repository)) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}