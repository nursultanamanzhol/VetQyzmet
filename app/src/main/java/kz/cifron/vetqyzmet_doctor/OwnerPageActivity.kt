package kz.cifron.vetqyzmet_doctor

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kz.cifron.vetqyzmet_doctor.addanimals.Tasks
import kz.cifron.vetqyzmet_doctor.databinding.ActivityOwnerPageBinding

class OwnerPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityOwnerPageBinding
    private lateinit var task: Tasks
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        binding = ActivityOwnerPageBinding.inflate(layoutInflater)
        setContentView(binding.root)
        DataFrom()
        binding.arrowIcon.setOnClickListener {
            onBackPressed()
        }


    }
    private fun DataFrom() {
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
