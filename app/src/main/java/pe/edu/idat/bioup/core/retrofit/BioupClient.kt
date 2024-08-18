package pe.edu.idat.bioup.core.retrofit

import pe.edu.idat.bioup.auth.data.network.request.LoginRequest
import pe.edu.idat.bioup.auth.data.network.request.RegistroRequest
import pe.edu.idat.bioup.auth.data.network.response.LoginResponse
import pe.edu.idat.bioup.auth.data.network.response.RegistroResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT

interface BioupClient {

    @POST("login.php")
    suspend fun login(@Body loginRequest: LoginRequest): Response<LoginResponse>

    @PUT("persona.php")
    suspend fun registro(@Body registroRequest: RegistroRequest): Response<RegistroResponse>
}