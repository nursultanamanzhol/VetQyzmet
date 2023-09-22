package kz.cifron.vetqyzmet_doctor.loginData

import android.content.Context
import android.content.SharedPreferences

class UserManager(private val context: Context) {
    private val sharedPreferences: SharedPreferences = context.getSharedPreferences("user_data", Context.MODE_PRIVATE)

    fun saveUserInfo(email: String, password: String) {
        val editor = sharedPreferences.edit()
        editor.putString("email", email)
        editor.putString("password", password)
        editor.apply()
    }

    fun getSavedUserInfo(): Pair<String, String>? {
        val email = sharedPreferences.getString("email", null)
        val password = sharedPreferences.getString("password", null)
        return if (!email.isNullOrBlank() && !password.isNullOrBlank()) {
            Pair(email, password)
        } else {
            null
        }
    }
}
