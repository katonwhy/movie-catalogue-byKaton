package com.dicoding.katonmoviecatalogue.ui.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.data.MovieEntity
import com.dicoding.katonmoviecatalogue.databinding.ItemsMovieBinding
import com.dicoding.katonmoviecatalogue.ui.detail.DetailMovieActivity

class MoviesAdapter(private val callback: MoviesFragmentCallback): RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {
    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    inner class MovieViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvItemGenre.text = movie.genre
                tvDuration.text = movie.duration
                tvRelease.text = movie.release
                tvRating.text = movie.rating
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(movie) }
                Glide.with(itemView.context)
                    .load(movie.image)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                        .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = listMovies[position]
        holder.bind(movie)
    }

    override fun getItemCount(): Int = listMovies.size
}