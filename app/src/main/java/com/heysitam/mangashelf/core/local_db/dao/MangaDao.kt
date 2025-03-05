package com.heysitam.mangashelf.core.local_db.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Update
import com.heysitam.mangashelf.data_models.local_entities.MangaEntity

@Dao
interface MangaDao {
    @Query("SELECT * FROM manga")
    fun getAllMangas(): List<MangaEntity>

    @Delete
    fun deleteManga(manga: MangaEntity)

    @Update
    fun updateUser(manga: MangaEntity)

    @Query("DELETE FROM manga")
    fun deleteAllMangas()
}