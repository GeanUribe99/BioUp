package pe.edu.idat.bioup.auth.domain

import pe.edu.idat.bioup.auth.data.network.request.RegistroRequest
import pe.edu.idat.bioup.auth.data.network.response.RegistroResponse
import pe.edu.idat.bioup.auth.data.repository.AuthRepository
import javax.inject.Inject

class RegistroUseCase @Inject constructor(private val repository: AuthRepository){

    suspend operator fun invoke(registroRequest: RegistroRequest): RegistroResponse {
        return repository.registro(registroRequest)
    }
}