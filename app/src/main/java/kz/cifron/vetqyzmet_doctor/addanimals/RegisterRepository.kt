package kz.cifron.vetqyzmet_doctor.addanimals


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import java.io.IOException

class RegisterRepository(private val itemApi: RegisterApi) {

    private val _taskStateLiveData = MutableLiveData<TaskState>()
    val taskStateLiveData: LiveData<TaskState> = _taskStateLiveData

    suspend fun getTasks() {
        try {
            _taskStateLiveData.postValue(TaskState.Loading)
            val response = itemApi.getTasks()
            if (response.isSuccessful) {
                val tasks = response.body()
                _taskStateLiveData.postValue(tasks?.let { TaskState.Success(it) })
            } else {
                _taskStateLiveData.postValue(TaskState.Error("Error fetching tasks"))
            }
        } catch (e: Exception) {
            if (e is IOException) {
                _taskStateLiveData.postValue(TaskState.Error("Network error occurred"))
            } else {
                _taskStateLiveData.postValue(TaskState.Error(e.message ?: "An error occurred"))
            }
        }
    }
}