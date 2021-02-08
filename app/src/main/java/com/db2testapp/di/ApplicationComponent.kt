package com.db2testapp.di

import android.app.Application
import com.db2testapp.BankApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        NetworkModule::class,
        RepoModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        AndroidInjectionModule::class]
)
interface ApplicationComponent : AndroidInjector<BankApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): ApplicationComponent
    }

    override fun inject(instance: BankApp?)
}