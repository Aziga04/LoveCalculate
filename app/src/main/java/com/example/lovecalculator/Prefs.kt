package com.example.lovecalculator

import android.content.Context
import android.content.SharedPreferences

class Prefs(private val context: Context) {

    private val pref: SharedPreferences =
        context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

    fun saveState() {
        pref.edit().putBoolean(ON_BOARDING_SING, true).apply()
    }

    fun isShown(): Boolean {
        return pref.getBoolean(ON_BOARDING_SING, false)

    }


    companion object {

        private const val PREF_NAME = "pref"
        private const val ON_BOARDING_SING = "is_seen"
    }
}