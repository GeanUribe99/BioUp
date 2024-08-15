package pe.edu.idat.bioup.auth.data.network.service

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import pe.edu.idat.bioup.auth.data.network.request.LoginRequest
import pe.edu.idat.bioup.auth.data.network.request.RegistroRequest
import pe.edu.idat.bioup.auth.data.network.response.LoginResponse
import pe.edu.idat.bioup.auth.data.network.response.RegistroResponse
import pe.edu.idat.bioup.core.retrofit.BioupClient
import javax.inject.Inject

class AuthService @Inject constructor( private val bioupClient: BioupClient){
    suspend fun login(loginRequest: LoginRequest): LoginResponse{
        return withContext(Dispatchers.IO){
            val response = bioupClient.login(loginRequest)
            response.body()!!
        }
    }

    suspend fun registro(registroRequest: RegistroRequest): RegistroResponse{
        return withContext(Dispatchers.IO){
            val response = bioupClient.registro(registroRequest)
            response.body()!!
        }
    }
}