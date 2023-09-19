package kz.cifron.vetqyzmet_doctor

import androidx.lifecycle.ViewModel

class AnimalViewModel : ViewModel() {
    var saveType: String = "ыыфввф"
    var selectedDate: String = "ыфвф"
    var emailEt1: String = "вфывф"
    var genderAnimal: String = "фвфы"
    var saveBreed: String = "фывыфвфв"
    override fun toString(): String {
        return "AnimalViewModel(saveType='$saveType', selectedDate='$selectedDate', emailEt1='$emailEt1', genderAnimal='$genderAnimal', saveBreed='$saveBreed')"
    }
}
