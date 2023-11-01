package com.etx.technical.test.core.model

data class Artist(
    val name: String,
    val album: Album,
)

data class Album(
    val title: String,
    val genre: String,
    val cover: String,
    val totalTrackCount: Int,
    val site: String,
    val songList: List<Song>
)

data class Song(
    val id: String,
    val title: String,
    val source: String,
    val trackNumber: Int,
    val duration: Int
)