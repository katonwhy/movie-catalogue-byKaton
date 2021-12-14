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
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.databinding.ActivityDetailTvshowBinding
import com.dicoding.katonmoviecatalogue.databinding.ContentDetailTvshowBinding
import com.dicoding.katonmoviecatalogue.utils.ImagePathApi
import com.dicoding.katonmoviecatalogue.utils.ViewModelFactory
import com.dicoding.katonmoviecatalogue.vo.Status

class DetailTvshowActivity : AppCompatActivity() {

    private lateinit var contentDetailTvshowBinding: ContentDetailTvshowBinding
    private lateinit var activityDetailTvshowBinding: ActivityDetailTvshowBinding
    private lateinit var viewModel: DetailTvshowViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityDetailTvshowBinding =ActivityDetailTvshowBinding.inflate(layoutInflater)
        contentDetailTvshowBinding = activityDetailTvshowBinding.detailContent
        setContentView(activityDetailTvshowBinding.root)

        setSupportActionBar(activityDetailTvshowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        viewModel = ViewModelProvider(this, factory)[DetailTvshowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvshowId = extras.getInt(EXTRA_TVSHOW, 0)

            if (tvshowId != null) {
                viewModel.setFilm(tvshowId)

                viewModel.getTvshow().observe(this, { detail ->
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

        contentDetailTvshowBinding.toggleFavorite.setOnClickListener {
            Toast.makeText(this, "Success add to Favorite", Toast.LENGTH_SHORT).show()
        }
    }

    private fun populateMovie(tvshowEntity: TvshowEntity) {
        with(contentDetailTvshowBinding){

            tvTitle.text = tvshowEntity.title
            tvGenre.text = tvshowEntity.genre
            tvSeasons.text = resources.getString(R.string.seasons, tvshowEntity.seasons.toString())
            tvRelease.text = tvshowEntity.release
            tvRating.text = tvshowEntity.rating.toString()
            tvDescription.text = tvshowEntity.description

            ImagePathApi.setImageDetail(this@DetailTvshowActivity, ImagePathApi.API_IMAGE + ImagePathApi.IMAGE_SIZE + tvshowEntity.image, ivTvshowPoster)
        }
    }

    private fun setFavoriteState(state: Boolean) {
        contentDetailTvshowBinding.toggleFavorite.isChecked = state
    }

    private fun onToggleFavoriteClicked(state: Boolean){
        contentDetailTvshowBinding.toggleFavorite.setOnClickListener {
            viewModel.setFavoriteTvShow()

            if (state){
                Toast.makeText(this, " Deleted from Watchlist", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, " Success added to Watchlist", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun showProgressBar() {
        activityDetailTvshowBinding.progressBar.visibility = View.VISIBLE
        activityDetailTvshowBinding.content.visibility = View.INVISIBLE
    }

    private fun hideProgressBar() {
        activityDetailTvshowBinding.progressBar.visibility = View.GONE
        activityDetailTvshowBinding.content.visibility = View.VISIBLE
    }

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }
}