package com.dicoding.katonmoviecatalogue.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.dicoding.katonmoviecatalogue.data.source.local.LocalDataSource
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.katonmoviecatalogue.utils.AppExecutors
import com.dicoding.katonmoviecatalogue.utils.DataDummy
import com.dicoding.katonmoviecatalogue.utils.LiveDataTestUtil
import com.dicoding.katonmoviecatalogue.utils.PagedListUtil
import com.dicoding.katonmoviecatalogue.vo.Resource
import com.nhaarman.mockitokotlin2.*
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Assert
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val local = Mockito.mock(LocalDataSource::class.java)
    private val appExecutors = Mockito.mock(AppExecutors::class.java)
    private val movieRepository = FakeMovieRepository(remote, local, appExecutors)

    private val movieResponse = DataDummy.generateMovieRepository()
    private val movieId = movieResponse[0].id
    private val movieDetailResponse = DataDummy.generateDetailMovie()[0]

    private val tvShowResponse = DataDummy.generateTvShowResponse()
    private val tvShowId = tvShowResponse[0].id
    private val tvDetailResponse = DataDummy.generateDetailTv()[0]

    //Movie Testing
    @Test
    fun getAllMovies() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getAllMovies()).thenReturn(dataSourceFactory)
        movieRepository.getAllMovies()

        val moviesEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))

        verify(local).getAllMovies()
        TestCase.assertNotNull(moviesEntities.data)
        assertEquals(movieResponse.size.toLong(), moviesEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailMovies(){
        val dummyDetail = MutableLiveData<MovieEntity>()
        dummyDetail.value = DataDummy.generateDummyMovies()[0]
        Mockito.`when`(local.getMovieById(movieId)).thenReturn(dummyDetail)

        val movieDetail = LiveDataTestUtil.getValues(movieRepository.getDetailMovies(movieId))
        verify(local).getMovieById(movieId)
        Assert.assertNotNull(movieDetail)
        assertEquals(movieDetailResponse.id, movieDetail.data?.movieId)
    }

    @Test
    fun getFavoriteMovie() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, MovieEntity>
        Mockito.`when`(local.getFavMovies()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteMovies()

        val movieEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyMovies()))
        verify(local).getFavMovies()
        Assert.assertNotNull(movieEntities)
        assertEquals(movieResponse.size, movieEntities.data?.size)
    }

    @Test
    fun setFavoriteMovie() {
        movieRepository.setFavoriteMovie(DataDummy.generateDummyMovies()[0], true)
        verify(local).setFavoriteMovie(DataDummy.generateDummyMovies()[0], true)
        verifyNoMoreInteractions(local)
    }

    //TvShows Testing
    @Test
    fun getAllTvShow(){
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        Mockito.`when`(local.getAllTvShows()).thenReturn(dataSourceFactory)
        movieRepository.getAllTvShow()

        val tvEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvshows()))

        verify(local).getAllTvShows()
        TestCase.assertNotNull(tvEntities)
        assertEquals(tvShowResponse.size.toLong(), tvEntities.data?.size?.toLong())
    }

    @Test
    fun getDetailTv(){
        val dummyDetail = MutableLiveData<TvshowEntity>()
        dummyDetail.value = DataDummy.generateDummyTvshows()[0]
        Mockito.`when`(local.getTvShowById(tvShowId)).thenReturn(dummyDetail)

        val tvShowDetail = LiveDataTestUtil.getValues(movieRepository.getDetailTvShow(tvShowId))
        verify(local).getTvShowById(tvShowId)
        TestCase.assertNotNull(tvShowDetail)
        assertEquals(tvDetailResponse.id, tvShowDetail.data?.tvshowId)
    }

    @Test
    fun getFavoriteTvShow() {
        val dataSourceFactory = Mockito.mock(DataSource.Factory::class.java) as DataSource.Factory<Int, TvshowEntity>
        Mockito.`when`(local.getFavTvShows()).thenReturn(dataSourceFactory)
        movieRepository.getFavoriteTvShows()

        val tvShowEntities = Resource.success(PagedListUtil.mockPagedList(DataDummy.generateDummyTvshows()))
        verify(local).getFavTvShows()
        Assert.assertNotNull(tvShowEntities)
        assertEquals(tvShowResponse.size, tvShowEntities.data?.size)
    }

    @Test
    fun setFavoriteTvShow() {
        movieRepository.setFavoriteTvShow(DataDummy.generateDummyTvshows()[0], true)
        verify(local).setFavoriteTvShow(DataDummy.generateDummyTvshows()[0], true)
        verifyNoMoreInteractions(local)
    }
}