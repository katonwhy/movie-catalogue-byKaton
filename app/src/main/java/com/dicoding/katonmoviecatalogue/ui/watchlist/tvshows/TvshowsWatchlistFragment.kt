package com.dicoding.katonmoviecatalogue.ui.watchlist.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ShareCompat
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.databinding.FragmentTvshowsWatchlistBinding
import com.dicoding.katonmoviecatalogue.utils.ViewModelFactory

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
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[TvshowsWatchlistViewModel::class.java]

            tvshowsWatchlistAdapter = TvshowsWatchlistAdapter(this)

            fragmentWatchlistTvshowsBinding.progressBar.visibility = View.VISIBLE
            viewModel.getFavTvshows().observe(viewLifecycleOwner, { favTvshows ->
                if (favTvshows != null) {
                    fragmentWatchlistTvshowsBinding.progressBar.visibility = View.GONE
                    tvshowsWatchlistAdapter.setTvshows(favTvshows)
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
                tvshowsWatchlistAdapter.setTvshows(favTvshows)
            }
        })
    }

    override fun onShareClick(tvshow: TvshowEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setText(resources.getString(R.string.share_text_tvshow, tvshow.title))
                .startChooser()
        }
    }

}