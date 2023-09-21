package kz.cifron.vetqyzmet_doctor.main.vetQyzmetPages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.cifron.vetqyzmet_doctor.databinding.ActivityFormBinding

class FormActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFormBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowIcon.setOnClickListener {
            onBackPressed()
        }
    }
}