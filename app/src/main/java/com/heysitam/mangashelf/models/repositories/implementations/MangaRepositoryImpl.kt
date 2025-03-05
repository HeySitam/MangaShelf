package com.heysitam.mangashelf.models.repositories.implementations

import com.heysitam.mangashelf.core.utils.DelayedResult
import com.heysitam.mangashelf.data_models.base.Manga
import com.heysitam.mangashelf.models.datasources.remote_datasources.contracts.MangaRemoteDatasource
import com.heysitam.mangashelf.models.repositories.contracts.MangaRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MangaRepositoryImpl @Inject constructor(private val mangaRemoteDatasource: MangaRemoteDatasource):
    MangaRepository() {
    private val _mangaListResult: MutableStateFlow<DelayedResult<List<Manga>>> = MutableStateFlow(DelayedResult.idle()) // private mutable state flow
    override val mangaListResult = _mangaListResult.asStateFlow()

    override suspend fun syncAllMangaList() {
        _mangaListResult.emit(DelayedResult.inProgress())
        withContext(Dispatchers.IO) {
            val result = mangaRemoteDatasource.fetchAllMangaList()
            result.onSuccess { mangaResponseList ->
                val mangaList = mangaResponseList.map { mangaResponse -> mangaResponse.toManga() }.toList()
                _mangaListResult.emit(DelayedResult.fromValue(mangaList))
            }.onFailure { error ->
                _mangaListResult.emit(DelayedResult.fromError(Exception(error)))
            }
        }
    }
}