package pl.adijr.coronatracker.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import pl.adijr.coronatracker.models.Table
import pl.adijr.coronatracker.repository.Repository
import javax.inject.Inject

class SearchViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    val citiesList = MutableLiveData<List<Table>>()

    fun getAllCities() {
        viewModelScope.launch {
            val result = repository.getAllCities()
            citiesList.postValue(result.reports.firstOrNull()!!.table.firstOrNull()!!)
        }
    }
}