package kz.cifron.vetqyzmet_doctor

import android.os.Bundle
import android.view.LayoutInflater
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialog
import kz.cifron.vetqyzmet_doctor.databinding.ActivityAddAnimalsBinding
import kz.cifron.vetqyzmet_doctor.databinding.BottomSheetDialogBinding
import kz.cifron.vetqyzmet_doctor.databinding.DialogRadioButtonsBinding

class AddAnimalsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddAnimalsBinding
    private lateinit var viewModel: AnimalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAnimalsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(AnimalViewModel::class.java)

        // Восстановите значения из ViewModel и установите их в соответствующие элементы интерфейса.
        binding.saveType.text = viewModel.saveType
        binding.emailEt1.setText(viewModel.emailEt1)
        // Продолжите так же для genderAnimal и saveBreed

        binding.arrowIcon.setOnClickListener {
            onBackPressed()
        }

        binding.breedConst.setOnClickListener {
            showRadioButtonDialog()
        }

        binding.emailEt1.doAfterTextChanged { editable ->
            val emailText = editable.toString()
            viewModel.emailEt1 = emailText
            // Вы можете использовать значение emailText по вашему усмотрению
        }
        binding.typeconst.setOnClickListener {
            val bottomSheetBinding = BottomSheetDialogBinding.inflate(layoutInflater)
            val bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog.setContentView(bottomSheetBinding.root)

            // Устанавливаем слушатель для RadioGroup
            bottomSheetBinding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val selectedRadioButton = group.findViewById<RadioButton>(checkedId)
                val selectedOptionText = selectedRadioButton.text.toString()
                viewModel.saveType = selectedOptionText
                binding.saveType.text = selectedOptionText
                bottomSheetDialog.dismiss() // Закрываем диалог после выбора
            }

            // Закрываем диалог при нажатии на любую часть макета BottomSheetDialog
            bottomSheetBinding.buttomClose.setOnClickListener {
                bottomSheetDialog.dismiss()
            }

            bottomSheetDialog.show()
        }
    }

    private fun showRadioButtonDialog() {
        val dialogBinding = DialogRadioButtonsBinding.inflate(LayoutInflater.from(this))
        val builder = AlertDialog.Builder(this)
        builder.setView(dialogBinding.root)

        // Массив RadioButton
        val radioButtons = arrayOf(
            dialogBinding.option1,
            dialogBinding.option2,
            dialogBinding.option3,
            dialogBinding.option4,
            dialogBinding.option5,
            dialogBinding.option6,
            dialogBinding.option7
        )

        val dialog = builder.create()

        radioButtons.forEachIndexed { index, radioButton ->
            radioButton.setOnClickListener {
                viewModel.saveBreed = "Option ${index + 1}"
                binding.saveBreed.text = viewModel.saveBreed
                dialog.dismiss()
            }
        }

        dialog.show()
    }
}
