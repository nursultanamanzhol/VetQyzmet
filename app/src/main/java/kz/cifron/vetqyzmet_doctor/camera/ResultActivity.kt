package kz.cifron.vetqyzmet_doctor.camera

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kz.cifron.vetqyzmet_doctor.CameraActivity
import kz.cifron.vetqyzmet_doctor.R
import kz.cifron.vetqyzmet_doctor.addanimals.Tasks
import kz.cifron.vetqyzmet_doctor.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Получение текста из Intent
        val saveTypeText = intent.getStringExtra("saveType")
        // Найдите TextView, в который вы хотите установить текст
        binding.saveType.text = saveTypeText

        // Установите полученный текст в TextView
//        resultTextView.text = saveTypeText



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
