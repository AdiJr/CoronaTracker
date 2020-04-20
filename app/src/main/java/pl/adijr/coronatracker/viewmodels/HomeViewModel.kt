package pl.adijr.coronatracker.viewmodels

import androidx.lifecycle.ViewModel
import pl.adijr.coronatracker.repository.Repository
import javax.inject.Inject

class HomeViewModel @Inject constructor(val repository: Repository) : ViewModel()