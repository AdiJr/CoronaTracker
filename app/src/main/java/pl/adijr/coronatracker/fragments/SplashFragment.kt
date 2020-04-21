package pl.adijr.coronatracker.fragments

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.android.support.DaggerFragment
import pl.adijr.coronatracker.R
import pl.adijr.coronatracker.viewmodels.SplashViewModel
import java.util.*
import javax.inject.Inject

class SplashFragment : DaggerFragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    private val viewModel by viewModels<SplashViewModel> { factory }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.splash_fragment, container, false).apply {
            with(viewModel) {
                if (checkInternetConnection(context)) {
                    fetchOnline()
                } else {
                    fetchOffline()
                }
                citiesList.observe(viewLifecycleOwner, Observer {
                    val worldStats = it[0]
                    if (Locale.getDefault().language == Locale("pl").language) {
                        worldStats.country = "Świat"
                    }
                    proceed.observe(viewLifecycleOwner, Observer {
                        findNavController().navigate(
                            SplashFragmentDirections.toHomeFragment(worldStats)
                        )
                    })
                })
            }
        }
    }

    private fun checkInternetConnection(context: Context): Boolean {
        val conManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return (conManager.activeNetworkInfo != null && conManager.activeNetworkInfo.isAvailable
                && conManager.activeNetworkInfo.isConnected)
    }
}