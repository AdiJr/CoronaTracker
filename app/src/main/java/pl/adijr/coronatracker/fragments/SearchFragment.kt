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
import pl.adijr.coronatracker.viewmodels.SearchViewModel
import javax.inject.Inject

class SearchFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<SearchViewModel> { factory }

    private val citiesAdapter by lazy {
        CityAdapter {
            findNavController().navigate(SearchFragmentDirections.toHomeFragment(it))
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.search_fragment, container, false).apply {
            rvAvailableCountries.adapter = citiesAdapter

            with(viewModel) {
                getAllCities()
                citiesList.observe(viewLifecycleOwner, Observer {
                    val list = it.toMutableList()

                    for (i in list) {
                        if (i.country == "UK") {
                            i.country = "United Kingdom"
                        }
                        if (i.country == "S. Korea") {
                            i.country = "South Korea"
                        }
                        if (i.country == "UAE") {
                            i.country = "United Arab Emirates"
                        }
                        if (i.country == "USA") {
                            i.country = "United States of America"
                        }
                        if (i.newDeaths == "") {
                            i.newDeaths = "+N/A"
                        }
                        if (i.newCases == "") {
                            i.newCases = "+N/A"
                        }
                        if (i.country == "Czechia") {
                            i.country = "Czech Republic"
                        }
                    }
                    citiesAdapter.submitList(list.toList())
                })
            }
        }
    }
}