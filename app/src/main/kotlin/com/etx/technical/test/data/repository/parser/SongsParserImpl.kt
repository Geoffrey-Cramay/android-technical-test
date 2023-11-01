package com.etx.technical.test.data.repository.parser

import com.etx.technical.test.core.model.Album
import com.etx.technical.test.core.model.Artist
import com.etx.technical.test.core.model.Song
import com.etx.technical.test.data.remote.model.SongResponse

object SongsParserImpl: SongsParser {
    override fun parse(songsList: List<SongResponse>): List<Artist> =
        songsList.map { it.artist }.distinct().map { artistName ->
            val artistWork = songsList.first { it.artist == artistName }
            Artist(
                name = artistName,
                album = Album(
                    title = artistWork.album,
                    cover = artistWork.image,
                    genre = artistWork.genre,
                    totalTrackCount = artistWork.totalTrackCount,
                    site = artistWork.site,
                    songList = songsList.filter { it.artist == artistName && it.album == artistWork.album }
                        .map { song ->
                            Song(
                                id = song.id,
                                title = song.title,
                                source = song.source,
                                trackNumber = song.trackNumber,
                                duration = song.duration
                            )
                        }
                )
            )
        }
}