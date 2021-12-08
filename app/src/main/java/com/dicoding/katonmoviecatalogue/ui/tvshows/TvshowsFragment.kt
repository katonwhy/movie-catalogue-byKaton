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
            val viewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory())[TvshowsViewModel::class.java]
            val tvshows = viewModel.getTvshows()

            val tvshowsAdapter = TvshowsAdapter(this)
            tvshowsAdapter.setTvshows(tvshows)

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