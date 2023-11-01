package com.etx.technical.test.data.repository.parser

import com.etx.technical.test.core.model.Artist
import com.etx.technical.test.data.remote.model.SongResponse

interface SongsParser {
    fun parse(songsList: List<SongResponse>): List<Artist>
}
