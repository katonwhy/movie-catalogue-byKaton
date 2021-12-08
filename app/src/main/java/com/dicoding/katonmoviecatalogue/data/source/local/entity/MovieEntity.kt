package com.dicoding.katonmoviecatalogue.data.source.local.entity

data class MovieEntity(
    var movieId: Int,
    var title: String,
    var genre: String,
    var rating: Double,
    var release: String,
    var duration: Int,
    var director: String,
    var description: String,
    var watchlist: Boolean = false,
    var image: String
)
