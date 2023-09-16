package kz.cifron.vetqyzmet_doctor

import android.app.DatePickerDialog
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import kz.cifron.vetqyzmet_doctor.camera.ResultActivity
import kz.cifron.vetqyzmet_doctor.databinding.ActivityAddAnimalsBinding
import kz.cifron.vetqyzmet_doctor.databinding.BottomSheetDialogBinding
import kz.cifron.vetqyzmet_doctor.databinding.DialogRadioButtonsBinding
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddAnimalsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddAnimalsBinding
    private lateinit var viewModel: AnimalViewModel

    private lateinit var selectedDate: Calendar

    private var saveTypeResult: String = ""
    val foramtDate = SimpleDateFormat("yyyy MMMM", Locale.getDefault())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAnimalsBinding.inflate(layoutInflater)
        setContentView(binding.root)







        binding.rectangleGray.setOnClickListener {
            startActivity(Intent(this, PageVetQyzmet::class.java))
            finish()

        }

        binding.rectangleFurther.setOnClickListener {
            startActivity(Intent(this, ResultActivity::class.java))
            viewModel = ViewModelProvider(this)[AnimalViewModel::class.java]
            viewModel.saveType = saveTypeResult
            viewModel.selectedDate = "Новое значение для selectedDate"
            viewModel.emailEt1 = "sdadad"
            viewModel.genderAnimal = "Новое значение для genderAnimal"
            viewModel.saveBreed = "Новое значение для saveBreed"
            println()

        }



        binding.chooseDateButton.setOnClickListener {
            val getDate = Calendar.getInstance()

            // Используйте DatePickerDialog.OnDateSetListener для выбора месяца и года
            val datepicker = DatePickerDialog(
                this,
                android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                DatePickerDialog.OnDateSetListener { _, year, month, _ ->

                    val selecDate = Calendar.getInstance()
                    selecDate.set(Calendar.YEAR, year)
                    selecDate.set(Calendar.MONTH, month)

                    // Форматируйте дату для отображения только месяца и года
                    val dateFormat = SimpleDateFormat("yyyy, MMMM", Locale.getDefault())
                    val formattedDate = dateFormat.format(selecDate.time)

                    // Отобразите отформатированную дату
                    binding.birthDateText.text = formattedDate
                },
                getDate.get(Calendar.YEAR),
                getDate.get(Calendar.MONTH),
                getDate.get(Calendar.DAY_OF_MONTH)
            )

            // Скройте день, отключив его в DatePicker
            try {
                val datePicker = datepicker.datePicker
                val daySpinnerId = Resources.getSystem().getIdentifier("day", "id", "android")
                val daySpinner = datePicker.findViewById<View>(daySpinnerId)
                if (daySpinner != null) {
                    daySpinner.visibility = View.GONE
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }

            datepicker.show()
        }



        // Продолжите так же для genderAnimal и saveBreed

        binding.arrowIcon.setOnClickListener {
            onBackPressed()
        }

        binding.breedConst.setOnClickListener {
            showRadioButtonDialog()
        }

        binding.emailEt1.doAfterTextChanged { editable ->
            val emailText = editable
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
                binding.saveType.text = selectedOptionText
                saveTypeResult = selectedRadioButton.text.toString()
                Handler().postDelayed({
                    bottomSheetDialog.dismiss()
                }, 500)
            }

            // Закрываем диалог при нажатии на кнопку "Выбрать"
            bottomSheetBinding.buttomClose.setOnClickListener {
                Handler().postDelayed({
                    bottomSheetDialog.dismiss()
                }, 500) // Здесь 1000 миллисекунд (1 секунда) - это задержка перед закрытием
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
                binding.saveBreed.text = radioButton.text.toString()
                Handler().postDelayed({
                    dialog.dismiss()
                }, 500)
            }
        }

        dialog.show()
    }
}
