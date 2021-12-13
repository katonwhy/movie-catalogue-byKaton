package com.dicoding.katonmoviecatalogue.di

import android.content.Context
import com.dicoding.katonmoviecatalogue.data.source.remote.RemoteDataSource
import com.dicoding.katonmoviecatalogue.data.repository.MovieRepository
import com.dicoding.katonmoviecatalogue.data.source.local.LocalDataSource
import com.dicoding.katonmoviecatalogue.data.source.local.room.FilmDatabase
import com.dicoding.katonmoviecatalogue.utils.AppExecutors

object Injection {
    fun provideRepository(context: Context) : MovieRepository {
        val database = FilmDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.filmDao())
        val appExecutors = AppExecutors()

        return MovieRepository.getInstace(remoteDataSource, localDataSource, appExecutors)
    }
}