package kz.cifron.vetqyzmet_doctor.camera

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kz.cifron.vetqyzmet_doctor.R
import kz.cifron.vetqyzmet_doctor.addanimals.Tasks
import kz.cifron.vetqyzmet_doctor.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Получение данных из Intent, переданных из CameraActivity
        val imageUriString = intent.getStringExtra("imageUri")
        val receivedTask = intent.getParcelableExtra<Tasks>("task")

        val imageUri = intent.getStringExtra("imageUri") // Получаем URI из Intent
        val imageView = findViewById<ImageView>(R.id.beautiful_r) // Находим ImageView по идентификатору

// Загружаем изображение в ImageView
        Glide.with(this)
            .load(imageUri)
            .into(imageView)


        // Используйте полученные данные для отображения в вашем макете Activity
        // Например, вы можете использовать библиотеку Glide для отображения изображения:
        // Glide.with(this).load(imageUriString).into(binding.resultImage)

        // Также, вы можете использовать данные задачи (receivedTask) для вывода информации о задаче.

        // Пример обработки кнопки "Назад" для возврата в CameraActivity
//            binding.backButton.setOnClickListener {
//            finish() // Завершаем текущую активность и возвращаемся в CameraActivity
//        }

//        val receivedTask = intent.getParcelableExtra<Tasks>("task")
//        binding.textAddress.text = receivedTask!!.ADDR
//
//        val imageUriString = intent.getStringExtra("imageUri")
//        val resultImage = findViewById<ImageView>(R.id.resultImage)
//        Glide.with(this)
//            .load(imageUriString)
//            .into(resultImage)

        binding.arrowIcon.setOnClickListener {
            finish()
        }
    }
}
