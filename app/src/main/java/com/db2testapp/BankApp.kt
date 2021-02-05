package com.db2testapp

import android.app.Application
import com.db2testapp.data.repository.BankApiRepository

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