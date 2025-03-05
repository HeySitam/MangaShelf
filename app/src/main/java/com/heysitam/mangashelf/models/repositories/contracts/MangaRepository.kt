package com.heysitam.mangashelf.models.repositories.contracts

import com.heysitam.mangashelf.core.utils.DelayedResult
import com.heysitam.mangashelf.data_models.base.Manga
import kotlinx.coroutines.flow.StateFlow

abstract class MangaRepository {
    // Required Flows
    abstract val mangaListResult: StateFlow<DelayedResult<List<Manga>>>

    // All Necessary Methods
    abstract suspend fun syncAllMangaList()
}