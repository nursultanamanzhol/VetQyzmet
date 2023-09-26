package kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kz.cifron.vetqyzmet_doctor.databinding.ActivityOwnerPageBinding
import kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.addAnimals.AddAnimalsActivity

class OwnerPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOwnerPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOwnerPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupUI()
        binding.arrowIcon.setOnClickListener {
            onBackPressed()
        }
        binding.addAnimals.setOnClickListener {
            val ownerIntent = Intent(this, AddAnimalsActivity::class.java)
            val defaultValue = 0
            val ownerPage = intent.getIntExtra("length", defaultValue)
            Log.d("MeterTag", "ownerPage: $ownerPage")// Вывести значение ownerPage в LogCat
            ownerIntent.putExtra("lengthMeterAddAnimals", ownerPage)
            startActivity(ownerIntent)

        }
        setDataFromIntent()
    }

    private fun setupUI() {
        // Можете добавить другие настройки UI здесь
    }

    private fun setDataFromIntent() {
        val location = intent.getStringExtra("location")
        val client = intent.getStringExtra("client")
        val cvNumber = intent.getStringExtra("cvNumber")
        val proverkaDate = intent.getStringExtra("proverkaDate")

        if (location != null && client != null && cvNumber != null && proverkaDate != null) {
            binding.textLocation.text = location
            binding.textClient.text = client
            binding.textCvNumber.text = cvNumber
            binding.dataProverka.text = proverkaDate
        } else {
            Log.e("OwnerPageActivity", "One or more extras are missing")
        }
    }
}
