package kz.cifron.vetqyzmet_doctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.cifron.vetqyzmet_doctor.databinding.ActivityFormBinding
import kz.cifron.vetqyzmet_doctor.databinding.ActivityMigrationBinding

class MigrationActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMigrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMigrationBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowIcon.setOnClickListener {
            onBackPressed()
        }
    }
}