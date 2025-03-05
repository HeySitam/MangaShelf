package com.heysitam.mangashelf.data_models.local_entities

import android.util.Log
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.heysitam.mangashelf.data_models.base.Manga

@Entity(tableName = "manga")
data class MangaEntity(
    @PrimaryKey @ColumnInfo(name = "db_id") val dbID: Int,
    @ColumnInfo(name = "id")
    val id: String? = null,
    @ColumnInfo("image_url")
    val imageUrl: String? = null,
    @ColumnInfo("score")
    val score: Float? = null,
    @ColumnInfo("popularity")
    val popularity: Long? = null,
    @ColumnInfo("title")
    val title: String? = null,
    @ColumnInfo("published_chapter_date")
    val publishedDateEpoch: Long? = null,
    @ColumnInfo("category")
    val category: String? = null,
    @ColumnInfo("is_favourite")
    val isFavourite: Boolean = false,
    @ColumnInfo("is_read")
    val isRead: Boolean = false
) {
    private fun getMangaScore(): Float {
        val a = "%.1f".format(score).toFloat()
        Log.d("manga_score_tag", "$a")
        return a
    }

    fun toManga(): Manga = Manga(
        id = this.id.orEmpty(),
        imageUrl = this.imageUrl.orEmpty(),
        score = this.getMangaScore(),
        popularity = this.popularity ?: 0L,
        title = this.title.orEmpty(),
        publishedDateEpoch = this.publishedDateEpoch ?: 0L,
        category = this.category.orEmpty(),
        isFavourite = this.isFavourite,
        isRead = this.isRead
    )
}


