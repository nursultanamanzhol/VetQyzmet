package kz.cifron.vetqyzmet_doctor.camera

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kz.cifron.vetqyzmet_doctor.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {

    private lateinit var binding: ActivityResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

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
