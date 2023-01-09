package com.example.girls2dliker

import android.app.Application
import com.example.girls2dliker.di.DependencyInjector

class MyApplication : Application() {

    lateinit var dependencyInjector: DependencyInjector

    override fun onCreate() {
        super.onCreate()
    }

    private fun initDependencyInjector(){
        dependencyInjector = DependencyInjector(this)
    }
}