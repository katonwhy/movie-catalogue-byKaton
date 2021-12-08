package com.dicoding.katonmoviecatalogue.utils

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.katonmoviecatalogue.R
import jp.wasabeef.glide.transformations.RoundedCornersTransformation

object ImagePathApi {
    const val API_IMAGE = "https://image.tmdb.org/t/p/"
    const val IMAGE_SIZE = "w500"

    fun setImage(context: Context, imagePath : String, imageView: ImageView){
        Glide.with(context).clear(imageView)
        Glide.with(context)
            .load(imagePath)
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(imageView)
    }

    fun setImageDetail(context: Context, imagePath: String, imageView: ImageView){
        Glide.with(context).clear(imageView)
        Glide.with(context)
            .load(imagePath)
            .transform(RoundedCornersTransformation(30, 0))
            .apply(RequestOptions.placeholderOf(R.drawable.ic_loading)
                .error(R.drawable.ic_error))
            .into(imageView)
    }
}