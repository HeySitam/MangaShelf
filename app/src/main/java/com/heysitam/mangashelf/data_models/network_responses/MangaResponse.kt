package com.heysitam.mangashelf.data_models.network_responses

import android.util.Log
import com.google.gson.annotations.SerializedName
import com.heysitam.mangashelf.data_models.base.Manga

data class MangaResponse(
    @SerializedName("id")
    val id: String? = null,
    @SerializedName("image")
    val imageUrl: String? = null,
    @SerializedName("score")
    val score: Float? = null,
    @SerializedName("popularity")
    val popularity: Long? = null,
    @SerializedName("title")
    val title: String? = null,
    @SerializedName("publishedChapterDate")
    val publishedDateEpoch: Long? = null,
    @SerializedName("category")
    val category: String? = null
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
        isFavourite = false,
        isRead = false
    )
}
