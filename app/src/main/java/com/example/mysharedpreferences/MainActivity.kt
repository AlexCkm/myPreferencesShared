package com.example.mysharedpreferences

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.mysharedpreferences.SharedPreferences.Companion.prefs
import com.example.mysharedpreferences.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private var opColor = "Color"
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivityMainBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getSpinner(binding.spinner)
        initUI()
        chesckUserValues()
    }

    fun initUI(){
        binding.btnEntrar.setOnClickListener {
            accessSharedPreferences()
        }


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
            prefs.saveSpinner()
            goAccess()
        }else {
            Toast.makeText(this, "Rellene este parametro", Toast.LENGTH_LONG).show()
        }
    }

    private fun goAccess(){
        startActivity(Intent(this, NextActivity::class.java))
    }

    fun getSpinner(spinner: Spinner){

        val adaptador: ArrayAdapter<*> = ArrayAdapter.createFromResource(this, R.array.Colores,
            android.R.layout.simple_spinner_dropdown_item)
        spinner.adapter = adaptador
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                opColor = parent?.getItemAtPosition(position).toString()
                msj(opColor)

            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                opColor = "Rojo"

            }
        }
    }

    fun msj(str:String){
        Toast.makeText(this@MainActivity, str, Toast.LENGTH_SHORT).show()
    }
}