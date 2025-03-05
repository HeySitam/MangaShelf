package com.heysitam.mangashelf.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.heysitam.mangashelf.core.utils.DelayedResult
import com.heysitam.mangashelf.data_models.base.Manga
import com.heysitam.mangashelf.data_models.local_entities.MangaEntity
import com.heysitam.mangashelf.models.repositories.contracts.MangaRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MangaListViewModel @Inject constructor(private val mangaRepository: MangaRepository): ViewModel()  {
    private val _mangaListLiveData: MutableLiveData<DelayedResult<List<Manga>>> = MutableLiveData();
    val mangaListLiveData: LiveData<DelayedResult<List<Manga>>> = _mangaListLiveData

    init {
     viewModelScope.launch {
         mangaRepository.mangaListResult.collect{ result ->
             _mangaListLiveData.value = result
         }
     }
    }

    fun fetchAllMangaList() {
        viewModelScope.launch {
            mangaRepository.syncAllMangaList()
        }
    }
}