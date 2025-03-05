package com.heysitam.mangashelf.core.di_configs

import com.heysitam.mangashelf.core.network.client.AppNetworkClient
import com.heysitam.mangashelf.models.datasources.remote_datasources.contracts.MangaRemoteDatasource
import com.heysitam.mangashelf.models.datasources.remote_datasources.implementations.MangaRemoteDatasourceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class RemoteDatasourceModule {

    @Singleton
    @Provides
    fun provideMangaRemoteDatasource(appNetworkClient: AppNetworkClient): MangaRemoteDatasource =
        MangaRemoteDatasourceImpl(appNetworkClient)

}