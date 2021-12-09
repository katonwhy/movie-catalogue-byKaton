package com.dicoding.katonmoviecatalogue.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.dicoding.katonmoviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.katonmoviecatalogue.utils.DataDummy
import com.dicoding.katonmoviecatalogue.utils.LiveDataTestUtil
import com.nhaarman.mockitokotlin2.any
import com.nhaarman.mockitokotlin2.doAnswer
import com.nhaarman.mockitokotlin2.eq
import com.nhaarman.mockitokotlin2.verify
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito

class MovieRepositoryTest {
    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private val remote = Mockito.mock(RemoteDataSource::class.java)
    private val movieRepository = FakeMovieRepository(remote)

    private val movieResponse = DataDummy.generateMovieRepository()
    private val movieId = movieResponse[0].id
    private val tvShowResponse = DataDummy.generateTvShowResponse()
    private val tvShowId = tvShowResponse[0].id
    private val movieDetailResponse = DataDummy.generateDetailMovie()[0]
    private val tvDetailResponse = DataDummy.generateDetailTv()[0]

    @Test
    fun getAllMovies() {
        runBlocking {
            doAnswer {
                (it.arguments[0] as RemoteDataSource.LoadMovies).onAllMoviesReceived(movieResponse)
                null
            }.`when`(remote).getAllMovies(any())
        }
        val moviesEntity = LiveDataTestUtil.getValues(movieRepository.getAllMovies())
        runBlocking {
            verify(remote).getAllMovies(any())
        }
        TestCase.assertNotNull(moviesEntity)
        assertEquals(movieResponse.size.toLong(), moviesEntity.size.toLong())
    }

    @Test
    fun getAllTvShow(){
        runBlocking {
            doAnswer {
                (it.arguments[0] as RemoteDataSource.LoadTvShows).onAllTvReceived(tvShowResponse)
                null
            }.`when`(remote).getTvShows(any())

        }

        val tvEntity = LiveDataTestUtil.getValues(movieRepository.getAllTvShow())

        runBlocking {
            verify(remote).getTvShows(any())
        }
        TestCase.assertNotNull(tvEntity)
        assertEquals(tvShowResponse.size.toLong(), tvEntity.size.toLong())
    }

    @Test
    fun getDetailMovies(){
        runBlocking {
            doAnswer {
                (it.arguments[1] as RemoteDataSource.LoadDetailMovies).onDetailMoviesReceived(movieDetailResponse)
                null
            }.`when`(remote).getDetailMovies(eq(movieId), any())
        }

        val movieDetail = LiveDataTestUtil.getValues(movieRepository.getDetailMovies(movieId))
        runBlocking {
            verify(remote).getDetailMovies(eq(movieId), any())
        }
        TestCase.assertNotNull(movieDetail)
        assertEquals(movieDetailResponse.id, movieDetail.movieId)
    }

    @Test
    fun getDetailTv(){
        runBlocking {
            doAnswer {
                (it.arguments[1] as RemoteDataSource.LoadTvShowsDetail).onTvShowsDetail(tvDetailResponse)
                null
            }.`when`(remote).getTvShowDetail(eq(tvShowId), any())

        }

        val tvShowDetail = LiveDataTestUtil.getValues(movieRepository.getDetailTvShow(tvShowId))
        runBlocking {
            verify(remote).getTvShowDetail(eq(tvShowId), any())
        }
        TestCase.assertNotNull(tvShowDetail)
        assertEquals(tvDetailResponse.id, tvShowDetail.tvshowId)


    }
}