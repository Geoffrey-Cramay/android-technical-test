package com.etx.technical.test.data.remote

import com.etx.technical.test.data.remote.model.SongsResponse
import retrofit2.http.GET

interface SongsService {
    @GET("catalog.json")
    suspend fun getSongs(): SongsResponse
}