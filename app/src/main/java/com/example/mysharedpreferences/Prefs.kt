package com.example.mysharedpreferences

import android.content.Context
import android.graphics.Color
import android.widget.Spinner

class Prefs(val context:Context) {
    val DATABASE = "MyDB"
    val USER_NAME = "UserName"
    val Color = "Color"
    val Spinner = "Spinner"
    val storage = context.getSharedPreferences(DATABASE,
        Context.MODE_PRIVATE)

    fun saveName(name:String){
        storage.edit().putString(USER_NAME, name).apply()
    }

    fun saveColor(color:Boolean){
        storage.edit().putBoolean(Color, color).apply()
    }

    fun getName():String{
        return storage.getString(USER_NAME, "")!!
    }

    fun getColorCheck():Boolean{
        return storage.getBoolean(Color, false)
    }

    fun saveSpinner():Boolean{
        return storage.getBoolean(Spinner,false)
    }

    fun cleanData(){
        storage.edit().clear().apply()
    }
}