package com.db2testapp.koin

import com.db2testapp.data.network.BankApiClient
import com.db2testapp.data.repository.BankApiRepository
import com.db2testapp.domain.repository.BankRepository
import com.db2testapp.domain.usecase.NbuUseCase
import com.db2testapp.domain.usecase.PbUseCase
import com.db2testapp.presentation.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    single { BankApiClient() }
    factory<BankRepository> { BankApiRepository(get()) }
    factory { PbUseCase(get()) }
    factory { NbuUseCase(get()) }
    viewModel { MainViewModel(get(), get()) }
}