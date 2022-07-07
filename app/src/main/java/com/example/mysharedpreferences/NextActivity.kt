package com.example.mysharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityNextBinding

class NextActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNextBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityNextBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initUI()
    }
    fun initUI(){
        binding.btnCerrarSesion.setOnClickListener {
            prefs.cleanData()
            onBackPressed()
        }
        val userName = prefs.getName()
        binding.tvNombre.text = "¡Hola $userName!"
        if (prefs.getColorCheck()){
            binding.clFondo.setBackgroundColor(ContextCompat.getColor(this, R.color.teal_200))
        }
    }
}