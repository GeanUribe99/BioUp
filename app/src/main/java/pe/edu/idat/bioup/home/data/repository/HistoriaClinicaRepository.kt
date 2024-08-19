package pe.edu.idat.bioup.home.data.repository

import pe.edu.idat.bioup.home.data.network.request.HistoriaClinicaRequest
import pe.edu.idat.bioup.home.data.network.response.HistoriaClinicaResponse
import pe.edu.idat.bioup.home.data.network.response.HistoriaDiariaResponse
import pe.edu.idat.bioup.home.data.network.service.HistoriaClinicaService
import javax.inject.Inject


// HistoriaClinicaRepository va a trabajar para todos los USECASE
class HistoriaClinicaRepository @Inject constructor(private  val hisotoriaclinicaService: HistoriaClinicaService) {
    suspend fun listarHistoriaDiaria(): List<HistoriaDiariaResponse>{
        return hisotoriaclinicaService.listarHistoriaDiaria()
    }

    suspend fun verHistoriaClinica(historiaClinicaRequest: HistoriaClinicaRequest): HistoriaClinicaResponse {
        return hisotoriaclinicaService.verHistoriaClinica(historiaClinicaRequest)
    }
}