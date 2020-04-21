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
import java.util.*
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
                        if (i.country == "S. Korea") {
                            i.country = "South Korea"
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
                        if (i.country == "Bosnia and Herzegovina") {
                            i.country = "Bosnia"
                        }

                        if (Locale.getDefault().language == Locale("pl").language) {
                            if (i.country == "World") {
                                i.country = "Świat"
                            }
                            if (i.country == "Spain") {
                                i.country = "Hiszpania"
                            }
                            if (i.country == "Italy") {
                                i.country = "Włochy"
                            }
                            if (i.country == "France") {
                                i.country = "Francja"
                            }
                            if (i.country == "Germany") {
                                i.country = "Niemcy"
                            }
                            if (i.country == "United Kingdom") {
                                i.country = "UK"
                            }
                            if (i.country == "Turkey") {
                                i.country = "Turcja"
                            }
                            if (i.country == "China") {
                                i.country = "Chiny"
                            }
                            if (i.country == "Russia") {
                                i.country = "Rosja"
                            }
                            if (i.country == "Belgium") {
                                i.country = "Belgia"
                            }
                            if (i.country == "Brazil") {
                                i.country = "Brazylia"
                            }
                            if (i.country == "Canada") {
                                i.country = "Kanada"
                            }
                            if (i.country == "Netherlands") {
                                i.country = "Niderlandy"
                            }
                            if (i.country == "Switzerland") {
                                i.country = "Szwajcaria"
                            }
                            if (i.country == "Portugal") {
                                i.country = "Portugalia"
                            }
                            if (i.country == "India") {
                                i.country = "Indie"
                            }
                            if (i.country == "Ireland") {
                                i.country = "Irlandia"
                            }
                            if (i.country == "Sweden") {
                                i.country = "Szwecja"
                            }
                            if (i.country == "Israel") {
                                i.country = "Izrael"
                            }
                            if (i.country == "Saudi Arabia") {
                                i.country = "Arabia Saudyjska"
                            }
                            if (i.country == "Japan") {
                                i.country = "Japonia"
                            }
                            if (i.country == "South Korea") {
                                i.country = "Korea Południowa"
                            }
                            if (i.country == "Ecuador") {
                                i.country = "Ekwador"
                            }
                            if (i.country == "Poland") {
                                i.country = "Polska"
                            }
                            if (i.country == "Romania") {
                                i.country = "Rumunia"
                            }
                            if (i.country == "Singapore") {
                                i.country = "Singapur"
                            }
                            if (i.country == "Mexico") {
                                i.country = "Meksyk"
                            }
                            if (i.country == "UAE") {
                                i.country = "ZEA"
                            }
                            if (i.country == "Denmark") {
                                i.country = "Dania"
                            }
                            if (i.country == "Norway") {
                                i.country = "Norwegia"
                            }
                            if (i.country == "Indonesia") {
                                i.country = "Indonezja"
                            }
                            if (i.country == "Czech Republic") {
                                i.country = "Czechy"
                            }
                            if (i.country == "Philippines") {
                                i.country = "Filipiny"
                            }
                            if (i.country == "Qatar") {
                                i.country = "Katar"
                            }
                            if (i.country == "Belarus") {
                                i.country = "Białoruś"
                            }
                            if (i.country == "Ukraine") {
                                i.country = "Ukraina"
                            }
                            if (i.country == "Malaysia") {
                                i.country = "Malezja"
                            }
                            if (i.country == "Dominican Republic") {
                                i.country = "Dominikana"
                            }
                            if (i.country == "Finland") {
                                i.country = "Finlandia"
                            }
                            if (i.country == "Colombia") {
                                i.country = "Kolumbia"
                            }
                            if (i.country == "Luxembourg") {
                                i.country = "Luksemburg"
                            }
                            if (i.country == "Egypt") {
                                i.country = "Egipt"
                            }
                            if (i.country == "South Africa") {
                                i.country = "RPA"
                            }
                            if (i.country == "Morocco") {
                                i.country = "Maroko"
                            }
                            if (i.country == "Argentina") {
                                i.country = "Argentyna"
                            }
                            if (i.country == "Thailand") {
                                i.country = "Tajlandia"
                            }
                            if (i.country == "Algeria") {
                                i.country = "Algieria"
                            }
                            if (i.country == "Moldova") {
                                i.country = "Mołdawia"
                            }
                            if (i.country == "Greece") {
                                i.country = "Grecja"
                            }
                            if (i.country == "Hungary") {
                                i.country = "Węgry"
                            }
                            if (i.country == "Kuwait") {
                                i.country = "Kuwejt"
                            }
                            if (i.country == "Kazakhstan") {
                                i.country = "Kazachstan"
                            }
                            if (i.country == "Croatia") {
                                i.country = "Chorwacja"
                            }
                            if (i.country == "Iceland") {
                                i.country = "Islandia"
                            }
                            if (i.country == "Iraq") {
                                i.country = "Irak"
                            }
                            if (i.country == "Azerbaijan") {
                                i.country = "Azerbejdżan"
                            }
                            if (i.country == "New Zealand") {
                                i.country = "Nowa Zelandia"
                            }
                            if (i.country == "Lithuania") {
                                i.country = "Litwa"
                            }
                            if (i.country == "Slovenia") {
                                i.country = "Słowenia"
                            }
                            if (i.country == "Bosnia") {
                                i.country = "Bośnia"
                            }
                            if (i.country == "North Macedonia") {
                                i.country = "Północna Macedonia"
                            }
                            if (i.country == "Slovakia") {
                                i.country = "Słowacja"
                            }
                            if (i.country == "Cameroon") {
                                i.country = "Kamerun"
                            }
                            if (i.country == "Afghanistan") {
                                i.country = "Afganistan"
                            }
                            if (i.country == "Cuba") {
                                i.country = "Kuba"
                            }
                            if (i.country == "Bulgaria") {
                                i.country = "Bułgaria"
                            }
                            if (i.country == "Tunisia") {
                                i.country = "Tunezja"
                            }
                            if (i.country == "Ivory Coast") {
                                i.country = "WKS"
                            }
                            if (i.country == "Cyprus") {
                                i.country = "Cypr"
                            }
                            if (i.country == "Latvia") {
                                i.country = "Łotwa"
                            }
                            if (i.country == "Guinea") {
                                i.country = "Gwinea"
                            }
                            if (i.country == "Costa Rica") {
                                i.country = "Kostaryka"
                            }
                            if (i.country == "Bolivia") {
                                i.country = "Boliwia"
                            }
                            if (i.country == "Kyrgystan") {
                                i.country = "Kirgistan"
                            }
                            if (i.country == "Uruguay") {
                                i.country = "Urugwaj"
                            }
                            if (i.country == "Palestine") {
                                i.country = "Palestyna"
                            }
                            if (i.country == "Jordan") {
                                i.country = "Jordania"
                            }
                            if (i.country == "Taiwan") {
                                i.country = "Tajwan"
                            }
                            if (i.country == "Georgia") {
                                i.country = "Gruzja"
                            }
                            if (i.country == "Montenegro") {
                                i.country = "Czarnogóra"
                            }
                            if (i.country == "Kenya") {
                                i.country = "Kenia"
                            }
                            if (i.country == "Guatemala") {
                                i.country = "Gwatemala"
                            }
                            if (i.country == "Venezuela") {
                                i.country = "Wenezuela"
                            }
                            if (i.country == "Vietnam") {
                                i.country = "Wietnam"
                            }
                            if (i.country == "El Salvador") {
                                i.country = "Salwador"
                            }
                            if (i.country == "Jamaica") {
                                i.country = "Jamajka"
                            }
                            if (i.country == "Paraguay") {
                                i.country = "Paragwaj"
                            }
                            if (i.country == "Martinique") {
                                i.country = "Martynika"
                            }
                            if (i.country == "Congo") {
                                i.country = "Kongo"
                            }
                            if (i.country == "Guadeloupe") {
                                i.country = "Gwadelupa"
                            }
                            if (i.country == "Cambodia") {
                                i.country = "Kambodża"
                            }
                            if (i.country == "Madagascar") {
                                i.country = "Madagaskar"
                            }
                            if (i.country == "Myanmar") {
                                i.country = "Birma"
                            }
                            if (i.country == "Tinidad and Tobago") {
                                i.country = "Trynidad i Tobago"
                            }
                            if (i.country == "Ethiopia") {
                                i.country = "Etiopia"
                            }
                            if (i.country == "French Guiana") {
                                i.country = "Gujana Francuska"
                            }
                            if (i.country == "Monaco") {
                                i.country = "Monako"
                            }
                            if (i.country == "Bermuda") {
                                i.country = "Bermudy"
                            }
                            if (i.country == "Maldives") {
                                i.country = "Malediwy"
                            }
                            if (i.country == "Bahamas") {
                                i.country = "Wyspy Bahama"
                            }
                            if (i.country == "French Polynesia") {
                                i.country = "Polinezja Francuska"
                            }
                            if (i.country == "Libya") {
                                i.country = "Libia"
                            }
                            if (i.country == "Eritrea") {
                                i.country = "Erytrea"
                            }
                            if (i.country == "Mozambique") {
                                i.country = "Mozambik"
                            }
                            if (i.country == "Chad") {
                                i.country = "Czad"
                            }
                            if (i.country == "Antigua and Barbuda") {
                                i.country = "Antigua i Barbuda"
                            }
                            if (i.country == "Turks and Caicos") {
                                i.country = "Turks i Caicos"
                            }
                            if (i.country == "Falkland Island") {
                                i.country = "Falklandy"
                            }
                            if (i.country == "Greenland") {
                                i.country = "Grenlandia"
                            }
                            if (i.country == "Seychelles") {
                                i.country = "Seszele"
                            }
                            if (i.country == "Nicaragua") {
                                i.country = "Nikaragua"
                            }
                            if (i.country == "Vatican City") {
                                i.country = "Watykan"
                            }
                            if (i.country == "Mauritania") {
                                i.country = "Mauretania"
                            }
                            if (i.country == "Papua New Guinea") {
                                i.country = "Papua Nowa Gwinea"
                            }
                            if (i.country == "Western Sahara") {
                                i.country = "Sahara Zachodnia"
                            }
                            if (i.country == "British Virgin Island") {
                                i.country = "Wyspy Dziewicze"
                            }
                            if (i.country == "Caribbean Netherlands") {
                                i.country = "Karaiby"
                            }
                            if (i.country == "Sao Tome and Principe") {
                                i.country = "Sao Tome i Principe"
                            }
                            if (i.country == "South Sudan") {
                                i.country = "Południowy Sudan"
                            }
                            if (i.country == "Yemen") {
                                i.country = "Jemen"
                            }
                        }
                    }
                    citiesAdapter.submitList(list.toList())
                })
            }
        }
    }
}