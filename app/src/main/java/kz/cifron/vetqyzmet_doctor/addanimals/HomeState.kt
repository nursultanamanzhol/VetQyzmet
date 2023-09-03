package kz.cifron.vetqyzmet_doctor.addanimals

sealed class TaskState {
    object Loading : TaskState()
    data class Success(val tasks: List<Tasks>) : TaskState()
    data class Error(val errorMessage: String) : TaskState()
}
