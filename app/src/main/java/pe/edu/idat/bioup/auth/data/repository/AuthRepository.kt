package pe.edu.idat.bioup.auth.data.repository

import pe.edu.idat.bioup.auth.data.network.request.LoginRequest
import pe.edu.idat.bioup.auth.data.network.request.RegistroRequest
import pe.edu.idat.bioup.auth.data.network.response.LoginResponse
import pe.edu.idat.bioup.auth.data.network.response.RegistroResponse
import pe.edu.idat.bioup.auth.data.network.service.AuthService
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService) {

    suspend fun login(loginRequest: LoginRequest): LoginResponse{
        return authService.login(loginRequest)
    }
    suspend fun registro(registroRequest: RegistroRequest): RegistroResponse {
        return authService.registro(registroRequest)
    }
}