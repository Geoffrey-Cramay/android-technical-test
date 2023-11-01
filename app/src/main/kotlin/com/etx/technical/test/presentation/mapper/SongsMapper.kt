package com.etx.technical.test.presentation.mapper

import com.etx.technical.test.core.model.Artist
import com.etx.technical.test.presentation.ArtistViewData

interface SongsMapper {
    fun map(artist: Artist): ArtistViewData
}