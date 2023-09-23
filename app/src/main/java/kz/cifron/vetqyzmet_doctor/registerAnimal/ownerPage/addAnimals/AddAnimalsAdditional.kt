package kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.addAnimals

import android.app.DatePickerDialog
import android.content.Intent
import android.content.res.Resources
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.appcompat.app.AlertDialog
import com.google.android.material.bottomsheet.BottomSheetDialog
import kz.cifron.vetqyzmet_doctor.R
import kz.cifron.vetqyzmet_doctor.databinding.ActivityAddAnimalsBinding
import kz.cifron.vetqyzmet_doctor.databinding.DialogBottomSheetAnimalColorBinding
import kz.cifron.vetqyzmet_doctor.databinding.DialogBottomSheetTypeAnimalBinding
import kz.cifron.vetqyzmet_doctor.databinding.DialogRadioButtonsBinding
import kz.cifron.vetqyzmet_doctor.main.PageVetQyzmet
import kz.cifron.vetqyzmet_doctor.registerAnimal.ownerPage.addAnimals.camera.CameraActivity
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Locale

class AddAnimalsAdditional(
    private val activity: AddAnimalsActivity,
    private val binding: ActivityAddAnimalsBinding
) {
    private var selectedBottomTypeRadioButtonIndex = -1
    private var selectedBottomRadioButtonIndex = -1
    private var selectedRadioButtonIndex = -1

    fun navigateToPageVetQyzmet() {
        val intent = Intent(activity, PageVetQyzmet::class.java)
        activity.startActivity(intent)
        activity.finish()
    }

    fun navigateToCameraActivity() {
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

            val missingFields = mutableListOf<String>()

            // Проверьте, какие поля остались не заполненными
            if (binding.saveType.text.isBlank()) {
                missingFields.add("Выберите тип животного")
            }
            if (binding.birthDateText.text.isBlank()) {
                missingFields.add("Дата рождения")
            }
            if (binding.saveBreed.text.isBlank()) {
                missingFields.add("Порода")
            }
            if (binding.emailEt1.text.toString().isBlank()) {
                missingFields.add("Введите ИНЖ")
            }
            if (binding.saveColor.text.toString().isBlank()) {
                missingFields.add("Введите Масть")
            }
            if (selectedGenderText.isBlank()) {
                missingFields.add("Пол животного")
            }

            if (missingFields.isEmpty()) {
                val intent = Intent(activity, CameraActivity::class.java)
                intent.putExtra("saveType", binding.saveType.text.toString())
                intent.putExtra("birthDateText", binding.birthDateText.text.toString())
                intent.putExtra("saveBreed", binding.saveBreed.text.toString())
                intent.putExtra("emailEt1", binding.emailEt1.text.toString())
                intent.putExtra("saveColor", binding.saveColor.text.toString())
                intent.putExtra("genderAnimal", selectedGenderText)
                Log.d("saveType", binding.saveType.text.toString())
                activity.startActivity(intent)
            } else {
                // Сообщение предупреждения с перечислением не заполненных полей
                val missingFieldsMessage =
                    "Заполните следующие поля: ${missingFields.joinToString(", ")}"
                val alertDialog = AlertDialog.Builder(activity)
                    .setTitle("Предупреждение")
                    .setMessage(missingFieldsMessage)
                    .setPositiveButton("OK", null) // Можете добавить обработчик, если нужно
                    .show()
            }
        }
    }

    //DatePicker животного==========================================================================
    fun showDatePickerDialog() {
        val getDate = Calendar.getInstance()
        val datepicker = DatePickerDialog(
            activity,
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

    //Тип животного==========================================================================
    fun showBottomTypeRadioButtonDialog() {
        val dialogBinding =
            DialogBottomSheetTypeAnimalBinding.inflate(LayoutInflater.from(activity))
        val bottomTypeSheetDialog = BottomSheetDialog(activity)
        bottomTypeSheetDialog.setContentView(dialogBinding.root)

        // Массив RadioButton
        val radioButtons = arrayOf(
            dialogBinding.option1,
            dialogBinding.option2,
            dialogBinding.option3,
            dialogBinding.option4,
            dialogBinding.option5
        )

        val dialog = bottomTypeSheetDialog.create()

        // Устанавливаем слушатель для RadioButton
        radioButtons.forEachIndexed { index, radioButton ->
            radioButton.setOnClickListener {
                binding.saveType.text = radioButton.text.toString()

                // Устанавливаем выбранный RadioButton активным
                radioButton.isChecked = true

                // Сохраняем индекс выбранного RadioButton
                selectedBottomTypeRadioButtonIndex = index

                Handler().postDelayed({
                    bottomTypeSheetDialog.dismiss()
                }, 500)
            }
        }

        // При повторном открытии диалога устанавливаем выбранный RadioButton активным
        if (selectedBottomTypeRadioButtonIndex != -1) {
            radioButtons[selectedBottomTypeRadioButtonIndex].isChecked = true
        }

        bottomTypeSheetDialog.show()
    }

    //Масть животного==========================================================================
    fun showBottomRadioButtonDialog() {
        val dialogBinding =
            DialogBottomSheetAnimalColorBinding.inflate(LayoutInflater.from(activity))
        val bottomSheetDialog = BottomSheetDialog(activity)
        bottomSheetDialog.setContentView(dialogBinding.root)

        // Массив RadioButton
        val radioButtons = arrayOf(
            dialogBinding.option1,
            dialogBinding.option2,
            dialogBinding.option3,
            dialogBinding.option4
        )

        val dialogColor = bottomSheetDialog.create()

        // Устанавливаем слушатель для RadioButton
        radioButtons.forEachIndexed { index, radioButton ->
            radioButton.setOnClickListener {
                binding.saveColor.text = radioButton.text.toString()

                // Устанавливаем выбранный RadioButton активным
                radioButton.isChecked = true

                // Сохраняем индекс выбранного RadioButton
                selectedBottomRadioButtonIndex = index

                Handler().postDelayed({
                    bottomSheetDialog.dismiss()
                }, 500)
            }
        }

        // При повторном открытии диалога устанавливаем выбранный RadioButton активным
        if (selectedBottomRadioButtonIndex != -1) {
            radioButtons[selectedBottomRadioButtonIndex].isChecked = true
        }

        bottomSheetDialog.show()
    }
    //Порода животного==========================================================================

    fun showRadioButtonDialog() {
        val dialogBinding = DialogRadioButtonsBinding.inflate(LayoutInflater.from(activity))
        val builder = AlertDialog.Builder(activity)
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
