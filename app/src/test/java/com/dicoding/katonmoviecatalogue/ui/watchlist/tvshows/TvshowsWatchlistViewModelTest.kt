package com.dicoding.katonmoviecatalogue.ui.watchlist.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.utils.DataDummy
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.verifyNoMoreInteractions
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvshowsWatchlistViewModelTest {
    private lateinit var viewModel: TvshowsWatchlistViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<PagedList<TvshowEntity>>

    @Mock
    private lateinit var pagedList: PagedList<TvshowEntity>

    @Before
    fun setUp() {
        viewModel = TvshowsWatchlistViewModel(movieRepository)
    }

    @Test
    fun getFavTvshows() {
        val dummyTvShow = pagedList
        Mockito.`when`(dummyTvShow.size).thenReturn(3)
        val tvShows = MutableLiveData<PagedList<TvshowEntity>>()
        tvShows.value = dummyTvShow

        Mockito.`when`(movieRepository.getFavoriteTvShows()).thenReturn(tvShows)
        val tvShow = viewModel.getFavTvshows().value
        verify(movieRepository).getFavoriteTvShows()
        assertNotNull(tvShow)
        assertEquals(3, tvShow?.size)

        viewModel.getFavTvshows().observeForever(observer)
        verify(observer).onChanged(dummyTvShow)
    }

    @Test
    fun setFavMovie() {
        viewModel.setFavTvshows(DataDummy.generateDummyTvshows()[0])
        verify(movieRepository).setFavoriteTvShow(DataDummy.generateDummyTvshows()[0], true)
        verifyNoMoreInteractions(movieRepository)
    }
}