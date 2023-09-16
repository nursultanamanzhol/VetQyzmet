package kz.cifron.vetqyzmet_doctor.camera

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import kz.cifron.vetqyzmet_doctor.AnimalViewModel
import kz.cifron.vetqyzmet_doctor.CameraActivity
import kz.cifron.vetqyzmet_doctor.R
import kz.cifron.vetqyzmet_doctor.addanimals.Tasks
import kz.cifron.vetqyzmet_doctor.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var viewModel: AnimalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(AnimalViewModel::class.java)
        binding.saveTypeResult.text = viewModel.saveType
        binding.saveBirthMonth.text = viewModel.selectedDate
        binding.saveInj.text = viewModel.emailEt1
//        binding.genderAnimal = viewModel.genderAnimal
        binding.saveBreed.text = viewModel.saveBreed



        // Получение данных из Intent, переданных из CameraActivity
        val imageUriString = intent.getStringExtra("imageUri")
        val receivedTask = intent.getParcelableExtra<Tasks>("task")

        val imageUri = intent.getStringExtra("imageUri") // Получаем URI из Intent
        val imageView = findViewById<ImageView>(R.id.beautiful_r) // Находим ImageView по идентификатору

        Glide.with(this)
            .load(imageUri)
            .into(imageView)

        // Обработка нажатия на кнопку "Удалить и сбросить"
        val deleteAndResetImage = findViewById<ImageView>(R.id.deleteAndResetImage)
        deleteAndResetImage.setOnClickListener {
            // Здесь вы можете добавить код для удаления изображения (замените этот комментарий на свою реализацию)

            // Переход к CameraActivity после удаления
            val cameraIntent = Intent(this, CameraActivity::class.java)
            startActivity(cameraIntent)
            finish() // Завершаем текущую активность (ResultActivity)
        }

        // Пример обработки нажатия на кнопку "Назад"
        binding.arrowIcon.setOnClickListener {
            finish()
        }
    }
}
