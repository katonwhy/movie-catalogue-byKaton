package com.dicoding.katonmoviecatalogue.ui.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.paging.PagedList
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.vo.Resource
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule

import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class TvshowsViewModelTest {
    private lateinit var viewModel: TvshowsViewModel

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Mock
    private lateinit var movieRepository: MovieRepository

    @Mock
    private lateinit var observer: Observer<Resource<PagedList<TvshowEntity>>>

    @Mock
    private lateinit var pagedList: PagedList<TvshowEntity>

    @Before
    fun setUp(){
        viewModel = TvshowsViewModel(movieRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTvShow = Resource.success(pagedList)
        Mockito.`when`(dummyTvShow.data?.size).thenReturn(20)
        val tvShows = MutableLiveData<Resource<PagedList<TvshowEntity>>>()
        tvShows.value = dummyTvShow

        Mockito.`when`(movieRepository.getAllTvShow()).thenReturn(tvShows)
        val tvShow = viewModel.getTvshows().value?.data
        Mockito.verify(movieRepository).getAllTvShow()
        assertNotNull(tvShow)
        assertEquals(20, tvShow?.size)

        viewModel.getTvshows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTvShow)
    }
}