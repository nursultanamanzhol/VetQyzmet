package kz.cifron.vetqyzmet_doctor.loginData

import android.content.Context
import androidx.security.crypto.EncryptedSharedPreferences
import androidx.security.crypto.MasterKey

class UserManager(private val context: Context) {
    private val sharedPreferences = EncryptedSharedPreferences.create(
        context,
        "user_data",
        MasterKey.Builder(context)
            .setKeyScheme(MasterKey.KeyScheme.AES256_GCM)
            .build(),
        EncryptedSharedPreferences.PrefKeyEncryptionScheme.AES256_SIV,
        EncryptedSharedPreferences.PrefValueEncryptionScheme.AES256_GCM
    )

    fun saveUserInfo(email: String, password: String) {
        sharedPreferences.edit()
            .putString("email", email)
            .putString("password", password)
            .apply()
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
