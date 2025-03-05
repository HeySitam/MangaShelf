package com.heysitam.mangashelf.models.datasources.remote_datasources.implementations

import com.heysitam.mangashelf.core.network.client.AppNetworkClient
import com.heysitam.mangashelf.data_models.network_responses.MangaResponse
import com.heysitam.mangashelf.models.datasources.remote_datasources.contracts.MangaRemoteDatasource
import javax.inject.Inject

class MangaRemoteDatasourceImpl @Inject constructor(private val appNetworkClient: AppNetworkClient): MangaRemoteDatasource {

    override suspend fun fetchAllMangaList(): Result<List<MangaResponse>> {
        return try {
            val response = appNetworkClient.api.getMangaList()
            if (response.isSuccessful) {
                response.body()?.let {
                    Result.success(it)
                } ?: Result.success(listOf())
            } else {
                Result.failure(Exception("Something Went Wrong!"))
            }
        } catch (e: Exception) {
            Result.failure(Exception("Something Went Wrong!"))
        }
    }
}