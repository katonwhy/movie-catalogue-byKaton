package com.dicoding.katonmoviecatalogue.ui.tvshows

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ShareCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import com.dicoding.katonmoviecatalogue.R
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.data.source.local.entity.TvshowEntity
import com.dicoding.katonmoviecatalogue.databinding.FragmentTvshowsBinding
import com.dicoding.katonmoviecatalogue.ui.movies.MoviesAdapter
import com.dicoding.katonmoviecatalogue.utils.ViewModelFactory
import com.dicoding.katonmoviecatalogue.vo.Resource
import com.dicoding.katonmoviecatalogue.vo.Status

class TvshowsFragment : Fragment(), TvshowsFragmentCallback {

    private lateinit var fragmentTvshowsBinding: FragmentTvshowsBinding
    private lateinit var tvshowsAdapter: TvshowsAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentTvshowsBinding = FragmentTvshowsBinding.inflate(layoutInflater, container, false)
        return fragmentTvshowsBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            val viewModel = ViewModelProvider(this, factory)[TvshowsViewModel::class.java]

            tvshowsAdapter = TvshowsAdapter(this)

            fragmentTvshowsBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTvshows().observe(viewLifecycleOwner, tvShowObserver)

            with(fragmentTvshowsBinding.rvTvshows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvshowsAdapter
            }
        }
    }

    private val tvShowObserver = Observer<Resource<PagedList<TvshowEntity>>> { tvShows ->
        if (tvShows != null) {
            when (tvShows.status) {
                Status.LOADING -> fragmentTvshowsBinding.progressBar.visibility = View.VISIBLE
                Status.SUCCESS -> {
                    fragmentTvshowsBinding.progressBar.visibility = View.GONE
                    tvshowsAdapter.submitList(tvShows.data)
                    //moviesAdapter.setOnItemClickCallback(this)
                    tvshowsAdapter.notifyDataSetChanged()
                }
                Status.ERROR -> {
                    fragmentTvshowsBinding.progressBar.visibility = View.GONE
                    Toast.makeText(context, "Terjadi kesalahan", Toast.LENGTH_SHORT).show()
                }
            }
        }
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