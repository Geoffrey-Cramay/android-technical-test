package com.etx.technical.test.core

import com.etx.technical.test.core.model.Artist
import kotlinx.coroutines.flow.Flow

interface SongsInteractor {
    suspend fun getArtists() : Flow<List<Artist>>
}