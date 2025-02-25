package com.nativelocalstorage

import android.content.Context
import android.content.SharedPreferences
import com.facebook.react.bridge.ReactApplicationContext
import com.nativelocalstorage.NativeLocalStorageSpec

class NativeLocalStorageModule(reactContext: ReactApplicationContext) : NativeLocalStorageSpec(reactContext) {

    override fun getName() = NAME

    override fun setItem(value: String, key: String) {
        val sharedPref = getReactApplicationContext().getSharedPreferences("StoragePrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putString(key, value)
        editor.apply()
    }

    override fun getItem(key: String): String? {
        val sharedPref = getReactApplicationContext().getSharedPreferences("StoragePrefs", Context.MODE_PRIVATE)
        val item = sharedPref.getString(key, null)
        return item.toString()
    }

    override fun removeItem(key: String) {
        val sharedPref = getReactApplicationContext().getSharedPreferences("StoragePrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.remove(key)
        editor.apply()
    }

    override fun clear() {
        val sharedPref = getReactApplicationContext().getSharedPreferences("StoragePrefs", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.clear()
        editor.apply()
    }

    companion object {
        const val NAME = "NativeLocalStorage"
    }
}