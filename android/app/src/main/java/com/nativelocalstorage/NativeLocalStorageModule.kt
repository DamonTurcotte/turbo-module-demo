package com.nativelocalstorage

import android.content.Context
import android.content.SharedPreferences
import com.facebook.react.bridge.ReactApplicationContext
import com.nativelocalstorage.NativeLocalStorageSpec

class NativeLocalStorageModule(reactContext: ReactApplicationContext) : NativeLocalStorageSpec(reactContext) {
    private val sharedPreferences: SharedPreferences = reactContext.getSharedPreferences("StoragePrefs", Context.MODE_PRIVATE)

    override fun getName() = NAME

    override fun setItem(key: String, value: String) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    override fun getItem(key: String): String? {
        val item = sharedPreferences.getString(key, null)
        return item.toString()
    }

    override fun removeItem(key: String) {
        sharedPreferences.edit().remove(key).apply()
    }

    override fun clear() {
        sharedPreferences.edit().clear().apply()
    }

    companion object {
        const val NAME = "NativeLocalStorage"
    }
}