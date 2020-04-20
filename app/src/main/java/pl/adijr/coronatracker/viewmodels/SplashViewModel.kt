package pl.adijr.coronatracker.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import pl.adijr.coronatracker.repository.Repository
import javax.inject.Inject

class SplashViewModel @Inject constructor(val repository: Repository) : ViewModel() {

    val proceed = MutableLiveData<Boolean>()

    fun fetchOnline() {
        viewModelScope.launch {
            val loadingDone = async {
                delay(2_500)
                true
            }
            val fetchDone = async {
                try {
                    val result = repository.fetchWorldlyStats()
                    repository.storeAll(result)
                } catch (e: Exception) {
                    e.printStackTrace()
                }
                true
            }
            loadingDone.await() && fetchDone.await()
            proceed.postValue(true)
        }
    }
}