package com.dicoding.katonmoviecatalogue.data.source.local.entity

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity(tableName = "movie_entities")
@Parcelize
data class MovieEntity(
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "id")
    var movieId: Int,

    @ColumnInfo(name = "title")
    var title: String,

    @ColumnInfo(name = "genre")
    var genre: String,

    @ColumnInfo(name = "rating")
    var rating: Double,

    @ColumnInfo(name = "release")
    var release: String,

    @ColumnInfo(name = "duration")
    var duration: Int,

    @ColumnInfo(name = "description")
    var description: String,

    @ColumnInfo(name = "watchlist")
    var watchlist: Boolean = false,

    @ColumnInfo(name = "image")
    var image: String
) : Parcelable
