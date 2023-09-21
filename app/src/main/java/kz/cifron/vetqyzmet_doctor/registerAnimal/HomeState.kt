package kz.cifron.vetqyzmet_doctor.registerAnimal

sealed class TaskState {
    object Loading : TaskState()
    data class Success(val tasks: List<Tasks>) : TaskState()
    data class Error(val errorMessage: String) : TaskState()
}
