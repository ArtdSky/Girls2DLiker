package com.example.girls2dliker.di

import com.example.girls2dliker.data.network.ApiService
import com.example.girls2dliker.data.network.ApiServiceImpl
import com.example.girls2dliker.viewmodel.MainViewModel
import io.ktor.client.*
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


val DependencyInjector = module {

    single<HttpClient> { HttpClient() }

    single<ApiService> { ApiServiceImpl(client = get()) }

    viewModel { MainViewModel(get()) }

    factory { ApiService.create() }


}