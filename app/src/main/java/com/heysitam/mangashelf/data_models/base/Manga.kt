package com.heysitam.mangashelf.data_models.base
import kotlinx.datetime.Instant
import kotlinx.datetime.LocalDateTime
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toLocalDateTime

data class Manga(
    val id: String,
    val imageUrl: String,
    val score: Float,
    val popularity: Long,
    val title: String,
    val publishedDateEpoch: Long,
    val category: String,
    val isFavourite: Boolean,
    val isRead: Boolean
) {
    fun getPublishedDate(): LocalDateTime {
        val instant = Instant.fromEpochSeconds(publishedDateEpoch)
        return instant.toLocalDateTime(TimeZone.currentSystemDefault())
    }
}