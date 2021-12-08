package com.dicoding.katonmoviecatalogue.data.source.remote.api

import com.dicoding.katonmoviecatalogue.data.source.remote.response.DetailMovies
import com.dicoding.katonmoviecatalogue.data.source.remote.response.DetailTvShow
import com.dicoding.katonmoviecatalogue.data.source.remote.response.MovieResponse
import com.dicoding.katonmoviecatalogue.data.source.remote.response.TvResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("movie/popular")
    fun getMovies(
        @Query("api_key") api_key : String = "3f2a312467e95f04d1568367c855f08a",
        @Query("page") page : String = "1",
        @Query("language") language : String = "en-US",
    ) : Call<MovieResponse>

    @GET("movie/{movie_id}")
    fun getDetailMovie(
        @Path("movie_id") id : Int,
        @Query("api_key") api_key: String = "3f2a312467e95f04d1568367c855f08a"
    ) : Call<DetailMovies>

    @GET("tv/popular")
    fun getTv(
        @Query("api_key") api_key : String = "3f2a312467e95f04d1568367c855f08a",
        @Query("page") page : String = "1",
        @Query("language") language : String = "en-US",
    ) : Call<TvResponse>

    @GET("tv/{tv_id}")
    fun getTvDetail(
        @Path("tv_id") id : Int,
        @Query("api_key") api_key: String = "3f2a312467e95f04d1568367c855f08a"
    ) : Call<DetailTvShow>

}