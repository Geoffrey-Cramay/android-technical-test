package com.etx.technical.test.core.di

import com.etx.technical.test.core.SongsInteractor
import com.etx.technical.test.core.SongsInteractorImpl
import com.etx.technical.test.core.SongsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped

@Module
@InstallIn(ViewModelComponent::class)
object InteractorModule {

    @Provides
    @ViewModelScoped
    fun provideInteractor(repository: SongsRepository): SongsInteractor =
        SongsInteractorImpl(repository)
}