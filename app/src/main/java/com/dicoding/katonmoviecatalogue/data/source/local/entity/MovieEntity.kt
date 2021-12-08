package com.dicoding.katonmoviecatalogue.data.source.local.entity

data class MovieEntity(
    var movieId: String,
    var title: String,
    var genre: String,
    var rating: String,
    var release: String,
    var duration: String,
    var director: String,
    var description: String,
    var watchlist: Boolean = false,
    var image: Int
)
