package kz.cifron.vetqyzmet_doctor.loginData

import retrofit2.Call
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface LoginApi {
    @POST("login")
    suspend fun login(@Body request: LoginRequestBody): Response<LoginResponse>
    @Headers("Content-Type:application/json")
    @GET("getTasks")
    fun getAllProducts(): Call<List<User>>


}
