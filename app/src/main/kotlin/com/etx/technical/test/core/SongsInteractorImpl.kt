package com.etx.technical.test.core

import com.etx.technical.test.core.model.Artist
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SongsInteractorImpl @Inject constructor(private val repository: SongsRepository) :
    SongsInteractor {
    override suspend fun getArtists(): Flow<List<Artist>> = repository.getArtists()
        .map { artistList ->
            artistList.sortedBy { artist -> artist.name }
        }
}