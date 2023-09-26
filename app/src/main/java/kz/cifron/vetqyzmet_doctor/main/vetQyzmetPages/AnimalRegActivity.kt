package kz.cifron.vetqyzmet_doctor.main.vetQyzmetPages

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import kz.cifron.vetqyzmet_doctor.registerAnimal.RegisterAdapter
import kz.cifron.vetqyzmet_doctor.registerAnimal.RegisterRepository
import kz.cifron.vetqyzmet_doctor.registerAnimal.RegisterViewModel
import kz.cifron.vetqyzmet_doctor.registerAnimal.RegisterViewModelFactory
import kz.cifron.vetqyzmet_doctor.registerAnimal.ServiceBuilder
import kz.cifron.vetqyzmet_doctor.registerAnimal.TaskState
import kz.cifron.vetqyzmet_doctor.registerAnimal.Tasks
import kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.OwnerPageActivity
import kz.cifron.vetqyzmet_doctor.databinding.ActivityAnimalRegBinding

class AnimalRegActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAnimalRegBinding
    private lateinit var registerViewModel: RegisterViewModel
    private lateinit var registerAdapter: RegisterAdapter
    private var originalTaskList: List<Tasks> = emptyList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAnimalRegBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        setupViewModel()
        setupRecyclerView()
        observeTask()
        registerViewModel.getTasks()
    }

    private fun setupUI() {
        binding.arrowIcon.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setupViewModel() {
        val taskApiService = ServiceBuilder.taskInstanceApi
        val registerRepository = RegisterRepository(taskApiService)
        registerViewModel = ViewModelProvider(
            this, RegisterViewModelFactory(registerRepository)
        )[RegisterViewModel::class.java]
    }

    private fun setupRecyclerView() {
        registerAdapter = RegisterAdapter()
        binding.recyclerView.apply {
            layoutManager = LinearLayoutManager(this@AnimalRegActivity)
            adapter = registerAdapter
        }

        registerAdapter.setOnItemClickListener { task ->
            val intent = Intent(this, OwnerPageActivity::class.java)
            val lengthMeter:Int = task.RAZ_TIPSCH
            Log.d("YourTag", "ownerPage: $lengthMeter")
            intent.putExtra("length", lengthMeter)
            intent.putExtra("location", task.ADDR)
            intent.putExtra("client", task.NAME_REG5)
            intent.putExtra("cvNumber", task.NAME_SCH)
            intent.putExtra("proverkaDate", task.POVERKA_DATE)
            startActivity(intent)
        }
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
