package pe.edu.idat.bioup.home.data.network.domain

import pe.edu.idat.bioup.home.data.network.response.HistoriaDiariaResponse
import pe.edu.idat.bioup.home.data.repository.HistoriaClinicaRepository
import javax.inject.Inject

class HistoriaDiariaUseCase @Inject constructor(private val repository: HistoriaClinicaRepository){
    suspend operator fun invoke(): List<HistoriaDiariaResponse> {
        return repository.listarHistoriaDiaria()
    }
}