package com.dicoding.katonmoviecatalogue.data.source.local.entity

data class TvshowEntity(
    var tvshowId: Int,
    var title: String,
    var genre: String,
    var rating: Double,
    var release: String,
    var seasons: Int,
    var director: String,
    var description: String,
    var watchlist: Boolean = false,
    var image: String
)
