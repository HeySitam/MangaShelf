package com.heysitam.mangashelf.core.local_db.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.heysitam.mangashelf.core.local_db.dao.MangaDao
import com.heysitam.mangashelf.data_models.local_entities.MangaEntity

@Database(entities = [MangaEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract  fun mangaDao(): MangaDao
}