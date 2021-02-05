package com.db2testapp.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.db2testapp.domain.repository.BankRepository
import com.db2testapp.domain.usecase.NbuUseCase
import com.db2testapp.domain.usecase.PbUseCase
import com.db2testapp.presentation.main.MainViewModel

class MainViewModelFactory(
    private val pbUseCase: PbUseCase,
    private val nbuUseCase: NbuUseCase
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(pbUseCase, nbuUseCase) as T
        }
        throw IllegalArgumentException("Unknown class name")
    }
}