package kz.cifron.vetqyzmet_doctor

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import com.google.android.material.bottomsheet.BottomSheetDialog
import kz.cifron.vetqyzmet_doctor.databinding.ActivityAddAnimalsBinding
import kz.cifron.vetqyzmet_doctor.databinding.BottomSheetDialogBinding

class AddAnimalsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddAnimalsBinding
    private lateinit var selectedRadioButton: RadioButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAnimalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.arrowIcon.setOnClickListener {
            onBackPressed()
        }


        binding.typeconst.setOnClickListener {
            val bottomSheetBinding = BottomSheetDialogBinding.inflate(layoutInflater)
            val bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog.setContentView(bottomSheetBinding.root)

            bottomSheetBinding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                selectedRadioButton = group.findViewById(checkedId)
            }

            bottomSheetBinding.confirmButton.setOnClickListener {
                val selectedOptionText = selectedRadioButton.text.toString()
                binding.test.text = selectedOptionText
                bottomSheetDialog.dismiss()
            }

            bottomSheetDialog.show()
        }
    }
}
