package com.dicoding.katonmoviecatalogue.ui.watchlist.movies

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.databinding.ItemsMovieBinding
import com.dicoding.katonmoviecatalogue.ui.detail.DetailMovieActivity
import com.dicoding.katonmoviecatalogue.utils.ImagePathApi.API_IMAGE
import com.dicoding.katonmoviecatalogue.utils.ImagePathApi.IMAGE_SIZE
import com.dicoding.katonmoviecatalogue.utils.ImagePathApi.setImage

class MovieWatchlistAdapter(private val callback: MoviesFragmentCallback): PagedListAdapter<MovieEntity, MovieWatchlistAdapter.MovieViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<MovieEntity>() {
            override fun areItemsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem.movieId == newItem.movieId
            }

            override fun areContentsTheSame(oldItem: MovieEntity, newItem: MovieEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

    private var listMovies = ArrayList<MovieEntity>()

    fun setMovies(movies: List<MovieEntity>?) {
        if (movies == null) return
        this.listMovies.clear()
        this.listMovies.addAll(movies)
    }

    fun getSwipedData(swipedPosition: Int): MovieEntity? = getItem(swipedPosition)

    inner class MovieViewHolder(private val binding: ItemsMovieBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(movie: MovieEntity) {
            with(binding) {
                tvItemTitle.text = movie.title
                tvRelease.text = movie.release
                tvRating.text = movie.rating.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailMovieActivity::class.java)
                    intent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movie.movieId)
                    itemView.context.startActivity(intent)
                }

                imgShare.setOnClickListener { callback.onShareClick(movie) }

                movie.image.let { image ->
                    with(imgPoster){
                        setImage(itemView.context, API_IMAGE + IMAGE_SIZE + image, imgPoster)
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemsMovieBinding = ItemsMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(itemsMovieBinding)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movie = getItem(position)
        if (movie != null) {
            holder.bind(movie)
        }
    }

    //override fun getItemCount(): Int = listMovies.size
}