package com.riztech.financialtracker.presentation.home

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.airbnb.mvrx.Success
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.launcher.MavericksLauncherActivity
import com.airbnb.mvrx.mocking.MockableMavericksView
import com.airbnb.mvrx.mocking.mockSingleViewModel
import com.riztech.financialtracker.BuildConfig
import com.riztech.financialtracker.R
import com.riztech.financialtracker.databinding.FragmentHomeBinding
import com.riztech.financialtracker.domain.model.Genre
import com.riztech.financialtracker.domain.model.Movie
import com.riztech.financialtracker.presentation.generaladapter.MovieAdapter
import com.riztech.financialtracker.presentation.home.adapter.CategoryAdapter
import com.riztech.financialtracker.presentation.home.mock.mockHomeState
import com.riztech.financialtracker.viewBinding
import java.io.IOError
import java.io.IOException
import java.lang.Exception

//import dagger.hilt.android.AndroidEntryPoint


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
//@AndroidEntryPoint
class HomeFragment : Fragment(R.layout.fragment_home), MockableMavericksView {
    private val binding: FragmentHomeBinding by viewBinding()
    private val viewModel: HomeViewModel by fragmentViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerMockPrinter()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvSearch.setOnClickListener {
            val action = HomeFragmentDirections.goToSearch()
            it.findNavController().navigate(action)
        }

        binding.btCategories.setOnClickListener {
            val action = HomeFragmentDirections.goToCategories()
            it.findNavController().navigate(action)
        }

        binding.ivProfile.setOnClickListener {
            if (BuildConfig.DEBUG)
                startActivity(Intent(requireActivity(), MavericksLauncherActivity::class.java))
        }

        viewModel.onAsync(
            HomeState::categories,
            onFail = {
                Toast.makeText(requireContext(), "FAIL", Toast.LENGTH_LONG).show()
            },
            onSuccess = {
                populateListCategories(it)
            }
        )

        viewModel.onAsync(
            HomeState::movies,
            onFail = {
                Toast.makeText(requireContext(), "FAIL Movie", Toast.LENGTH_LONG).show()
            },
            onSuccess = {
                populateMovies(it)
            }
        )
    }

    fun populateListCategories(categories: List<Genre>){
        binding.rvCategories.apply {
            layoutManager = GridLayoutManager(requireContext(), 3)
            adapter = CategoryAdapter( if (categories.size > 6)  categories.slice(0..5) else categories )
        }
    }

    fun populateMovies(movies: List<Movie>){
        binding.rvPopular.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = MovieAdapter(movies){
                val action = HomeFragmentDirections.goToDetail(it)
                findNavController().navigate(action)
            }
        }
    }

    override fun invalidate() = Unit

    override fun provideMocks() = mockSingleViewModel(
        viewModelReference = HomeFragment::viewModel,
        defaultState = mockHomeState,
        defaultArgs = null
    ){
        state("Empty List") {
            copy( categories = Success(emptyList()))
        }
        stateForLoadingAndFailure { ::categories }
        stateForLoadingAndFailure { ::movies }
    }
}