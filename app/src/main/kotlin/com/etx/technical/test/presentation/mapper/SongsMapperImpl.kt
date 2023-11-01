package com.etx.technical.test.presentation.mapper

import com.etx.technical.test.core.model.Album
import com.etx.technical.test.core.model.Artist
import com.etx.technical.test.core.model.Song
import com.etx.technical.test.presentation.AlbumViewData
import com.etx.technical.test.presentation.ArtistViewData
import com.etx.technical.test.presentation.SongViewData

class SongsMapperImpl : SongsMapper {
    override fun map(artist: Artist): ArtistViewData = with(artist) {
        ArtistViewData(
            name = name,
            album = album.toViewData(),
        )
    }

    private fun Album.toViewData() = AlbumViewData(
        title = title,
        genre = genre,
        cover = cover,
        totalTrackCount = totalTrackCount,
        site = site,
        songList = songList.map { song -> song.toViewData() }
    )

    private fun Song.toViewData() = SongViewData(
        id = id,
        title = title,
        source = source,
        trackNumber = trackNumber,
        duration = duration,
    )
}