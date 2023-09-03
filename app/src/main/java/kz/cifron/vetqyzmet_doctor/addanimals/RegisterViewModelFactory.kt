package kz.cifron.vetqyzmet_doctor.addanimals

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class RegisterViewModelFactory(private val repository: RegisterRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(RegisterViewModel::class.java)) {
            return RegisterViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
