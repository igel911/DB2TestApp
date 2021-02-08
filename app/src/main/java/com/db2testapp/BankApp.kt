package com.db2testapp

import com.db2testapp.di.ApplicationComponent
import com.db2testapp.di.DaggerApplicationComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

class BankApp : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent: ApplicationComponent = DaggerApplicationComponent.builder()
            .application(this)
            .build()

        appComponent.inject(this)
        return appComponent
    }
}