package com.etx.technical.test.data.repository

import com.etx.technical.test.core.model.Artist
import com.etx.technical.test.core.SongsRepository
import com.etx.technical.test.data.remote.RemoteSongsDataSource
import com.etx.technical.test.data.repository.parser.SongsParser
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SongsRepositoryImpl @Inject constructor(
    private val dataSource: RemoteSongsDataSource,
    private val parser: SongsParser
) :
    SongsRepository {
    override suspend fun getArtists(): Flow<List<Artist>> = dataSource.getSongs().map { response ->
        parser.parse(response.music)
    }
}