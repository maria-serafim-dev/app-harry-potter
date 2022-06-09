package com.example.appharrypotter.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.appharrypotter.databinding.ActivityMainBinding
import com.example.appharrypotter.fragment.ListaPersonagensFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        iniciarFragment()
    }

    private fun iniciarFragment() {
        val fragment = ListaPersonagensFragment()
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(binding.fragmentMain.id, fragment)
        fragmentTransaction.commit()
    }

}