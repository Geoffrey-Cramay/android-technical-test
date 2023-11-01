package com.etx.technical.test.ui.compose

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.etx.technical.test.core.model.Album
import com.etx.technical.test.core.model.Artist


@Composable
fun ArtistsList(
    modifier: Modifier,
    onItemClick: (Artist) -> Unit,
) {
    LazyColumn(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally,
        contentPadding = PaddingValues(8.dp),
    ) {
        items(
            listOf(
                Artist(
                    "Artist 0",
                    Album(
                        title = "Album 1",
                        genre = "genre",
                        cover = "cover",
                        totalTrackCount = 0,
                        site = "site",
                        songList = emptyList()
                    )
                ),
            )
        ) {
            ArtistListItem(it, onItemClick)
        }
    }
}
