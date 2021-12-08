package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.lifecycle.ViewModel
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.utils.DataDummy

class DetailTvshowViewModel: ViewModel() {
    private lateinit var tvshowId: String

    fun setSelectedTvshow(tvshowId: String) {
        this.tvshowId = tvshowId
    }

    fun getTvshow(): TvshowEntity {
        lateinit var tvshow: TvshowEntity
        val tvshows = DataDummy.generateDummyTvshows()
        for (tvshowEntity in tvshows) {
            if (tvshowEntity.tvshowId == tvshowId) {
                tvshow = tvshowEntity
            }
        }
        return tvshow
    }
}