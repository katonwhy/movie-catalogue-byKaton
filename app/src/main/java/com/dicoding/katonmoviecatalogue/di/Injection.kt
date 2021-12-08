package com.dicoding.katonmoviecatalogue.di

import android.content.Context
import com.dicoding.katonmoviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.katonmoviecatalogue.data.source.remote.repository.MovieRepository

object Injection {
    fun provideRepository(context: Context) : MovieRepository {
        val remoteDataSource = RemoteDataSource.getInstance()

        return MovieRepository.getInstace(remoteDataSource)
    }
}