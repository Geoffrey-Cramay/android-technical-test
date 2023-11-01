package com.etx.technical.test.data.remote.model

data class SongsResponse(val music: List<SongResponse>)

data class SongResponse(
    val id: String,
    val title: String,
    val album: String,
    val artist: String,
    val genre: String,
    val source: String,
    val image: String,
    val trackNumber: Int,
    val totalTrackCount: Int,
    val duration: Int,
    val site: String,
)