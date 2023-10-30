package com.etx.technical.test.navigation

import com.etx.technical.test.navigation.Routes.ARTISTS_ROUTE
import com.etx.technical.test.navigation.Routes.MEDIA_ROUTE
import com.etx.technical.test.navigation.Routes.PLAYER_ROUTE

sealed class Screens(val route: String) {
    object Artists : Screens(ARTISTS_ROUTE)
    object Media : Screens("$MEDIA_ROUTE/{${ArgKeys.SONG_ID_ARG_KEY}}") {
        fun getMediaScreenPath(songId: String): String = "$MEDIA_ROUTE/$songId"
    }

    object Player : Screens("$PLAYER_ROUTE/{${ArgKeys.SONG_ID_ARG_KEY}}") {
        fun getPlayerScreenPath(songId: String): String = "$PLAYER_ROUTE/$songId"
    }
}

object Routes {
    const val ARTISTS_ROUTE = "artists"
    const val MEDIA_ROUTE = "medias"
    const val PLAYER_ROUTE = "player"
}

object ArgKeys {
    const val SONG_ID_ARG_KEY = "song"
}