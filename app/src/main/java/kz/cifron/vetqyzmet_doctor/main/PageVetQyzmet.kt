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
    private var isDrawerOpen = false // Изначально предполагаем, что панель закрыта

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageVetQyzmetBinding.inflate(layoutInflater)
        setContentView(binding.root)

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



        drawerLayout = binding.drawer

        binding.apply {
            btnNavView.setOnClickListener {
                // Открываем drawer
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

        // Устанавливаем обработчик закрытия drawer
        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        drawerLayout.addDrawerListener(object : DrawerLayout.DrawerListener {
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                // Вызывается при изменении состояния панели (при открытии или закрытии)
                // slideOffset - это значение от 0 до 1, где 0 - закрыта, 1 - полностью открыта
                isDrawerOpen = slideOffset > 0.5 // Задайте желаемый порог открытия панели
                // Обновляем состояние кнопок при изменении панели
                updateButtonClickableState()
            }

            override fun onDrawerOpened(drawerView: View) {
                // Вызывается, когда панель открывается
            }

            override fun onDrawerClosed(drawerView: View) {
                // Вызывается, когда панель закрывается
            }

            override fun onDrawerStateChanged(newState: Int) {
                // Вызывается при изменении состояния панели
            }
        })

        binding.userNameText.text = intent.getStringExtra("name")
        binding.userCityText.text = intent.getStringExtra("location")
        binding.userId.text = intent.getStringExtra("userId")
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        // Вызывается после завершения создания активити

        // Изначально устанавливаем состояние кнопок в зависимости от значения isDrawerOpen
        updateButtonClickableState()
    }

    private fun updateButtonClickableState() {
        // Обновляем состояние кнопок в зависимости от значения isDrawerOpen
        if (isDrawerOpen) {
            binding.registr.isClickable = false
            binding.migration.isClickable = false
            binding.form.isClickable = false
            binding.certificates.isClickable = false
        } else {
            binding.registr.isClickable = true
            binding.migration.isClickable = true
            binding.form.isClickable = true
            binding.certificates.isClickable = true
        }
    }
}

//        binding.drawerLayout // Ваш DrawerLayout
//        binding.myNavigationView // Ваш NavigationView
//        toggle = ActionBarDrawerToggle(
//            this,
//            binding.drawerLayout,
//            R.string.open,
//            R.string.close
//        )


//        binding.myNavigationView.setNavigationItemSelectedListener { menuItem ->
//            when (menuItem.itemId) {
//                R.id.nav_profile -> {
//                    val userName = "John Doe" // Замените этим вашим источником данных
//                    val intent = Intent(this, HeaderPageActivity::class.java)
//                    intent.putExtra("userName", userName)
//                    startActivity(intent)
//                    return@setNavigationItemSelectedListener true
//                }
//                // Другие обработчики навигационных элементов...
//                else -> {
//                    // Обработка других элементов меню
//                    return@setNavigationItemSelectedListener false
//                }
//            }
//        }


//        // Получите ActionBar
//        val actionBar = supportActionBar
//        actionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
//        actionBar?.setCustomView(kz.cifron.vetqyzmet_doctor.R.layout.custom_actionbar_layout)
//        // новый который я устоновил! значок гамбургера
//        actionBar?.setHomeAsUpIndicator(R.drawable.ic_my_dark_menu)
//        // для активности вкл
//        actionBar?.setDisplayHomeAsUpEnabled(true)
//        actionBar?.setHomeButtonEnabled(true)
//
//        binding.drawerLayout.addDrawerListener(toggle)
//
//        val titleTextView =
//            actionBar?.customView?.findViewById<TextView>(kz.cifron.vetqyzmet_doctor.R.id.action_bar_title)
//        titleTextView?.text = "VetQyzmet" // Замените на ваш заголовок
//        supportActionBar?.setDisplayHomeAsUpEnabled(true) //back icon display when hamburger opened


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        when (item.itemId) {
//            kz.cifron.vetqyzmet_doctor.R.id.LogOut -> {
//                val intent = Intent(this, LoginActivity::class.java)
//                startActivity(intent)
//                finish()
//
//                return true
//            }
//
//            else -> {
//                // Проверьте, было ли нажатие обработано бургер-меню
//                if (toggle.onOptionsItemSelected(item)) {
//                    return true
//                }
//                return super.onOptionsItemSelected(item)
//            }
//        }
//    }

//    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
//        menuInflater.inflate(kz.cifron.vetqyzmet_doctor.R.menu.main_menu, menu)
//        return super.onCreateOptionsMenu(menu)
//    }

