package kz.cifron.vetqyzmet_doctor.main.vetQyzmetPages

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kz.cifron.vetqyzmet_doctor.databinding.ActivityCertificatesBinding

class CertificatesActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCertificatesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCertificatesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowIcon.setOnClickListener {
            onBackPressed()
        }
    }
}