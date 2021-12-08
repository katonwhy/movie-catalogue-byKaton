package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.databinding.ActivityDetailMovieBinding
import com.dicoding.katonmoviecatalogue.databinding.ContentDetailMovieBinding

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var contentDetailMovieBinding: ContentDetailMovieBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        contentDetailMovieBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getString(EXTRA_MOVIE)
            if (movieId != null) {
                viewModel.setSelectedMovie(movieId)
                populateMovie(viewModel.getMovie())
            }
        }
    }

    private fun populateMovie(movieEntity: MovieEntity) {
        contentDetailMovieBinding.tvTitle.text = movieEntity.title
        contentDetailMovieBinding.tvGenre.text = movieEntity.genre
        contentDetailMovieBinding.tvDuration.text = movieEntity.duration
        contentDetailMovieBinding.tvDirector.text = movieEntity.director
        contentDetailMovieBinding.tvRelease.text = movieEntity.release
        contentDetailMovieBinding.tvRating.text = movieEntity.rating
        contentDetailMovieBinding.tvDescription.text = movieEntity.description

        Glide.with(this)
            .load(movieEntity.image)
            .transform(RoundedCorners(40))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(contentDetailMovieBinding.ivMoviePoster)
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
}
