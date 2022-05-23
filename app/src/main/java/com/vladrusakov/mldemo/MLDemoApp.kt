package com.vladrusakov.mldemo

import android.app.Application
import com.vladrusakov.mldemo.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MLDemoApp : Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }

    private fun initKoin() {
        startKoin {
            androidContext(this@MLDemoApp)
            modules(
                listOf(
                    viewModelModule,
                    dataModule,
                    networkModule,
                    domainModule,
                    appModule
                )
            )
        }
    }
}
