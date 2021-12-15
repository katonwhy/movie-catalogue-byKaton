package com.dicoding.katonmoviecatalogue.ui.watchlist.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.databinding.FragmentTvshowsWatchlistBinding
import com.dicoding.katonmoviecatalogue.utils.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class TvshowsWatchlistFragment : Fragment(), TvshowsFragmentCallback {

    private lateinit var fragmentWatchlistTvshowsBinding: FragmentTvshowsWatchlistBinding
    private lateinit var tvshowsWatchlistAdapter: TvshowsWatchlistAdapter
    private lateinit var viewModel: TvshowsWatchlistViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentWatchlistTvshowsBinding = FragmentTvshowsWatchlistBinding.inflate(layoutInflater, container, false)
        return fragmentWatchlistTvshowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(fragmentWatchlistTvshowsBinding?.rvTvshows)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvshowsWatchlistViewModel::class.java]

            tvshowsWatchlistAdapter = TvshowsWatchlistAdapter(this)

            fragmentWatchlistTvshowsBinding.progressBar.visibility = View.VISIBLE
            viewModel.getFavTvshows().observe(viewLifecycleOwner, { favTvshows ->
                if (favTvshows != null) {
                    fragmentWatchlistTvshowsBinding.progressBar.visibility = View.GONE
                    tvshowsWatchlistAdapter.submitList(favTvshows)
                    tvshowsWatchlistAdapter.notifyDataSetChanged()
                }
            })

            with(fragmentWatchlistTvshowsBinding.rvTvshows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvshowsWatchlistAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavTvshows().observe(viewLifecycleOwner, { favTvshows ->
            if (favTvshows != null) {
                tvshowsWatchlistAdapter.submitList(favTvshows)
            }
        })
    }

    override fun onShareClick(tvShow: TvshowEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setText(resources.getString(R.string.share_text_tvshow, tvShow.title))
                .startChooser()
        }
    }

    private val itemTouchHelper = ItemTouchHelper(object : ItemTouchHelper.Callback() {
        override fun getMovementFlags(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder): Int =
            makeMovementFlags(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT)

        override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean = true

        override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
            if (view != null) {
                val swipedPosition = viewHolder.adapterPosition
                val tvShowEntity = tvshowsWatchlistAdapter.getSwipedData(swipedPosition)
                tvShowEntity?.let { viewModel.setFavTvshows(it) }

                val snackBar = Snackbar.make(requireView(), R.string.delete_confirm, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.undo) { _ ->
                    tvShowEntity?.let { viewModel.setFavTvshows(it) }
                }
                snackBar.show()
            }
        }
    })

}