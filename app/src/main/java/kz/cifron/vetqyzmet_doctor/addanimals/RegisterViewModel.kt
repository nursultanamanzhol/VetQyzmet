package kz.cifron.vetqyzmet_doctor.addanimals


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class RegisterViewModel(private val repository: RegisterRepository) : ViewModel() {

    val taskLiveData = repository.taskStateLiveData



    fun getTasks() {
        viewModelScope.launch {
            repository.getTasks()
        }
    }

}
