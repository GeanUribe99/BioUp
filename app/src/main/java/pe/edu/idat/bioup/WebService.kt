package pe.edu.idat.bioup

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface WebService {
    @GET("data/{id}")
    suspend fun getInformationUser(
        @Path("id") id_usuario: String
    ):Response<UserResponse>
}