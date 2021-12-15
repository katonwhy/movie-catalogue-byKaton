package com.dicoding.katonmoviecatalogue.ui.watchlist.movies

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
import com.dicoding.katonmoviecatalogue.data.source.local.entity.MovieEntity
import com.dicoding.katonmoviecatalogue.databinding.FragmentMoviesWatchlistBinding
import com.dicoding.katonmoviecatalogue.utils.ViewModelFactory
import com.google.android.material.snackbar.Snackbar

class MoviesWatchlistFragment : Fragment(), MoviesFragmentCallback {

    private lateinit var fragmentWatchlistMoviesBinding: FragmentMoviesWatchlistBinding
    private lateinit var moviesWatchlistAdapter: MovieWatchlistAdapter
    private lateinit var viewModel: MovieWatchlistViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        fragmentWatchlistMoviesBinding = FragmentMoviesWatchlistBinding.inflate(layoutInflater, container, false)
        return fragmentWatchlistMoviesBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemTouchHelper.attachToRecyclerView(fragmentWatchlistMoviesBinding?.rvMovies)

        if (activity != null) {
            val factory = ViewModelFactory.getInstance(requireActivity())
            viewModel = ViewModelProvider(this, factory)[MovieWatchlistViewModel::class.java]

            moviesWatchlistAdapter = MovieWatchlistAdapter(this)

            fragmentWatchlistMoviesBinding.progressBar.visibility = View.VISIBLE
            viewModel.getFavMovies().observe(viewLifecycleOwner, { favMovies ->
                if (favMovies != null) {
                    fragmentWatchlistMoviesBinding.progressBar.visibility = View.GONE
                    moviesWatchlistAdapter.submitList(favMovies)
                    moviesWatchlistAdapter.notifyDataSetChanged()
                }
            })

            with(fragmentWatchlistMoviesBinding.rvMovies) {
                layoutManager = LinearLayoutManager(context)
                setHasFixedSize(true)
                adapter = moviesWatchlistAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getFavMovies().observe(viewLifecycleOwner, { favMovies ->
            if (favMovies != null) {
                moviesWatchlistAdapter.submitList(favMovies)
            }
        })
    }

    override fun onShareClick(movie: MovieEntity) {
        if (activity != null) {
            val mimeType = "text/plain"
            ShareCompat.IntentBuilder
                .from(requireActivity())
                .setType(mimeType)
                .setText(resources.getString(R.string.share_text, movie.title))
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
                val movieEntity = moviesWatchlistAdapter.getSwipedData(swipedPosition)
                movieEntity?.let { viewModel.setFavMovie(it) }

                val snackBar = Snackbar.make(requireView(), R.string.delete_confirm, Snackbar.LENGTH_LONG)
                snackBar.setAction(R.string.undo) { _ ->
                    movieEntity?.let { viewModel.setFavMovie(it) }
                }
                snackBar.show()
            }
        }
    })

}