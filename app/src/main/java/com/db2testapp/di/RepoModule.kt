package com.db2testapp.di

import com.db2testapp.data.repository.BankApiRepository
import com.db2testapp.domain.repository.BankRepository
import dagger.Binds
import dagger.Module

@Module
interface RepoModule {

    @Binds
    fun getBankRepository(repository: BankApiRepository): BankRepository
}