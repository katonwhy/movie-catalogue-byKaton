package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
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
class DetailTvshowViewModelTest {
    private lateinit var viewModel: DetailTvshowViewModel
    private val dummyTvshow = DataDummy.generateDummyTvshows()[0]
    private val tvshowId = dummyTvshow.tvshowId

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<TvshowEntity>

    @Before
    fun setUp() {
        viewModel = DetailTvshowViewModel(movieRepository)
    }

    @Test
    fun getTvshow() {
        val tv = MutableLiveData<TvshowEntity>()
        tv.value = dummyTvshow

        `when`(movieRepository.getDetailTvShow(tvshowId)).thenReturn(tv)
        val tvShow = viewModel.getTvshow(tvshowId).value as TvshowEntity
        verify(movieRepository).getDetailTvShow(tvshowId)

        assertNotNull(tvShow)
        assertEquals(dummyTvshow.tvshowId, tvShow.tvshowId)
        assertEquals(dummyTvshow.image, tvShow.image)
        assertEquals(dummyTvshow.title, tvShow.title)
        assertEquals(dummyTvshow.description, tvShow.description)
        assertEquals(dummyTvshow.director, tvShow.director)
        assertEquals(dummyTvshow.seasons, tvShow.seasons)
        assertEquals(dummyTvshow.genre, tvShow.genre)
        assertEquals(dummyTvshow.rating, tvShow.rating, 0.1)
        assertEquals(dummyTvshow.release, tvShow.release)
        assertEquals(dummyTvshow.watchlist, tvShow.watchlist)

        viewModel.getTvshow(tvshowId).observeForever(observer)
        verify(observer).onChanged(dummyTvshow)
    }
}