package com.dicoding.katonmoviecatalogue.ui.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.databinding.ItemsTvshowBinding
import com.dicoding.katonmoviecatalogue.ui.detail.DetailTvshowActivity

class TvshowsAdapter(private val callback: TvshowsFragmentCallback): RecyclerView.Adapter<TvshowsAdapter.TvshowsViewHolder>() {
    private var listTvshows = ArrayList<TvshowEntity>()

    fun setTvshows(tvshows: List<TvshowEntity>?) {
        if (tvshows == null) return
        this.listTvshows.clear()
        this.listTvshows.addAll(tvshows)
    }

    inner class TvshowsViewHolder(private val binding: ItemsTvshowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(tvshow: TvshowEntity) {
            with(binding) {
                tvItemTitle.text = tvshow.title
                tvItemGenre.text = tvshow.genre
                tvRelease.text = tvshow.release
                tvSeasons.text = tvshow.seasons
                tvRating.text = tvshow.rating
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvshowActivity::class.java)
                    intent.putExtra(DetailTvshowActivity.EXTRA_TVSHOW, tvshow.tvshowId)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(tvshow) }
                Glide.with(itemView.context)
                    .load(tvshow.image)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading)
                            .error(R.drawable.ic_error))
                    .into(imgPoster)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowsViewHolder {
        val itemsTvshowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvshowsViewHolder(itemsTvshowBinding)
    }

    override fun onBindViewHolder(holder: TvshowsViewHolder, position: Int) {
        val tvshow = listTvshows[position]
        holder.bind(tvshow)
    }

    override fun getItemCount(): Int = listTvshows.size
}