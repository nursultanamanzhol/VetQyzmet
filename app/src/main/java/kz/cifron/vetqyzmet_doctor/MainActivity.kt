package kz.cifron.vetqyzmet_doctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import kz.cifron.vetqyzmet_doctor.databinding.ActivityMainBinding
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val calendar = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("dd MMMM", Locale.getDefault())

        binding.dateFormat.text = dateFormat.format(calendar.time)
    }
}