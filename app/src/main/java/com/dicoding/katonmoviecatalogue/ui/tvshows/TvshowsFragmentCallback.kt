package com.dicoding.katonmoviecatalogue.ui.tvshows

import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity

interface TvshowsFragmentCallback {
    fun onShareClick(tvshow: TvshowEntity)
}
