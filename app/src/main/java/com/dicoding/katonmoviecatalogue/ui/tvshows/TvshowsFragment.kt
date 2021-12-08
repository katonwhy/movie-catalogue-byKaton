package com.dicoding.katonmoviecatalogue.ui.tvshows

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
import com.dicoding.katonmoviecatalogue.databinding.FragmentTvshowsBinding
import com.dicoding.katonmoviecatalogue.utils.ViewModelFactory

class TvshowsFragment : Fragment(), TvshowsFragmentCallback {

    private lateinit var fragmentTvshowsBinding: FragmentTvshowsBinding

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

            val tvshowsAdapter = TvshowsAdapter(this)

            fragmentTvshowsBinding.progressBar.visibility = View.VISIBLE
            viewModel.getTvshows().observe(viewLifecycleOwner, { movies ->
                fragmentTvshowsBinding.progressBar.visibility = View.GONE
                tvshowsAdapter.setTvshows(movies)
                tvshowsAdapter.notifyDataSetChanged()
            })

            with(fragmentTvshowsBinding.rvTvshows) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = tvshowsAdapter
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