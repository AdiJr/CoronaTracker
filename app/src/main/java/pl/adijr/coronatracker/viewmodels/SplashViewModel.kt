package pl.adijr.coronatracker.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor() : ViewModel() {

    val proceed = MutableLiveData<Boolean>()

    fun fetchOnline() {
        viewModelScope.launch {
            val loadingDone = async {
                delay(4_000)
                true
            }
            loadingDone.await()
            proceed.postValue(true)
        }
    }
}