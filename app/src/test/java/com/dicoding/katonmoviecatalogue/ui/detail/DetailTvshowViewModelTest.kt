package com.dicoding.katonmoviecatalogue.ui.detail

import com.dicoding.katonmoviecatalogue.utils.DataDummy
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class DetailTvshowViewModelTest {
    private lateinit var viewModel: DetailTvshowViewModel
    private val dummyTvshow = DataDummy.generateDummyTvshows()[0]
    private val tvshowId = dummyTvshow.tvshowId

    @Before
    fun setUp() {
        viewModel = DetailTvshowViewModel()
        viewModel.setSelectedTvshow(tvshowId)
    }

    @Test
    fun getMovie() {
        viewModel.setSelectedTvshow(dummyTvshow.tvshowId)
        val tvshowEntity = viewModel.getTvshow()
        assertNotNull(tvshowEntity)
        assertEquals(dummyTvshow.tvshowId, tvshowEntity.tvshowId)
        assertEquals(dummyTvshow.image, tvshowEntity.image)
        assertEquals(dummyTvshow.title, tvshowEntity.title)
        assertEquals(dummyTvshow.description, tvshowEntity.description)
        assertEquals(dummyTvshow.director, tvshowEntity.director)
        assertEquals(dummyTvshow.seasons, tvshowEntity.seasons)
        assertEquals(dummyTvshow.genre, tvshowEntity.genre)
        assertEquals(dummyTvshow.rating, tvshowEntity.rating)
        assertEquals(dummyTvshow.release, tvshowEntity.release)
        assertEquals(dummyTvshow.watchlist, tvshowEntity.watchlist)
    }
}