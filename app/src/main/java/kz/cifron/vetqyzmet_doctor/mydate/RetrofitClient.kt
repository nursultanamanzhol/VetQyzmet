package kz.cifron.vetqyzmet_doctor.mydate

import kz.cifron.vetqyzmet_doctor.utils.Constant
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private val loggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }
    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(loggingInterceptor)
        .build()

    private var retrofit: Retrofit = buildRetrofit(Constant.BASE_URL)

    val instanceApi: LoginApi by lazy {
        retrofit.create(LoginApi::class.java)
    }

    fun updateBaseUrl(baseUrl: String) {
        retrofit = buildRetrofit(baseUrl)
    }

    private fun buildRetrofit(baseUrl: String): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}
