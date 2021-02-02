package com.db2testapp

import android.app.Application
import com.db2testapp.data.repository.BankApiRepository
import com.db2testapp.data.repository.BankMockRepository
import com.db2testapp.domain.usecase.BankUseCase

class BankApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
    }

    companion object {
        var instance: BankApp? = null
            private set
        val bankApiRepository = BankApiRepository()
    }
}