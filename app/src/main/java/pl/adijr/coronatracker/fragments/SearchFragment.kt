package pl.adijr.coronatracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.search_fragment.view.*
import pl.adijr.coronatracker.R
import pl.adijr.coronatracker.adapters.CityAdapter
import pl.adijr.coronatracker.models.CityModel
import pl.adijr.coronatracker.viewmodels.SearchViewModel
import javax.inject.Inject

class SearchFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<SearchViewModel> { factory }

    private val citiesAdapter by lazy {
        CityAdapter {
            findNavController().navigate(SearchFragmentDirections.toHomeFragment())
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment, container, false).apply {

            viewModel.getAllCities()
            viewModel.citiesList.observe(viewLifecycleOwner, Observer {
                val list = mutableListOf<CityModel>()
                for (i in it) if (i.infected != null && i.deceased != null && i.recovered != null && i.infected != "NA" && i.deceased != "NA") {
                    list.add(i)
                }
                citiesAdapter.submitList(list)
            })
            rvAvailableCountries.adapter = citiesAdapter
        }
    }
}