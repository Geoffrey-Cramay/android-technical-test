package com.etx.technical.test.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.etx.technical.test.core.SongsInteractor
import com.etx.technical.test.presentation.mapper.SongsMapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArtistsViewModel @Inject constructor(
    private val interactor: SongsInteractor,
    private val mapper: SongsMapper,
) : ViewModel() {
    private val _mutableState = MutableStateFlow<ArtistsListViewState>(ArtistsListViewState.Loading)
    val state: StateFlow<ArtistsListViewState> get() = _mutableState

    fun load() {
        viewModelScope.launch {
            interactor.getArtists()
                .onStart { _mutableState.update { ArtistsListViewState.Loading } }
                .catch { exception ->
                    Log.w(TAG, exception)
                    _mutableState.update { ArtistsListViewState.Error }
                }.collect { artistList ->
                    _mutableState.update {
                        ArtistsListViewState.Success(artistsList = artistList.map { artist ->
                            mapper.map(artist)
                        })
                    }
                }
        }
    }

    companion object {
        private const val TAG = "artists_view_model"
    }
}