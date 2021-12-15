package com.dicoding.katonmoviecatalogue.ui.tvshows

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.databinding.ItemsTvshowBinding
import com.dicoding.katonmoviecatalogue.ui.detail.DetailTvshowActivity
import com.dicoding.katonmoviecatalogue.utils.ImagePathApi

class TvshowsAdapter(private val callback: TvshowsFragmentCallback): PagedListAdapter<TvshowEntity, TvshowsAdapter.TvshowsViewHolder>(DIFF_CALLBACK) {

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<TvshowEntity>() {
            override fun areItemsTheSame(oldItem: TvshowEntity, newItem: TvshowEntity): Boolean {
                return oldItem.tvshowId == newItem.tvshowId
            }

            override fun areContentsTheSame(oldItem: TvshowEntity, newItem: TvshowEntity): Boolean {
                return oldItem == newItem
            }
        }
    }

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
                tvRelease.text = tvshow.release
                tvRating.text = tvshow.rating.toString()
                itemView.setOnClickListener {
                    val intent = Intent(itemView.context, DetailTvshowActivity::class.java)
                    intent.putExtra(DetailTvshowActivity.EXTRA_TVSHOW, tvshow.tvshowId)
                    itemView.context.startActivity(intent)
                }
                imgShare.setOnClickListener { callback.onShareClick(tvshow) }

                tvshow.image.let { image ->
                    with(imgPoster){
                        ImagePathApi.setImage(
                            itemView.context,
                            ImagePathApi.API_IMAGE + ImagePathApi.IMAGE_SIZE + image,
                            imgPoster
                        )
                    }
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TvshowsViewHolder {
        val itemsTvshowBinding = ItemsTvshowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TvshowsViewHolder(itemsTvshowBinding)
    }

    override fun onBindViewHolder(holder: TvshowsViewHolder, position: Int) {
        val tvshow = getItem(position)
        if (tvshow != null) {
            holder.bind(tvshow)
        }
    }

    //override fun getItemCount(): Int = listTvshows.size
}