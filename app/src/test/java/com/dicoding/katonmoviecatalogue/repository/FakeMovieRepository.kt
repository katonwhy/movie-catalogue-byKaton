package com.dicoding.katonmoviecatalogue.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.dicoding.katonmoviecatalogue.data.NetworkBoundResource
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.katonmoviecatalogue.data.repository.MovieDataSource
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.data.source.local.LocalDataSource
import com.dicoding.katonmoviecatalogue.data.source.remote.ApiResponse
import com.dicoding.katonmoviecatalogue.data.source.remote.response.DetailMovies
import com.dicoding.katonmoviecatalogue.data.source.remote.response.DetailTvShow
import com.dicoding.katonmoviecatalogue.data.source.remote.response.Movies
import com.dicoding.katonmoviecatalogue.data.source.remote.response.TvShow
import com.dicoding.katonmoviecatalogue.utils.AppExecutors
import com.dicoding.katonmoviecatalogue.vo.Resource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.lang.StringBuilder

class FakeMovieRepository constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource,
    private val appExecutors: AppExecutors
) : MovieDataSource {

    override fun getAllMovies(): LiveData<Resource<PagedList<MovieEntity>>> {
        return object : NetworkBoundResource<PagedList<MovieEntity>, List<Movies>>(appExecutors) {
            override fun loadFromDb(): LiveData<PagedList<MovieEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllMovies(), config).build()
            }

            override fun shouldFetch(data: PagedList<MovieEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<Movies>>> =
                remoteDataSource.getMovies()

            override fun saveCallResult(data: List<Movies>) {
                val movieList = ArrayList<MovieEntity>()
                for (i in data) {
                    val movie = MovieEntity(
                        movieId = i.id,
                        title = i.title,
                        description = i.overview,
                        release = i.date,
                        image = i.poster,
                        rating = i.rating,
                        genre = "",
                        duration = i.runtime
                    )
                    movieList.add(movie)
                }
                localDataSource.insertMovies(movieList)
            }
        }.asLiveData()
    }

    override fun getDetailMovies(id : Int): LiveData<Resource<MovieEntity>> {
        return object : NetworkBoundResource<MovieEntity, DetailMovies>(appExecutors) {
            override fun loadFromDb(): LiveData<MovieEntity> = localDataSource.getMovieById(id)

            override fun shouldFetch(data: MovieEntity?): Boolean =
                data != null && data.duration == 0 && data.genre == ""

            override fun createCall(): LiveData<ApiResponse<DetailMovies>> =
                remoteDataSource.getDetailMovie(id)

            override fun saveCallResult(data: DetailMovies) {
                val genres = StringBuilder().append("")

                for (i in data.genres.indices) {
                    if (i < data.genres.size - 1) {
                        genres.append("${data.genres[i].name}, ")
                    } else {
                        genres.append(data.genres[i].name)
                    }
                }

                val movie = MovieEntity(
                    movieId = data.id,
                    title = data.title,
                    description = data.overview,
                    release = data.date,
                    image = data.poster,
                    rating = data.rating,
                    duration = data.runtime,
                    genre = genres.toString(),
                    watchlist = false
                )
                localDataSource.updateMovie(movie, false)
            }
        }.asLiveData()
    }

    override fun getFavoriteMovies(): LiveData<PagedList<MovieEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavMovies(), config).build()
    }

    override fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
            localDataSource.setFavoriteMovie(movie, state)
    }

    override fun getAllTvShow(): LiveData<Resource<PagedList<TvshowEntity>>> {
        return object : NetworkBoundResource<PagedList<TvshowEntity>, List<TvShow>>(appExecutors) {
            override fun loadFromDb(): LiveData<PagedList<TvshowEntity>> {
                val config = PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setInitialLoadSizeHint(4)
                    .setPageSize(4)
                    .build()

                return LivePagedListBuilder(localDataSource.getAllTvShows(), config).build()
            }

            override fun shouldFetch(data: PagedList<TvshowEntity>?): Boolean =
                data == null || data.isEmpty()

            override fun createCall(): LiveData<ApiResponse<List<TvShow>>> =
                remoteDataSource.getTvShows()

            override fun saveCallResult(data: List<TvShow>) {
                val tvshows = ArrayList<TvshowEntity>()
                for (i in data){
                    val tv = TvshowEntity(
                        tvshowId = i.id,
                        title = i.original_name,
                        description = i.overview,
                        release = i.date,
                        image = i.poster,
                        rating = i.rating,
                        genre = "",
                        seasons = 0,
                        watchlist = false
                    )
                    tvshows.add(tv)
                }
                localDataSource.insertTvShows(tvshows)
            }
        }.asLiveData()
    }

    override fun getDetailTvShow(id: Int): LiveData<Resource<TvshowEntity>> {
        return object : NetworkBoundResource<TvshowEntity, DetailTvShow>(appExecutors) {
            override fun loadFromDb(): LiveData<TvshowEntity> = localDataSource.getTvShowById(id)

            override fun shouldFetch(data: TvshowEntity?): Boolean =
                data != null && data.seasons == 0 && data.genre == ""

            override fun createCall(): LiveData<ApiResponse<DetailTvShow>> =
                remoteDataSource.getDetailTvShow(id)

            override fun saveCallResult(data: DetailTvShow) {
                val genres = StringBuilder().append("")

                for (i in data.genres.indices) {
                    if (i < data.genres.size - 1) {
                        genres.append("${data.genres[i].name}, ")
                    } else {
                        genres.append(data.genres[i].name)
                    }
                }

                val tv = TvshowEntity(
                    tvshowId = data.id,
                    title = data.original_name,
                    description = data.overview,
                    release = data.date,
                    image = data.poster,
                    rating = data.rating,
                    seasons = data.seasons,
                    genre = genres.toString(),
                    watchlist = false
                )
                localDataSource.updateTvShow(tv, false)
            }
        }.asLiveData()
    }

    override fun getFavoriteTvShows(): LiveData<PagedList<TvshowEntity>> {
        val config = PagedList.Config.Builder()
            .setEnablePlaceholders(false)
            .setInitialLoadSizeHint(4)
            .setPageSize(4)
            .build()

        return LivePagedListBuilder(localDataSource.getFavTvShows(), config).build()
    }

    override fun setFavoriteTvShow(tvShow: TvshowEntity, state: Boolean) {
            localDataSource.setFavoriteTvShow(tvShow, state)
    }
}