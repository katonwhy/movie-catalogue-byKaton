package com.dicoding.katonmoviecatalogue.ui.watchlist.tvshows

import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity

interface TvshowsFragmentCallback {
    fun onShareClick(tvShow: TvshowEntity)
}
