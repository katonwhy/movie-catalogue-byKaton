package com.dicoding.katonmoviecatalogue.ui.detail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.databinding.ActivityDetailTvshowBinding
import com.dicoding.katonmoviecatalogue.databinding.ContentDetailTvshowBinding

class DetailTvshowActivity : AppCompatActivity() {

    private lateinit var contentDetailTvshowBinding: ContentDetailTvshowBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityDetailTvshowBinding =ActivityDetailTvshowBinding.inflate(layoutInflater)
        contentDetailTvshowBinding = activityDetailTvshowBinding.detailContent
        setContentView(activityDetailTvshowBinding.root)

        setSupportActionBar(activityDetailTvshowBinding.toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[DetailTvshowViewModel::class.java]

        val extras = intent.extras
        if (extras != null) {
            val tvshowId = extras.getString(DetailTvshowActivity.EXTRA_TVSHOW)
            if (tvshowId != null) {
                viewModel.setSelectedTvshow(tvshowId)
                populateMovie(viewModel.getTvshow())
            }
        }
    }

    private fun populateMovie(tvshowEntity: TvshowEntity) {
        contentDetailTvshowBinding.tvTitle.text = tvshowEntity.title
        contentDetailTvshowBinding.tvGenre.text = tvshowEntity.genre
        contentDetailTvshowBinding.tvSeasons.text = tvshowEntity.seasons
        contentDetailTvshowBinding.tvDirector.text = tvshowEntity.director
        contentDetailTvshowBinding.tvRelease.text = tvshowEntity.release
        contentDetailTvshowBinding.tvRating.text = tvshowEntity.rating
        contentDetailTvshowBinding.tvDescription.text = tvshowEntity.description

        Glide.with(this)
            .load(tvshowEntity.image)
            .transform(RoundedCorners(40))
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error))
            .into(contentDetailTvshowBinding.ivTvshowPoster)
    }

    companion object {
        const val EXTRA_TVSHOW = "extra_tvshow"
    }
}