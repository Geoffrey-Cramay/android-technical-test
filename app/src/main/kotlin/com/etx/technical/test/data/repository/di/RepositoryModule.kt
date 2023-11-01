package com.etx.technical.test.data.repository.di

import com.etx.technical.test.core.SongsRepository
import com.etx.technical.test.data.remote.RemoteSongsDataSource
import com.etx.technical.test.data.remote.RemoteSongsDataSourceImpl
import com.etx.technical.test.data.remote.SongsService
import com.etx.technical.test.data.repository.SongsRepositoryImpl
import com.etx.technical.test.data.repository.parser.SongsParser
import com.etx.technical.test.data.repository.parser.SongsParserImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityScoped

@Module
@InstallIn(ActivityComponent::class)
object RepositoryModule {

    @Provides
    @ActivityScoped
    fun provideRemoteDataSource(service: SongsService): RemoteSongsDataSource =
        RemoteSongsDataSourceImpl(service)

    @Provides
    @ActivityScoped
    fun provideSongsParser(): SongsParser = SongsParserImpl

    @Provides
    @ActivityScoped
    fun provideSongsRepository(
        dataSource: RemoteSongsDataSource,
        parser: SongsParser,
    ): SongsRepository = SongsRepositoryImpl(dataSource, parser)
}