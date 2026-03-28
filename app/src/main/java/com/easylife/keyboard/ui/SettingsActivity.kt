package com.easylife.keyboard.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceFragmentCompat
import com.easylife.keyboard.R
import com.easylife.keyboard.data.ClipboardRepository

class SettingsActivity : AppCompatActivity() {
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings, SettingsFragment())
                .commit()
        }
        
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
    
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
    
    class SettingsFragment : PreferenceFragmentCompat() {
        
        private lateinit var repository: ClipboardRepository
        
        override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
            setPreferencesFromResource(R.xml.preferences, rootKey)
            
            repository = ClipboardRepository(requireContext())
            setupPreferences()
        }
        
        private fun setupPreferences() {
            // Keyboard height preference
            val keyboardHeightPref = findPreference<androidx.preference.ListPreference>("keyboard_height")
            keyboardHeightPref?.setOnPreferenceChangeListener { _, newValue ->
                repository.setKeyboardHeight(newValue as String)
                true
            }
            
            // Key size preference
            val keySizePref = findPreference<androidx.preference.ListPreference>("key_size")
            keySizePref?.setOnPreferenceChangeListener { _, newValue ->
                repository.setKeySize(newValue as String)
                true
            }
            
            // Predictive text preference
            val predictiveTextPref = findPreference<androidx.preference.SwitchPreferenceCompat>("predictive_text")
            predictiveTextPref?.setOnPreferenceChangeListener { _, newValue ->
                repository.setPredictiveText(newValue as Boolean)
                true
            }
            
            // Emoji suggestions preference
            val emojiPref = findPreference<androidx.preference.SwitchPreferenceCompat>("emoji_suggestions")
            emojiPref?.setOnPreferenceChangeListener { _, newValue ->
                repository.setEmojiSuggestions(newValue as Boolean)
                true
            }
            
            // Vibration preference
            val vibrationPref = findPreference<androidx.preference.SwitchPreferenceCompat>("vibration")
            vibrationPref?.setOnPreferenceChangeListener { _, newValue ->
                repository.setVibration(newValue as Boolean)
                true
            }
            
            // Sound preference
            val soundPref = findPreference<androidx.preference.SwitchPreferenceCompat>("sound")
            soundPref?.setOnPreferenceChangeListener { _, newValue ->
                repository.setSound(newValue as Boolean)
                true
            }
            
            // Clipboard limit preference
            val clipboardLimitPref = findPreference<androidx.preference.ListPreference>("clipboard_limit")
            clipboardLimitPref?.setOnPreferenceChangeListener { _, newValue ->
                repository.setClipboardLimit((newValue as String).toInt())
                true
            }
            
            // Theme preference
            val themePref = findPreference<androidx.preference.ListPreference>("theme")
            themePref?.setOnPreferenceChangeListener { _, newValue ->
                repository.setTheme(newValue as String)
                true
            }
            
            // Clear history preference
            val clearHistoryPref = findPreference<androidx.preference.Preference>("clear_history")
            clearHistoryPref?.setOnPreferenceClickListener {
                // Clear clipboard history
                true
            }
        }
    }
}
