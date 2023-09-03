package kz.cifron.vetqyzmet_doctor

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import kz.cifron.vetqyzmet_doctor.databinding.ActivityPageVetQyzmetBinding

class PageVetQyzmet : AppCompatActivity() {
    private lateinit var binding: ActivityPageVetQyzmetBinding
    lateinit var toggle: ActionBarDrawerToggle

    //    lateinit var drawerLayout: DrawerLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPageVetQyzmetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.navigate1.setOnClickListener {
            startActivity(
                Intent(
                    this,
                    AnimalRegActivity::class.java
                )
            )
        }

        val drawerLayout: DrawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.myNavigationView)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true) //back icon display when hamburger opened


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)) {
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
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