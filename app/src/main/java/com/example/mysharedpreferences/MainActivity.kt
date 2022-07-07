package com.example.mysharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initUI()
        checkUserValues()
    }
    fun initUI(){
        binding.btnEntrar.setOnClickListener {
            accessSharedPreferences()
        }


    }
    private fun checkUserValues(){
        }
    fun chesckUserValues(){
        if (prefs.getName().isNotEmpty()){
            goAccess()
         }
    }
    fun accessSharedPreferences(){
        if (binding.etNombre.text.toString().isNotEmpty()){
            prefs.saveName(binding.etNombre.text.toString())
            prefs.saveColor(binding.cbColor.isChecked)
            goAccess()
        }else {
            Toast.makeText(this, "Rellene este parametro", Toast.LENGTH_LONG).show()
        }
    }
    private fun goAccess(){
        startActivity(Intent(this, NextActivity::class.java))
    }
}