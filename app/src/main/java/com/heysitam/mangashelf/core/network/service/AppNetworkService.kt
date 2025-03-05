package com.heysitam.mangashelf.core.network.service

import com.heysitam.mangashelf.data_models.network_responses.MangaResponse
import retrofit2.Response
import retrofit2.http.GET

interface AppApiService {
    @GET("KEJO")
    suspend fun getMangaList(): Response<List<MangaResponse>>
}