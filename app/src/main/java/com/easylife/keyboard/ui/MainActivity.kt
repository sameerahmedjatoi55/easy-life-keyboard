package com.easylife.keyboard.ui

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.easylife.keyboard.R
import com.easylife.keyboard.data.ClipboardRepository

class MainActivity : AppCompatActivity() {
    
    private lateinit var repository: ClipboardRepository
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        repository = ClipboardRepository(this)
        
        setupUI()
    }
    
    private fun setupUI() {
        // Set as default keyboard button
        val setDefaultButton = findViewById<android.widget.Button>(R.id.btn_set_default)
        setDefaultButton.setOnClickListener {
            openKeyboardSettings()
        }
        
        // Upload Manager button
        val uploadManagerButton = findViewById<android.widget.Button>(R.id.btn_upload_manager)
        uploadManagerButton.setOnClickListener {
            startActivity(Intent(this, UploadManagerActivity::class.java))
        }
        
        // Settings button
        val settingsButton = findViewById<android.widget.Button>(R.id.btn_settings)
        settingsButton.setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
        
        updateKeyboardStatus()
    }
    
    private fun openKeyboardSettings() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            startActivity(Intent(Settings.ACTION_KEYBOARD_SETTINGS))
        } else {
            startActivity(Intent(Settings.ACTION_INPUT_METHOD_SETTINGS))
        }
    }
    
    private fun updateKeyboardStatus() {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        val statusTextView = findViewById<android.widget.TextView>(R.id.tv_keyboard_status)
        
        val isDefault = isKeyboardDefault()
        statusTextView.text = if (isDefault) {
            getString(R.string.status_default_keyboard)
        } else {
            getString(R.string.status_not_default)
        }
    }
    
    private fun isKeyboardDefault(): Boolean {
        val imm = getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
        val defaultIme = Settings.Secure.getString(contentResolver, Settings.Secure.DEFAULT_INPUT_METHOD)
        return defaultIme?.contains("com.easylife.keyboard") ?: false
    }
    
    override fun onResume() {
        super.onResume()
        updateKeyboardStatus()
    }
}
