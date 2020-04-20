package pl.adijr.coronatracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.home_fragment.view.*
import pl.adijr.coronatracker.R
import pl.adijr.coronatracker.viewmodels.HomeViewModel
import javax.inject.Inject

class HomeFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<HomeViewModel> { factory }
    private val args by navArgs<HomeFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        requireActivity().onBackPressedDispatcher.addCallback(
            this, object : OnBackPressedCallback(true) {
                override fun handleOnBackPressed() {
                    activity?.finish()
                }
            }
        )
        return inflater.inflate(R.layout.home_fragment, container, false).apply {

            tvCountryName.text = args.country.country
            tvRecovered.text = args.country.totalRecovered
            tvTotalInfected.text = args.country.totalCases
            tvDeaths.text = args.country.totalDeaths

            fabSearch.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.toSearchFragment())
            }
        }
    }
}