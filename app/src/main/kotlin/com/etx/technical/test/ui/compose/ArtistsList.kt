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
import com.etx.technical.test.core.Artist
import com.majelan.androidtechnicaltest.R


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
                Artist("0", "Song 0", R.drawable.ic_launcher_background),
                Artist("1", "Song 1", R.drawable.ic_launcher_background),
                Artist("2", "Song 2", R.drawable.ic_launcher_background),
            )
        ) {
            ArtistListItem(it, onItemClick)
        }
    }
}
