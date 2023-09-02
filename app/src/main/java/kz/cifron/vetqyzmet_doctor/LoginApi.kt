package kz.cifron.vetqyzmet_doctor

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface LoginApi {
    @POST("login")
    suspend fun login(@Body request: LoginRequestBody): Response<LoginResponse>
}
