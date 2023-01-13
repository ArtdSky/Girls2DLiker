package com.example.girls2dliker.data.network

import com.example.girls2dliker.data.network.dto.Response
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.request.*

class ApiServiceImpl(
    private val client: HttpClient
) : ApiService {

    override suspend fun getRandomImg(): Response {
        return client.get { url(HttpRoutes.RANDOM_IMAGE) }.body()
    }


}