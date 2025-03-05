package com.heysitam.mangashelf.core.di_configs

import android.content.Context
import androidx.room.Room
import com.heysitam.mangashelf.core.local_db.dao.MangaDao
import com.heysitam.mangashelf.core.local_db.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class LocalDatabaseModule {

    @Singleton
    @Provides
    fun provideAppDatabase(@ApplicationContext appContext: Context): AppDatabase = Room.databaseBuilder(
        appContext,
        AppDatabase::class.java,
        "manga_shelf_database"
    ).build()

    @Provides
    fun provideMangaDao(appDatabase: AppDatabase): MangaDao = appDatabase.mangaDao()

}