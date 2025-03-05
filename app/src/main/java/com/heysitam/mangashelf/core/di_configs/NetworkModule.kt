package com.heysitam.mangashelf.core.di_configs

import com.heysitam.mangashelf.core.network.client.AppNetworkClient
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@InstallIn(SingletonComponent::class)
@Module
class NetworkModule {

    @Singleton
    @Provides
    fun provideNetworkClient(): AppNetworkClient = AppNetworkClient()
}