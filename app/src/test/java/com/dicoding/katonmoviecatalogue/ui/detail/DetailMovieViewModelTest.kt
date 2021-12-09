package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.remote.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.ui.detail.DetailMovieViewModel
import com.dicoding.katonmoviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<MovieEntity>

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel(movieRepository)
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieEntity>()
        movie.value = dummyMovie

        `when`(movieRepository.getDetailMovies(movieId)).thenReturn(movie)
        val movies = viewModel.getMovie(movieId).value as MovieEntity
        verify(movieRepository).getDetailMovies(movieId)

        assertNotNull(movies)
        assertEquals(dummyMovie.movieId, movies.movieId)
        assertEquals(dummyMovie.image, movies.image)
        assertEquals(dummyMovie.title, movies.title)
        assertEquals(dummyMovie.description, movies.description)
        assertEquals(dummyMovie.director, movies.director)
        assertEquals(dummyMovie.duration, movies.duration)
        assertEquals(dummyMovie.genre, movies.genre)
        assertEquals(dummyMovie.rating, movies.rating, 0.1)
        assertEquals(dummyMovie.release, movies.release)
        assertEquals(dummyMovie.watchlist, movies.watchlist)

        viewModel.getMovie(movieId).observeForever(observer)
        verify(observer).onChanged(dummyMovie)
    }
}