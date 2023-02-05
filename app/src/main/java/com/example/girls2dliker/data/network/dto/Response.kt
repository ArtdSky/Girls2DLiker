package com.example.girls2dliker.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class Response(
    val images: List<Images>

)

@Serializable
data class Images(
    val url: String,
    val dominant_color: String
)


