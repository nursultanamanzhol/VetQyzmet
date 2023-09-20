package kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.addAnimals

import android.app.DatePickerDialog
import android.content.Intent
import android.content.res.Resources
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.RadioButton
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.bottomsheet.BottomSheetDialog
import kz.cifron.vetqyzmet_doctor.R
import kz.cifron.vetqyzmet_doctor.databinding.ActivityAddAnimalsBinding
import kz.cifron.vetqyzmet_doctor.databinding.DialogBottomSheetTypeAnimalBinding
import kz.cifron.vetqyzmet_doctor.databinding.DialogRadioButtonsBinding
import kz.cifron.vetqyzmet_doctor.main.PageVetQyzmet
import kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.addAnimals.camera.CameraActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddAnimalsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddAnimalsBinding
    private lateinit var viewModel: AnimalViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddAnimalsBinding.inflate(layoutInflater)
        setContentView(binding.root)



        binding.rectangleGray.setOnClickListener {
            startActivity(Intent(this, PageVetQyzmet::class.java))
            finish()

        }
        viewModel = ViewModelProvider(this)[AnimalViewModel::class.java]

        binding.rectangleFurther.setOnClickListener {
            val selectedRadioButtonId = binding.genderAnimal.checkedRadioButtonId

            // Инициализируйте selectedGenderText с пустой строкой
            var selectedGenderText = ""

            // Проверьте, какая RadioButton была выбрана
            if (selectedRadioButtonId == R.id.female) {
                selectedGenderText = "Самка"
            } else if (selectedRadioButtonId == R.id.male) {
                selectedGenderText = "Самец"
            }


            val intent = Intent(this, CameraActivity::class.java)
            intent.putExtra("saveType", binding.saveType.text.toString())
            intent.putExtra("birthDateText", binding.birthDateText.text.toString())
            intent.putExtra("saveBreed", binding.saveBreed.text.toString())
            intent.putExtra("emailEt1", binding.emailEt1.text.toString())
            intent.putExtra("genderAnimal", selectedGenderText)
            Log.d("saveType", binding.saveType.text.toString())
            startActivity(intent)
        }





//фон по умолчанию на устройствах Android 4.4.4
        binding.chooseDateButton.setOnClickListener {
            val getDate = Calendar.getInstance()
            val datepicker = DatePickerDialog(
                this,
                R.style.CustomDatePickerDialog, // Используйте ваш пользовательский стиль
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
        // Объявите переменную для хранения индекса выбранного RadioButton
        var selectedRadioButtonIndex: Int = -1

        binding.typeconst.setOnClickListener {
            val bottomSheetBinding = DialogBottomSheetTypeAnimalBinding.inflate(layoutInflater)
            val bottomSheetDialog = BottomSheetDialog(this)
            bottomSheetDialog.setContentView(bottomSheetBinding.root)

            // Устанавливаем слушатель для RadioGroup
            bottomSheetBinding.radioGroup.setOnCheckedChangeListener { group, checkedId ->
                val selectedRadioButton = group.findViewById<RadioButton>(checkedId)
                val selectedOptionText = selectedRadioButton.text.toString()
                binding.saveType.text = selectedOptionText

                // Сохраняем индекс выбранного RadioButton
                selectedRadioButtonIndex = group.indexOfChild(selectedRadioButton)

//                Handler().postDelayed({
                bottomSheetDialog.dismiss()
//                }, 500)
            }

            // Закрываем диалог при нажатии на кнопку "Выбрать"
            bottomSheetBinding.buttomClose.setOnClickListener {
                Handler().postDelayed({
                    bottomSheetDialog.dismiss()
                }, 500)
            }

            // Восстанавливаем выбранный RadioButton, если есть сохраненный индекс
            if (selectedRadioButtonIndex != -1) {
                val selectedRadioButton =
                    bottomSheetBinding.radioGroup.getChildAt(selectedRadioButtonIndex) as RadioButton
                selectedRadioButton.isChecked = true
            }

            bottomSheetDialog.show()
        }
    }


    private var selectedRadioButtonIndex =
        -1 // Переменная для хранения индекса выбранного RadioButton

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

        // Устанавливаем слушатель для RadioButton
        radioButtons.forEachIndexed { index, radioButton ->
            radioButton.setOnClickListener {
                binding.saveBreed.text = radioButton.text.toString()

                // Устанавливаем выбранный RadioButton активным
                radioButton.isChecked = true

                // Сохраняем индекс выбранного RadioButton
                selectedRadioButtonIndex = index

                Handler().postDelayed({
                    dialog.dismiss()
                }, 500)
            }
        }

        // При повторном открытии диалога устанавливаем выбранный RadioButton активным
        if (selectedRadioButtonIndex != -1) {
            radioButtons[selectedRadioButtonIndex].isChecked = true
        }

        dialog.show()
    }


}
