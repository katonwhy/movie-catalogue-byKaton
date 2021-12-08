package com.dicoding.katonmoviecatalogue.data.source.remote

import com.dicoding.katonmoviecatalogue.data.source.remote.api.ApiConfig
import com.dicoding.katonmoviecatalogue.data.source.remote.response.DetailMovies
import com.dicoding.katonmoviecatalogue.data.source.remote.response.DetailTvShow
import com.dicoding.katonmoviecatalogue.data.source.remote.response.Movies
import com.dicoding.katonmoviecatalogue.data.source.remote.response.TvShow
import com.dicoding.katonmoviecatalogue.utils.EspressoIdlingResource
import retrofit2.await

class RemoteDataSource {
    companion object {
        private var instance : RemoteDataSource? = null

        fun getInstance() : RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    suspend fun getAllMovies(callback : LoadMovies) {
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getMovies().await().result.let {
            callback.onAllMoviesReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getDetailMovies(id : Int,callback: LoadDetailMovies){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getDetailMovie(id).await().let {
            callback.onDetailMoviesReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShows(callback : LoadTvShows){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTv().await().result.let {
            callback.onAllTvReceived(it)
            EspressoIdlingResource.decrement()
        }
    }

    suspend fun getTvShowDetail(id : Int, callback : LoadTvShowsDetail){
        EspressoIdlingResource.increment()
        ApiConfig.getApiService().getTvDetail(id).await().let {
            callback.onTvShowsDetail(it)
            EspressoIdlingResource.decrement()
        }
    }

    interface LoadMovies{
        fun onAllMoviesReceived(responseMovies: List<Movies>)
    }

    interface LoadDetailMovies{
        fun onDetailMoviesReceived(responseMovie : DetailMovies)
    }

    interface LoadTvShows{
        fun onAllTvReceived(responseTv : List<TvShow>)
    }

    interface LoadTvShowsDetail{
        fun onTvShowsDetail(responseTv: DetailTvShow)
    }
}