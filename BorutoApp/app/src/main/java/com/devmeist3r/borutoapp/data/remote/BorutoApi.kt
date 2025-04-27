package com.devmeist3r.borutoapp.data.remote

import kotlinx.serialization.InternalSerializationApi
import retrofit2.http.GET
import retrofit2.http.Query
import com.devmeist3r.borutoapp.domain.model.ApiResponse

@InternalSerializationApi
interface BorutoApi {
    @GET("/boruto/heroes")
    suspend fun getAllHeroes(
        @Query("page") page: Int = 1,
    ): ApiResponse

    @GET("/boruto/heroes/search")
    suspend fun searchHeroes(
        @Query("name") name: String,
    ): ApiResponse
}
