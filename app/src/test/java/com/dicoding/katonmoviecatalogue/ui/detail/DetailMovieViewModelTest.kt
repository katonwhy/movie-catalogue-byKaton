package com.dicoding.katonmoviecatalogue.ui.detail

import com.dicoding.katonmoviecatalogue.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DetailMovieViewModelTest {
    private lateinit var viewModel: DetailMovieViewModel
    private val dummyMovie = DataDummy.generateDummyMovies()[0]
    private val movieId = dummyMovie.movieId

    @Before
    fun setUp() {
        viewModel = DetailMovieViewModel()
        viewModel.setSelectedMovie(movieId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedMovie(dummyMovie.movieId)
        val movieEntity = viewModel.getMovie()
        assertNotNull(movieEntity)
        assertEquals(dummyMovie.movieId, movieEntity.movieId)
        assertEquals(dummyMovie.image, movieEntity.image)
        assertEquals(dummyMovie.title, movieEntity.title)
        assertEquals(dummyMovie.description, movieEntity.description)
        assertEquals(dummyMovie.director, movieEntity.director)
        assertEquals(dummyMovie.duration, movieEntity.duration)
        assertEquals(dummyMovie.genre, movieEntity.genre)
        assertEquals(dummyMovie.rating, movieEntity.rating)
        assertEquals(dummyMovie.release, movieEntity.release)
        assertEquals(dummyMovie.watchlist, movieEntity.watchlist)
    }
}