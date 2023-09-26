package kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.addAnimals

import android.os.Bundle
import android.text.InputFilter
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import com.google.android.material.textfield.TextInputEditText
import kz.cifron.vetqyzmet_doctor.R
import kz.cifron.vetqyzmet_doctor.databinding.ActivityAddAnimalsBinding

class AddAnimalsActivity : AppCompatActivity() {
    lateinit var binding: ActivityAddAnimalsBinding
    lateinit var additionalFunctions: AddAnimalsAdditional

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAnimalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //edit max length
        val emailEditText = findViewById<TextInputEditText>(R.id.emailEt1)

        // Устанавливаем новое значение maxLength (например, 15 символов)
        val defaultValue = 0
        val newMaxLength = intent.getIntExtra("lengthMeterAddAnimals", defaultValue)
        emailEditText.filters = arrayOf(InputFilter.LengthFilter(newMaxLength))

        additionalFunctions = AddAnimalsAdditional(this, binding)

        setupClickListeners()
        setupTextChangeListeners()
    }

    private fun setupClickListeners() {
        val dateClickListener = View.OnClickListener {
            additionalFunctions.showDatePickerDialog()
        }
        binding.birthDateText.setOnClickListener(dateClickListener)
        binding.chooseDateButton.setOnClickListener(dateClickListener)

        binding.rectangleGray.setOnClickListener {
            additionalFunctions.navigateToPageVetQyzmet()
        }

        binding.rectangleFurther.setOnClickListener {
            additionalFunctions.navigateToCameraActivity()
        }

        binding.arrowIcon.setOnClickListener {
            onBackPressed()
        }

        binding.breedConst.setOnClickListener {
            additionalFunctions.showRadioButtonDialog()
        }
        binding.colorConst.setOnClickListener {
            additionalFunctions.showBottomRadioButtonDialog()
        }
        binding.typeconst.setOnClickListener {
            additionalFunctions.showBottomTypeRadioButtonDialog()
        }
    }

    private fun setupTextChangeListeners() {
        binding.emailEt1.doAfterTextChanged { editable ->
            val emailText = editable
            // Вы можете использовать значение emailText по вашему усмотрению
        }
    }
}
