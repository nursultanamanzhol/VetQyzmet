package kz.cifron.vetqyzmet_doctor.loginData

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(private val repository: LoginRepository, private val userManager: UserManager) :
    ViewModel() {

    val loginStateLiveData = MutableLiveData<LoginState>()

    fun performLogin(email: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            loginStateLiveData.postValue(LoginState.Loading)
            try {
                val response = repository.login(email, password)
                if (response.isSuccessful) {
                    val responseData = response.body()
                    if (responseData != null) {
                        // Save user info securely
                        userManager.saveUserInfo(email, password)
                        loginStateLiveData.postValue(
                            LoginState.Success(
                                responseData.user,
                                responseData.token
                            )
                        )
                    } else {
                        loginStateLiveData.postValue(LoginState.Error("Response data is null"))
                    }
                } else {
                    loginStateLiveData.postValue(LoginState.Error("Login failed: ${response.code()}"))
                }
            } catch (e: Exception) {
                loginStateLiveData.postValue(LoginState.Error("Login failed: ${e.message}"))
            }
        }
    }

    fun getSavedUserInfo(): Pair<String, String>? {
        return userManager.getSavedUserInfo()
    }
}
