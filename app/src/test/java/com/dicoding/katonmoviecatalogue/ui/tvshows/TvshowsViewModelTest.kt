package com.dicoding.katonmoviecatalogue.ui.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.utils.DataDummy
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
    private lateinit var observer: Observer<List<TvshowEntity>>

    @Before
    fun setUp(){
        viewModel = TvshowsViewModel(movieRepository)
    }

    @Test
    fun getTvShows() {
        val dummyTv = DataDummy.generateDummyTvshows()
        val tv = MutableLiveData<List<TvshowEntity>>()
        tv.value = dummyTv

        Mockito.`when`(movieRepository.getAllTvShow()).thenReturn(tv)
        val tvShow = viewModel.getTvshows().value
        Mockito.verify(movieRepository).getAllTvShow()
        assertNotNull(tvShow)
        assertEquals(20, tvShow?.size)

        viewModel.getTvshows().observeForever(observer)
        Mockito.verify(observer).onChanged(dummyTv)
    }
}