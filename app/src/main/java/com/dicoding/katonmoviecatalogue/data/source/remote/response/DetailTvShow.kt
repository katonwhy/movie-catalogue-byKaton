package com.dicoding.katonmoviecatalogue.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class DetailTvShow(
    @SerializedName("id")
    val id : Int,

    @SerializedName("name")
    val original_name : String,

    @SerializedName("overview")
    val overview : String,

    @SerializedName("first_air_date")
    val date : String,

    @SerializedName("poster_path")
    val poster : String,

    @SerializedName("vote_average")
    val rating : Double,

    @SerializedName("number_of_seasons")
    val seasons : Int,

    @SerializedName("genres")
    val genres : List<Genre>
)
