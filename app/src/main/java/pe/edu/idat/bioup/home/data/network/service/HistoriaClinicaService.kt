package pe.edu.idat.bioup.home.data.network.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.idat.bioup.core.retrofit.BioupClient
import pe.edu.idat.bioup.home.data.network.request.HistoriaClinicaRequest
import pe.edu.idat.bioup.home.data.network.response.HistoriaClinicaResponse
import pe.edu.idat.bioup.home.data.network.response.HistoriaDiariaResponse
import javax.inject.Inject

class HistoriaClinicaService @Inject constructor(private val bioupClient: BioupClient) {
    suspend fun listarHistoriaDiaria(): List<HistoriaDiariaResponse> {
        return withContext(Dispatchers.IO){
            val response = bioupClient.listarHistoriaDiaria()
            response.body()!!
        }
    }

    suspend fun  verHistoriaClinica(historiaClinicaRequest: HistoriaClinicaRequest): HistoriaClinicaResponse{
        return withContext(Dispatchers.IO){
            val response = bioupClient.verHistoriaClinica(historiaClinicaRequest)
            response.body()!!
        }

    }

    //AGREGAR LOS SERVICIOS FALTANTES COMO verDatosPersonales, reservarCita, verMapa
    //..............................................................................

}