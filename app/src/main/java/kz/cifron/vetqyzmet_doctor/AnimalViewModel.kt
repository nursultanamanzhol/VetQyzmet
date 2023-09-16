package kz.cifron.vetqyzmet_doctor

import androidx.lifecycle.ViewModel

class AnimalViewModel : ViewModel() {
    var saveType: String = ""
    var selectedDate: String = ""
    var emailEt1: String = ""
    var genderAnimal: String = ""
    var saveBreed: String = ""
    override fun toString(): String {
        return "AnimalViewModel(saveType='$saveType', selectedDate='$selectedDate', emailEt1='$emailEt1', genderAnimal='$genderAnimal', saveBreed='$saveBreed')"
    }
}
