package pe.edu.idat.bioup.auth.domain

import pe.edu.idat.bioup.auth.data.network.request.LoginRequest
import pe.edu.idat.bioup.auth.data.network.response.LoginResponse
import pe.edu.idat.bioup.auth.data.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repository: AuthRepository){
    suspend operator fun invoke(loginRequest: LoginRequest): LoginResponse{
        return repository.login(loginRequest)
    }
}