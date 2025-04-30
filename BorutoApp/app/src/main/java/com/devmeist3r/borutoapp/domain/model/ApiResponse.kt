package com.devmeist3r.borutoapp.domain.model

import kotlinx.serialization.Serializable

@OptIn(kotlinx.serialization.InternalSerializationApi::class)
@Serializable
data class ApiResponse(
    val success: Boolean,
    val message: String? = null,
    val prevPage: Int? = null,
    val nextPage: Int? = null,
    val heroes: List<Hero> = emptyList(),
    val lastUpdated: Long? = null,
)
