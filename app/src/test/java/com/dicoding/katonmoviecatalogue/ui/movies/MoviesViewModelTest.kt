package com.dicoding.katonmoviecatalogue.ui.movies

import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class MoviesViewModelTest {
    private lateinit var viewModel: MoviesViewModel

    @Before
    fun setUp() {
        viewModel = MoviesViewModel()
    }

    @Test
    fun getMovies() {
        val movieEntities = viewModel.getMovies()
        assertNotNull(movieEntities)
        assertEquals(19, movieEntities.size)
    }
}