package kz.cifron.vetqyzmet_doctor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kz.cifron.vetqyzmet_doctor.addanimals.RegisterAdapter
import kz.cifron.vetqyzmet_doctor.addanimals.RegisterRepository
import kz.cifron.vetqyzmet_doctor.addanimals.RegisterViewModel
import kz.cifron.vetqyzmet_doctor.addanimals.RegisterViewModelFactory
import kz.cifron.vetqyzmet_doctor.addanimals.ServiceBuilder
import kz.cifron.vetqyzmet_doctor.addanimals.TaskState
import kz.cifron.vetqyzmet_doctor.addanimals.Tasks
import kz.cifron.vetqyzmet_doctor.databinding.ActivityAnimalRegBinding
import kz.cifron.vetqyzmet_doctor.databinding.ActivityPageVetQyzmetBinding

class AnimalRegActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalRegBinding
    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var registerAdapter: RegisterAdapter

    private var originalTaskList: List<Tasks> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalRegBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowIcon.setOnClickListener {
            onBackPressed()
        }

        val taskApiService = ServiceBuilder.taskInstanceApi
        val registerRepository = RegisterRepository(taskApiService)
        registerViewModel = ViewModelProvider(
            this,
            RegisterViewModelFactory(registerRepository)
        )[RegisterViewModel::class.java]

        setUpRecyclerView()
        observeTask()
        registerViewModel.getTasks()


        registerAdapter.setOnItemClickListener { task ->
            val bundle = Bundle()
            bundle.putParcelable("task", task)
            Log.d("AnimalRegActivity", "Task addr: ${task.ADDR}")
        }
    }

    private fun setUpRecyclerView() {
        registerAdapter = RegisterAdapter()
        val recyclerView = binding.recyclerView
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = registerAdapter
    }

    private fun observeTask() {
        registerViewModel.taskLiveData.observe(this) { state ->
            when (state) {
                is TaskState.Loading -> {
                    binding.progressBar.visibility = View.VISIBLE
                }

                is TaskState.Success -> {
                    binding.progressBar.visibility = View.INVISIBLE
                    originalTaskList = state.tasks
                    registerAdapter.differ.submitList(originalTaskList)
                }

                is TaskState.Error -> {
                    binding.progressBar.visibility = View.GONE
                    Toast.makeText(this, "Api is error data holded", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

}
