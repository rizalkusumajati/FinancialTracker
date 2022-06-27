package com.riztech.financialtracker.presentation.detail

import android.os.Bundle
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.mocking.MavericksViewMocks
import com.airbnb.mvrx.mocking.MockableMavericksView
import com.airbnb.mvrx.mocking.mockSingleViewModel
import com.riztech.financialtracker.R
import com.riztech.financialtracker.databinding.FragmentDetailBinding
import com.riztech.financialtracker.domain.model.Movie
import com.riztech.financialtracker.presentation.detail.mock.mockDetailState
import com.riztech.financialtracker.presentation.home.mock.basePoster
import com.riztech.financialtracker.viewBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [DetailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

class DetailFragment : Fragment(R.layout.fragment_detail), MockableMavericksView {
    // TODO: Rename and change types of parameters
    var args: Movie? = null //DetailFragmentArgs by navArgs()
    private val viewModel: DetailViewModel by fragmentViewModel()
    private val binding: FragmentDetailBinding by viewBinding()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerMockPrinter()
        args = arguments?.getParcelable("movie")
    }

    override fun provideMocks() = mockSingleViewModel(
        viewModelReference = DetailFragment::viewModel,
        defaultState = mockDetailState,
        defaultArgs = Movie(
            id = 338953,
            title = "Fantastic Beasts: The Secrets of Dumbledore",
            rating = (6.8 - 5).toInt(),
            poster = basePoster + "/jrgifaYeUtTnaH7NF5Drkgjg2MB.jpg"
        )
    ){
        stateForLoadingAndFailure { ::movie }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onAsync(
            asyncProp = DetailState::movie,
            onFail = {

            },
            onSuccess = {
                binding.ivPoster.load(it.poster)
                binding.tvTitle.text = it.title
                binding.tvOverview.text = it.overview
            }
        )
        args?.let {
            viewModel.getDetail(it)
        }


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment DetailFragment.
         */
        // TODO: Rename and change types and number of parameters
//        @JvmStatic
//        fun newInstance(movie: Movie) =
//            DetailFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_PARAM1, param1)
//                }
//            }
    }

    override fun invalidate() = Unit
}