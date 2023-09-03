package kz.cifron.vetqyzmet_doctor

import android.app.Dialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.widget.*
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.lifecycle.ViewModelProvider
import kz.cifron.vetqyzmet_doctor.databinding.ActivityMainBinding
import kz.cifron.vetqyzmet_doctor.mydate.LoginRepository
import kz.cifron.vetqyzmet_doctor.mydate.LoginState
import kz.cifron.vetqyzmet_doctor.mydate.LoginViewModel
import kz.cifron.vetqyzmet_doctor.mydate.LoginViewModelFactory
import kz.cifron.vetqyzmet_doctor.mydate.RetrofitClient
import kz.cifron.vetqyzmet_doctor.mydate.User
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val calendar = Calendar.getInstance().time
        val dateFormat = SimpleDateFormat("dd MMMM", Locale.getDefault())
        binding.dateFormat.text = dateFormat.format(calendar)

        val apiService = RetrofitClient.instanceApi
        val repository = LoginRepository(apiService)
        viewModel = ViewModelProvider(this, LoginViewModelFactory(repository, this))[LoginViewModel::class.java]

        val savedUserInfo = viewModel.getSavedUserInfo()
        savedUserInfo?.let { (savedEmail, savedPassword) ->
            binding.emailEt1.setText(savedEmail)
            binding.passwordEt1.setText(savedPassword)
        }

        binding.loginBtn.setOnClickListener {
            val email = binding.emailEt1.text.toString()
            val password = binding.passwordEt1.text.toString()
            viewModel.performLogin(email, password)
        }

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.loginStateLiveData.observe(this) { loginState ->
            when (loginState) {
                is LoginState.Success -> handleSuccessState(loginState.user, loginState.token)
                is LoginState.Error -> handleErrorState()
                LoginState.Loading -> showLoadingState()
            }
        }
    }

    private fun showLoadingState() {
        binding.progressBar.visibility = View.VISIBLE
        binding.loginBtn.isEnabled = false
    }

    private fun handleErrorState() {
        binding.progressBar.visibility = View.GONE
        binding.loginBtn.isEnabled = true
        showCustomDialog()
    }

    private fun handleSuccessState(user: User, token: String) {
        val intent = Intent(this, PageVetQyzmet::class.java)
        startActivity(intent)
        finish()
    }

    //Error Dialog icon
    private fun showCustomDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_error)
        val iconImageView = dialog.findViewById<ImageView>(R.id.iconImageView)
        val messageTextView = dialog.findViewById<TextView>(R.id.messageTextView)
        val window = dialog.window
        window?.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        dialog.show()
    }


    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.LogOut -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
