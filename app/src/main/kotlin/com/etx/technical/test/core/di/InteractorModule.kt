package com.etx.technical.test.core.di

import com.etx.technical.test.core.SongsInteractor
import com.etx.technical.test.core.SongsInteractorImpl
import com.etx.technical.test.core.SongsRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object InteractorModule {

    @Provides
    @ActivityScoped
    fun provideInteractor(repository: SongsRepository): SongsInteractor =
        SongsInteractorImpl(repository)
}