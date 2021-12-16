package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.utils.DataDummy
import com.dicoding.katonmoviecatalogue.vo.Resource
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
    private lateinit var observer: Observer<Resource<TvshowEntity>>

    @Before
    fun setUp() {
        viewModel = DetailTvshowViewModel(movieRepository)
    }

    @Test
    fun getTvshow() {
        val dummyDetailTvshow = Resource.success(DataDummy.generateDummyTvshows()[0])
        val tvshow = MutableLiveData<Resource<TvshowEntity>>()
        tvshow.value = dummyDetailTvshow

        `when`(movieRepository.getDetailTvShow(tvshowId)).thenReturn(tvshow)

        viewModel.setFilm(tvshowId)

        viewModel.getTvshow().observeForever(observer)
        verify(observer).onChanged(dummyDetailTvshow)
    }
}