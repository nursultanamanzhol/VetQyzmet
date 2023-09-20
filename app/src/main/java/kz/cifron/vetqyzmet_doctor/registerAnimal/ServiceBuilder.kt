package kz.cifron.vetqyzmet_doctor.registerAnimal

import kz.cifron.vetqyzmet_doctor.utils.Constant
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ServiceBuilder {

    class ApiInterceptor(private val token: String) : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response {
            val request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer $token")
                .build()
            return chain.proceed(request)
        }
    }

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(ApiInterceptor("1420014|CqJRvdgc8QPnhgBeW2z4E3ZBV3arKPWVw33UCtKR"))
        .build()


    val taskInstanceApi: RegisterApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl(Constant.BASE_URL)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(RegisterApi::class.java)
    }
}