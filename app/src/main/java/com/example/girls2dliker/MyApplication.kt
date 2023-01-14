package com.example.girls2dliker

import android.app.Application
import com.example.girls2dliker.di.DependencyInjector
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MyApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            modules(listOf( DependencyInjector) )
        }
    }


}