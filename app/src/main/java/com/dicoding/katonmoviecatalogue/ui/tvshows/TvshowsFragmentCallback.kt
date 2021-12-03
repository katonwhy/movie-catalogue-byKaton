package com.dicoding.katonmoviecatalogue.ui.tvshows

import com.dicoding.katonmoviecatalogue.data.TvshowEntity

interface TvshowsFragmentCallback {
    fun onShareClick(tvshow: TvshowEntity)
}
