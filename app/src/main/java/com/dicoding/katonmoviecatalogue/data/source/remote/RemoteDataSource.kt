package com.dicoding.katonmoviecatalogue.data.source.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dicoding.katonmoviecatalogue.data.source.remote.api.ApiConfig
import com.dicoding.katonmoviecatalogue.data.source.remote.response.*
import com.dicoding.katonmoviecatalogue.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.await

class RemoteDataSource {
    companion object {
        @Volatile
        private var instance : RemoteDataSource? = null

        fun getInstance() : RemoteDataSource =
            instance ?: synchronized(this) {
                instance ?: RemoteDataSource().apply { instance = this }
            }
    }

    fun getMovies(): LiveData<ApiResponse<List<Movies>>> {
        EspressoIdlingResource.increment()
        val resultMovies = MutableLiveData<ApiResponse<List<Movies>>>()
        val client = ApiConfig.getApiService().getMovies()

        client.enqueue(object : Callback<MovieResponse> {
            override fun onResponse(call: Call<MovieResponse>, response: Response<MovieResponse>) {
                resultMovies.value = ApiResponse.success(response.body()?.result as List<Movies>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<MovieResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovies onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return resultMovies
    }

    fun getDetailMovie(movieId: Int): LiveData<ApiResponse<DetailMovies>> {
        EspressoIdlingResource.increment()
        val resultDetailMovie = MutableLiveData<ApiResponse<DetailMovies>>()
        val client = ApiConfig.getApiService().getDetailMovie(movieId)

        client.enqueue(object : Callback<DetailMovies> {
            override fun onResponse(call: Call<DetailMovies>, response: Response<DetailMovies>) {
                resultDetailMovie.value = ApiResponse.success(response.body() as DetailMovies)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailMovies>, t: Throwable) {
                Log.e("RemoteDataSource", "getMovieDetail onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return resultDetailMovie
    }

    fun getTvShows(): LiveData<ApiResponse<List<TvShow>>> {
        EspressoIdlingResource.increment()
        val resultTvShows = MutableLiveData<ApiResponse<List<TvShow>>>()
        val client = ApiConfig.getApiService().getTv()

        client.enqueue(object : Callback<TvResponse> {
            override fun onResponse(call: Call<TvResponse>, response: Response<TvResponse>) {
                resultTvShows.value = ApiResponse.success(response.body()?.result as List<TvShow>)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<TvResponse>, t: Throwable) {
                Log.e("RemoteDataSource", "getTvShows onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return resultTvShows
    }

    fun getDetailTvShow(tvShowId: Int): LiveData<ApiResponse<DetailTvShow>> {
        EspressoIdlingResource.increment()
        val resultDetailTvShow = MutableLiveData<ApiResponse<DetailTvShow>>()
        val client = ApiConfig.getApiService().getTvDetail(tvShowId)

        client.enqueue(object : Callback<DetailTvShow> {
            override fun onResponse(call: Call<DetailTvShow>, response: Response<DetailTvShow>) {
                resultDetailTvShow.value = ApiResponse.success(response.body() as DetailTvShow)
                EspressoIdlingResource.decrement()
            }

            override fun onFailure(call: Call<DetailTvShow>, t: Throwable) {
                Log.e("RemoteDataSource", "getDetailTvShow onFailure : ${t.message}")
                EspressoIdlingResource.decrement()
            }
        })

        return resultDetailTvShow
    }
}