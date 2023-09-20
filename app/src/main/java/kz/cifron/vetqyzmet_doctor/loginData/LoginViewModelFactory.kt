package kz.cifron.vetqyzmet_doctor.loginData

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class LoginViewModelFactory(private val repository: LoginRepository, private val context: Context) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            val userManager = UserManager(context) // Замените UserManager
            /*Хранение паролей в SharedPreferences в текстовом виде не является безопасным подходом. Рассмотрите
            использование Android's EncryptedSharedPreferences или других библиотек для безопасного хранения паролей.*/
            return LoginViewModel(repository, userManager) as T
        }
        throw IllegalArgumentException("100 Unknown ViewModel class")
    }
}