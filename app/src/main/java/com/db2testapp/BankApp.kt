package com.db2testapp

import android.app.Application
import com.db2testapp.koin.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

@Suppress("unused")
class BankApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this

        startKoin{
            androidLogger()
            androidContext(this@BankApp)
            modules(appModule)
        }
    }

    companion object {
        var instance: BankApp? = null
            private set
    }
}