package pl.adijr.coronatracker.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.adijr.coronatracker.models.CityModel
import pl.adijr.coronatracker.repository.Repository
import javax.inject.Inject

class SearchViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    val citiesList = MutableLiveData<List<CityModel>>()

    fun getCountryStats(country: String) {
        viewModelScope.launch {
            repository.getCountryStats(country)
        }
    }

    fun getAllCities() {
        viewModelScope.launch {
            val result = repository.getAllCities()
            citiesList.postValue(result.toList())
        }
    }
}