package com.heysitam.mangashelf.views.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.heysitam.mangashelf.R
import com.heysitam.mangashelf.viewmodels.MangaListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MangaListFragment : Fragment() {
    lateinit var mangaListViewModel: MangaListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mangaListViewModel = ViewModelProvider(this)[MangaListViewModel::class.java]
        mangaListViewModel.fetchAllMangaList()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_manga_list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mangaListViewModel.mangaListLiveData.observe(requireActivity(), { delayedMangaList ->
            Log.d("MangaListResponse", delayedMangaList.successValue.toString())
        })
    }
}