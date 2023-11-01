package com.etx.technical.test.data.remote

import com.etx.technical.test.data.remote.model.SongsResponse
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class RemoteSongsDataSourceImpl @Inject constructor(private val service: SongsService) : RemoteSongsDataSource {
    override suspend fun getSongs(): Flow<SongsResponse> = flow {
        emit(service.getSongs())
    }
}