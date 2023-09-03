package kz.cifron.vetqyzmet_doctor.addanimals

import retrofit2.Response
import retrofit2.http.GET

interface RegisterApi {

    @GET("v5/getTasks")
    suspend fun getTasks(): Response<List<Tasks>>
}