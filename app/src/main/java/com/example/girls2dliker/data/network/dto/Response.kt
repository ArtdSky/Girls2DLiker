package com.example.girls2dliker.data.network.dto

import kotlinx.serialization.Serializable

@Serializable
data class Response(
	var images : List<Images>

)

@Serializable
data class Images(
	var url  : String

)


