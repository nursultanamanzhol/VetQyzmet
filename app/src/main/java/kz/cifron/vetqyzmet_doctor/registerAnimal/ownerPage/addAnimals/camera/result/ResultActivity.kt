package kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.addAnimals.camera.result

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.addAnimals.AddAnimalsAdditional
import kz.cifron.vetqyzmet_doctor.R
import kz.cifron.vetqyzmet_doctor.databinding.ActivityResultBinding
import kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.addAnimals.camera.CameraActivity

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding
    private lateinit var viewModel: AddAnimalsAdditional

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.rectangleGray.setOnClickListener {
            onBackPressed()
            onBackPressed()
            onBackPressed()
            finish()
        }

        binding.saveTypeResult.text = intent.getStringExtra("saveTypeResult")
            ?.takeIf { it.isNotEmpty() }
            ?: intent.getStringExtra("saveTypeResultReset")

        binding.emailEt1Result.text = intent.getStringExtra("emailEt1Result")
            ?.takeIf { it.isNotEmpty() }
            ?: intent.getStringExtra("emailEt1ResultReset")

        binding.genderAnimalResult.text = intent.getStringExtra("genderAnimalResult")
            ?.takeIf { it.isNotEmpty() }
            ?: intent.getStringExtra("genderAnimalResultReset")

        binding.saveBreedResult.text = intent.getStringExtra("saveBreedResult")
            ?.takeIf { it.isNotEmpty() }
            ?: intent.getStringExtra("saveBreedResultReset")

        binding.saveBirthMonthResult.text = intent.getStringExtra("birthDateTextResult")
            ?.takeIf { it.isNotEmpty() }
            ?: intent.getStringExtra("birthDateTextResultReset")
        
        binding.saveColorResult.text = intent.getStringExtra("saveColorResult")
            ?.takeIf { it.isNotEmpty() }
            ?: intent.getStringExtra("saveColorResultReset")

        val imageUri = intent.getStringExtra("imageUri") // Получаем URI из Intent
        val imageView =
            findViewById<ImageView>(R.id.beautiful_r) // Находим ImageView по идентификатору

        Glide.with(this)
            .load(imageUri)
            .into(imageView)

        // Обработка нажатия на кнопку "Удалить и сбросить"
        binding.deleteAndResetImage.setOnClickListener {

            val cameraIntent = Intent(this, CameraActivity::class.java)
            val saveType = intent.getStringExtra("saveTypeResult")
            val birthDateText = intent.getStringExtra("birthDateTextResult")
            val saveBreed = intent.getStringExtra("saveBreedResult")
            val genderAnimal = intent.getStringExtra("genderAnimalResult")
            val emailEt1 = intent.getStringExtra("emailEt1Result")
            val saveColor = intent.getStringExtra("saveColorResult")
            cameraIntent.putExtra("saveTypeResult", saveType)
            cameraIntent.putExtra("birthDateTextResult", birthDateText)
            cameraIntent.putExtra("saveBreedResult", saveBreed)
            cameraIntent.putExtra("genderAnimalResult", genderAnimal)
            cameraIntent.putExtra("emailEt1Result", emailEt1)
            cameraIntent.putExtra("emailEt1Result", saveColor)

            startActivity(cameraIntent)
            finish()

        }


        // Пример обработки нажатия на кнопку "Назад"
        binding.arrowIcon.setOnClickListener {
            finish()
        }
    }

}
