package kz.cifron.vetqyzmet_doctor.main

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kz.cifron.vetqyzmet_doctor.databinding.ActivityPageVetQyzmetBinding
import kz.cifron.vetqyzmet_doctor.loginData.LoginActivity
import kz.cifron.vetqyzmet_doctor.main.vetQyzmetPages.AnimalRegActivity
import kz.cifron.vetqyzmet_doctor.main.vetQyzmetPages.CertificatesActivity
import kz.cifron.vetqyzmet_doctor.main.vetQyzmetPages.FormActivity
import kz.cifron.vetqyzmet_doctor.main.vetQyzmetPages.MigrationActivity


class PageVetQyzmet : AppCompatActivity() {
    private lateinit var binding: ActivityPageVetQyzmetBinding
    lateinit var toggle: ActionBarDrawerToggle

    //    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageVetQyzmetBinding.inflate(layoutInflater)
        setContentView(binding.root)
//
//        var drawable = ResourcesCompat.getDrawable(resources, kz.cifron.vetqyzmet_doctor.R.drawable., null)
//        drawable = DrawableCompat.wrap(drawable!!)
//        DrawableCompat.setTint(drawable, Color.BLACK)
//        actionBar!!.setHomeAsUpIndicator(drawable)
//        actionBar.setHomeAsUpIndicator(kz.cifron.vetqyzmet_doctor.R.drawable.ic_my_dark_menu);


        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true) // Включает кнопку "Домой"
            setHomeAsUpIndicator(kz.cifron.vetqyzmet_doctor.R.drawable.ic_my_dark_menu) // Устанавливает значок
        }

        // Устанавливаем пользовательский макет для ActionBar
        val actionBar = supportActionBar
        actionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        actionBar?.setCustomView(kz.cifron.vetqyzmet_doctor.R.layout.custom_actionbar_layout)

        // Найдем TextView в пользовательском макете и установим текст
        val titleTextView = actionBar?.customView?.findViewById<TextView>(kz.cifron.vetqyzmet_doctor.R.id.action_bar_title)
        titleTextView?.text = "VetQyzmet" // Замените на ваш заголовок


        binding.registr.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    AnimalRegActivity::class.java
                )
            )
        }
        binding.migration.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    MigrationActivity::class.java
                )
            )
        }
        binding.form.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    FormActivity::class.java
                )
            )
        }
        binding.certificates.setOnClickListener {

            startActivity(
                Intent(
                    this,
                    CertificatesActivity::class.java
                )
            )
        }

        val drawerLayout: DrawerLayout = findViewById(kz.cifron.vetqyzmet_doctor.R.id.drawerLayout)
        val navView: NavigationView = findViewById(kz.cifron.vetqyzmet_doctor.R.id.myNavigationView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, kz.cifron.vetqyzmet_doctor.R.string.open, kz.cifron.vetqyzmet_doctor.R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true) //back icon display when hamburger opened


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            kz.cifron.vetqyzmet_doctor.R.id.LogOut -> {
                // Обработайте нажатие кнопки "LogOut" здесь
                // Например, выполните выход из аккаунта и перейдите на страницу входа (логин)

                // Перейдите на страницу входа (логин)
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)

                // Завершите текущую активность, чтобы пользователь не мог вернуться по кнопке "назад"
                finish()

                return true
            }

            else -> {
                // Проверьте, было ли нажатие обработано бургер-меню
                if (toggle.onOptionsItemSelected(item)) {
                    return true
                }
                return super.onOptionsItemSelected(item)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(kz.cifron.vetqyzmet_doctor.R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)


    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            R.id.LogOut -> {
//                finish()
//            }
//        }
//        return super.onOptionsItemSelected(item)
//    }


}