package com.etx.technical.test.data.remote

import com.etx.technical.test.data.remote.model.SongsResponse
import kotlinx.coroutines.flow.Flow

interface RemoteSongsDataSource {
    suspend fun getSongs(): Flow<SongsResponse>
}