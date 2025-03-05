package com.heysitam.mangashelf.core.di_configs

import com.heysitam.mangashelf.models.datasources.remote_datasources.contracts.MangaRemoteDatasource
import com.heysitam.mangashelf.models.repositories.contracts.MangaRepository
import com.heysitam.mangashelf.models.repositories.implementations.MangaRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMangaRepository(mangaRemoteDatasource: MangaRemoteDatasource): MangaRepository =
        MangaRepositoryImpl(mangaRemoteDatasource)
}