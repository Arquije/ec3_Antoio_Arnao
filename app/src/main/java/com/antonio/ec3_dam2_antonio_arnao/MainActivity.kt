package com.antonio.ec3_dam2_antonio_arnao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.antonio.ec3_dam2_antonio_arnao.databinding.ActivityMainBinding
import com.antonio.ec3_dam2_antonio_arnao.views.BasketballFragment
import com.antonio.ec3_dam2_antonio_arnao.views.FavoritFragment
import com.antonio.ec3_dam2_antonio_arnao.views.InfoFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        replaceFragment(InfoFragment())

        binding.bottomNavigation.setOnItemSelectedListener {
            when(it.itemId){
                R.id.info -> replaceFragment(InfoFragment())
                R.id.jugadores -> replaceFragment(BasketballFragment())
                R.id.favoritos -> replaceFragment(FavoritFragment())

                else -> {

                }
            }
            true
        }
    }

    private fun replaceFragment(fragment : Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }
}