package com.heysitam.mangashelf.models.datasources.remote_datasources.contracts

import com.heysitam.mangashelf.data_models.network_responses.MangaResponse

interface MangaRemoteDatasource {
  suspend fun fetchAllMangaList(): Result<List<MangaResponse>>
}