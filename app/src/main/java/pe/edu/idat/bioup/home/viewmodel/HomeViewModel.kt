package pe.edu.idat.bioup.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import pe.edu.idat.bioup.home.data.network.domain.HistoriaClinicaUseCase
import pe.edu.idat.bioup.home.data.network.domain.HistoriaDiariaUseCase
import pe.edu.idat.bioup.home.data.network.response.HistoriaClinicaResponse
import pe.edu.idat.bioup.home.data.network.response.HistoriaDiariaResponse
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor( private val historiadiariaUseCase: HistoriaDiariaUseCase,
                                         private val historiaclinicaUseCase: HistoriaClinicaUseCase):ViewModel() {
    private val _historiadiariaResponse = MutableLiveData<List<HistoriaDiariaResponse>>()
    val historiadiariaResponse: LiveData<List<HistoriaDiariaResponse>> = _historiadiariaResponse

    private val _historiaclinicaResponse = MutableLiveData<HistoriaClinicaResponse>()
    val historiaclinicaResponse: LiveData<HistoriaClinicaResponse> = _historiaclinicaResponse

    init {
        listarHistoriaDiaria()
    }

    private fun listarHistoriaDiaria() {
        viewModelScope.launch {
            val response = historiadiariaUseCase()
            _historiadiariaResponse.value = response
        }
    }

    fun verHistoriaClinica() {
    }
}