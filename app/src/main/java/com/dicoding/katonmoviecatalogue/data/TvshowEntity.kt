package com.dicoding.katonmoviecatalogue.data

data class TvshowEntity(
    var tvshowId: String,
    var title: String,
    var genre: String,
    var rating: String,
    var release: String,
    var seasons: String,
    var director: String,
    var description: String,
    var watchlist: Boolean = false,
    var image: Int
)
