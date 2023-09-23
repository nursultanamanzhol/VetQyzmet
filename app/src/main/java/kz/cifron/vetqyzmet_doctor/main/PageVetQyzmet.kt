package kz.cifron.vetqyzmet_doctor.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import kz.cifron.vetqyzmet_doctor.R
import kz.cifron.vetqyzmet_doctor.databinding.ActivityPageVetQyzmetBinding
import kz.cifron.vetqyzmet_doctor.loginData.LoginActivity
import kz.cifron.vetqyzmet_doctor.main.vetQyzmetPages.AnimalRegActivity
import kz.cifron.vetqyzmet_doctor.main.vetQyzmetPages.CertificatesActivity
import kz.cifron.vetqyzmet_doctor.main.vetQyzmetPages.FormActivity
import kz.cifron.vetqyzmet_doctor.main.vetQyzmetPages.MigrationActivity

class PageVetQyzmet : AppCompatActivity() {
    private lateinit var binding: ActivityPageVetQyzmetBinding
    lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawerLayout: DrawerLayout
    private var isDrawerOpen = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageVetQyzmetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupActionBarDrawerToggle()
        setupNavigationButtons()
        setupLogoutButton()
        setupUserInfo()
    }

    private fun setupActionBarDrawerToggle() {
        drawerLayout = binding.drawer
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                isDrawerOpen = slideOffset > 0.5
                updateButtonClickableState()
            }

            override fun onDrawerOpened(drawerView: View) {}

            override fun onDrawerClosed(drawerView: View) {}

            override fun onDrawerStateChanged(newState: Int) {}
        })
    }

    private fun setupNavigationButtons() {
        binding.apply {
            btnNavView.setOnClickListener {
                drawerLayout.openDrawer(GravityCompat.START)
            }

            registr.setOnClickListener {
                startActivity(Intent(this@PageVetQyzmet, AnimalRegActivity::class.java))
            }

            migration.setOnClickListener {
                startActivity(Intent(this@PageVetQyzmet, MigrationActivity::class.java))
            }

            form.setOnClickListener {
                startActivity(Intent(this@PageVetQyzmet, FormActivity::class.java))
            }

            certificates.setOnClickListener {
                startActivity(Intent(this@PageVetQyzmet, CertificatesActivity::class.java))
            }
        }
    }

    private fun setupLogoutButton() {
        binding.logOutIcon.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }

        binding.bottomCustom.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    private fun setupUserInfo() {
        binding.userNameText.text = intent.getStringExtra("name")
        binding.userCityText.text = intent.getStringExtra("location")
        binding.userId.text = intent.getStringExtra("userId")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        updateButtonClickableState()
    }

    private fun updateButtonClickableState() {
        val buttons = arrayOf(
            binding.registr,
            binding.migration,
            binding.form,
            binding.certificates
        )

        val clickable = !isDrawerOpen

        for (button in buttons) {
            button.isClickable = clickable
        }
    }
}
