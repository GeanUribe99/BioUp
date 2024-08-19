package pe.edu.idat.bioup.home.data.network.domain

import pe.edu.idat.bioup.home.data.network.request.HistoriaClinicaRequest
import pe.edu.idat.bioup.home.data.network.response.HistoriaClinicaResponse
import pe.edu.idat.bioup.home.data.repository.HistoriaClinicaRepository
import javax.inject.Inject

class HistoriaClinicaUseCase @Inject constructor(private val repository: HistoriaClinicaRepository){
    suspend operator fun invoke(historiaclinicaRequest: HistoriaClinicaRequest): HistoriaClinicaResponse{
        return repository.verHistoriaClinica(historiaclinicaRequest)

    }
}