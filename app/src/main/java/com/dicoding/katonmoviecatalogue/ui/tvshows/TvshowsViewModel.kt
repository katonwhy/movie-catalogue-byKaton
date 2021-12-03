package com.dicoding.katonmoviecatalogue.ui.tvshows

import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.TvshowEntity
import com.dicoding.katonmoviecatalogue.utils.DataDummy

class TvshowsViewModel: ViewModel() {
    fun getTvshows(): List<TvshowEntity> = DataDummy.generateDummyTvshows()
}