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

class DetailTvshowActivity : AppCompatActivity() {

    private lateinit var contentDetailTvshowBinding: ContentDetailTvshowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailTvshowBinding =ActivityDetailTvshowBinding.inflate(layoutInflater)
        contentDetailTvshowBinding = activityDetailTvshowBinding.detailContent
        setContentView(activityDetailTvshowBinding.root)

        setSupportActionBar(activityDetailTvshowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val factory = ViewModelFactory.getInstance(this)
        val viewModel = ViewModelProvider(this, factory)[DetailTvshowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvshowId = extras.getInt(EXTRA_TVSHOW, 0)
            if (tvshowId != null) {

                activityDetailTvshowBinding.progressBar.visibility = View.VISIBLE
                activityDetailTvshowBinding.content.visibility = View.INVISIBLE

                viewModel.getTvshow(tvshowId).observe(this, {

                    activityDetailTvshowBinding.progressBar.visibility = View.GONE
                    activityDetailTvshowBinding.content.visibility = View.VISIBLE

                    populateMovie(it)
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

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }
}