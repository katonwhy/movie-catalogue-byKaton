package com.dicoding.katonmoviecatalogue.utils

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.di.Injection
import com.dicoding.katonmoviecatalogue.ui.detail.DetailMovieViewModel
import com.dicoding.katonmoviecatalogue.ui.detail.DetailTvshowViewModel
import com.dicoding.katonmoviecatalogue.ui.movies.MoviesViewModel
import com.dicoding.katonmoviecatalogue.ui.tvshows.TvshowsViewModel
import com.dicoding.katonmoviecatalogue.ui.watchlist.movies.MovieWatchlistViewModel
import com.dicoding.katonmoviecatalogue.ui.watchlist.tvshows.TvshowsWatchlistViewModel

class ViewModelFactory private constructor(private val movieRepository: MovieRepository)
    : ViewModelProvider.NewInstanceFactory(){

    companion object{
        @Volatile
        private var instance : ViewModelFactory? = null

        fun getInstance(context: Context) : ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context))
                    .apply { instance = this }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        when{
            modelClass.isAssignableFrom(MoviesViewModel::class.java) -> {
                return MoviesViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(TvshowsViewModel::class.java) -> {
                return TvshowsViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvshowViewModel::class.java) -> {
                return DetailTvshowViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(MovieWatchlistViewModel::class.java) -> {
                return MovieWatchlistViewModel(movieRepository) as T
            }
            modelClass.isAssignableFrom(TvshowsWatchlistViewModel::class.java) -> {
                return TvshowsWatchlistViewModel(movieRepository) as T
            }
            else -> {
                throw Throwable("Unknown ViewModel class" + modelClass)
            }
        }
    }

}