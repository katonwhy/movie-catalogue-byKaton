package com.dicoding.katonmoviecatalogue.ui.tvshows

import com.dicoding.katonmoviecatalogue.ui.movies.MoviesViewModel
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class TvshowsViewModelTest {
    private lateinit var viewModel: TvshowsViewModel

    @Before
    fun setUp() {
        viewModel = TvshowsViewModel()
    }

    @Test
    fun getTvshows() {
        val tvshowEntities = viewModel.getTvshows()
        assertNotNull(tvshowEntities)
        assertEquals(20, tvshowEntities.size)
    }
}