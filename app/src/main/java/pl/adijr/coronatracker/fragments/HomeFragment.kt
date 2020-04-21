package pl.adijr.coronatracker.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.navigation.findNavController
import androidx.navigation.fragment.navArgs
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.home_fragment.view.*
import pl.adijr.coronatracker.R

class HomeFragment : DaggerFragment() {

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
            tvTests.text = args.country.totalTests
            tvNewInfected.text = args.country.newCases.substring(1)
            tvNewDeaths.text = args.country.newDeaths.substring(1)

            if (args.country.totalCases == "") {
                tvTotalInfected.text = "N/A"
            }

            if (args.country.totalRecovered == "") {
                tvRecovered.text = "N/A"
            }

            if (args.country.totalDeaths == "") {
                tvDeaths.text = "N/A"
            }

            if (args.country.totalTests == "") {
                tvTests.text = "N/A"
            }

            if (args.country.country == "USA") {
                tvCountryName.text = context.getString(R.string.us)
            }

            if (args.country.country == "UK") {
                tvCountryName.text = context.getString(R.string.uk)
            }

            if (args.country.country == "UAE") {
                tvCountryName.text = context.getString(R.string.uae)
            }

            if (args.country.country == "ZEA") {
                tvCountryName.text = context.getString(R.string.uae)
            }

            if (args.country.country == "Bośnia") {
                tvCountryName.text = context.getString(R.string.bosnia)
            }

            if (args.country.country == "Bosnia") {
                tvCountryName.text = context.getString(R.string.bosnia)
            }

            if (args.country.country == "WKS") {
                tvCountryName.text = "Wybrzeże Kości Słoniowej"
            }

            fabSearch.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.toSearchFragment())
            }
            tvPrivacy.setOnClickListener {
                findNavController().navigate(HomeFragmentDirections.toPrivacyFragment())
            }
        }
    }
}