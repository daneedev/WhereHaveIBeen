package dev.danee.wherehaveibeen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navBar = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        navBar.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.overview_button -> {
                    replaceFragment(OverviewFragment())
                    true
                }
                R.id.upload_button -> {
                    replaceFragment(UploadFragment())
                    true
                }
                R.id.account_button -> {
                    replaceFragment(AccountFragment())
                    true
                }
                else -> false
            }
        }
    }

    fun replaceFragment(fragment: Fragment) {
        val fragmentMgr = supportFragmentManager
        val fragmentTransaction = fragmentMgr.beginTransaction()
        fragmentTransaction.replace(R.id.frame_container, fragment)
        fragmentTransaction.commit()
    }
}