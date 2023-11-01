package com.etx.technical.test.presentation.di

import com.etx.technical.test.presentation.mapper.SongsMapper
import com.etx.technical.test.presentation.mapper.SongsMapperImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
class ViewModelModule {

    @Provides
    @ViewModelScoped
    fun provideMapper(): SongsMapper = SongsMapperImpl()
}