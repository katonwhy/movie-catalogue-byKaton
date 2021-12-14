package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.databinding.ActivityDetailMovieBinding
import com.dicoding.katonmoviecatalogue.databinding.ContentDetailMovieBinding
import com.dicoding.katonmoviecatalogue.utils.ImagePathApi
import com.dicoding.katonmoviecatalogue.utils.ImagePathApi.API_IMAGE
import com.dicoding.katonmoviecatalogue.utils.ImagePathApi.IMAGE_SIZE
import com.dicoding.katonmoviecatalogue.utils.ViewModelFactory
import com.dicoding.katonmoviecatalogue.vo.Status

class DetailMovieActivity : AppCompatActivity() {

    private lateinit var contentDetailMovieBinding: ContentDetailMovieBinding
    private lateinit var activityDetailMovieBinding: ActivityDetailMovieBinding
    private lateinit var viewModel: DetailMovieViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailMovieBinding = ActivityDetailMovieBinding.inflate(layoutInflater)
        contentDetailMovieBinding = activityDetailMovieBinding.detailContent
        setContentView(activityDetailMovieBinding.root)

        setSupportActionBar(activityDetailMovieBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailMovieViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val movieId = extras.getInt(EXTRA_MOVIE, 0)

            if (movieId != null) {
                viewModel.setFilm(movieId)

                viewModel.getMovie().observe(this, { detail ->
                    when (detail.status) {
                        Status.LOADING -> showProgressBar()

                        Status.SUCCESS -> {
                            if (detail.data != null) {
                                hideProgressBar()
                                //populate detail page
                                populateMovie(detail.data)

                                //check status of favorite data, true or false
                                val state = detail.data.watchlist

                                //set Favorite Toggle to data condition if true -> Red-heart vice versa
                                setFavoriteState(state)

                                //change data when FavToggle is pressed
                                onToggleFavoriteClicked(state)
                            }
                        }
                        Status.ERROR -> {
                            showProgressBar()
                            Toast.makeText(applicationContext, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                        }
                    }
                })
            }
        }

    }

    private fun populateMovie(movieEntity: MovieEntity) {
        with(contentDetailMovieBinding){

            tvTitle.text = movieEntity.title
            tvGenre.text = movieEntity.genre
            tvRelease.text = movieEntity.release
            tvRating.text = movieEntity.rating.toString()
            tvDescription.text = movieEntity.description

            val hourDuration : Int = movieEntity.duration / 60
            val minutesDuration = movieEntity.duration % 60

            tvDuration.text = resources.getString(R.string.duration, hourDuration.toString(), minutesDuration.toString())

            ImagePathApi.setImageDetail(this@DetailMovieActivity, API_IMAGE + IMAGE_SIZE + movieEntity.image, ivMoviePoster)

        }
    }

    private fun setFavoriteState(state: Boolean) {
        contentDetailMovieBinding.toggleFavorite.isChecked = state
    }

    private fun onToggleFavoriteClicked(state: Boolean){
        contentDetailMovieBinding.toggleFavorite.setOnClickListener {
            viewModel.setFavoriteMovie()

            if (state){
                Toast.makeText(this, " Deleted from Watchlist", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, " Success added to Watchlist", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showProgressBar() {
        activityDetailMovieBinding.progressBar.visibility = View.VISIBLE
        activityDetailMovieBinding.content.visibility = View.INVISIBLE
    }

    private fun hideProgressBar() {
        activityDetailMovieBinding.progressBar.visibility = View.GONE
        activityDetailMovieBinding.content.visibility = View.VISIBLE
    }

    companion object {
        const val EXTRA_MOVIE = "extra_movie"
    }
}
