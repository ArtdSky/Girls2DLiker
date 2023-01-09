package com.example.girls2dliker.di

import android.content.Context
import com.example.girls2dliker.database.AppDatabase
import com.example.girls2dliker.repository.Repository
import com.example.girls2dliker.repository.RepositoryImpl

class DependencyInjector(applicationContext : Context) {

    private val db : AppDatabase by lazy { provideDatabase(applicationContext) }

    val repository : Repository by lazy { provideRepository(db) }


    private fun provideDatabase(applicationContext: Context){
        TODO(/* DB builder */)
    }

    private fun provideRepository(database : AppDatabase) : Repository{

        return RepositoryImpl()
    }
}
