package com.etx.technical.test.presentation

sealed class ArtistsListViewState {

    data class Success(val artistsList: List<ArtistViewData>) : ArtistsListViewState()
    object Loading : ArtistsListViewState()
    object Error : ArtistsListViewState()
}

data class ArtistViewData(
    val name: String,
    val album: AlbumViewData,
)

data class AlbumViewData(
    val title: String,
    val genre: String,
    val cover: String,
    val totalTrackCount: Int,
    val site: String,
    val songList: List<SongViewData>
)

data class SongViewData(
    val id: String,
    val title: String,
    val source: String,
    val trackNumber: Int,
    val duration: Int
)