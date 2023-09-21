package kz.cifron.vetqyzmet_doctor.loginData

sealed class LoginState {
    data class Success(val user: User, val token: String) : LoginState()
    data class Error(val message: String, val throwable: Throwable? = null) : LoginState()
    object Loading : LoginState()


}
