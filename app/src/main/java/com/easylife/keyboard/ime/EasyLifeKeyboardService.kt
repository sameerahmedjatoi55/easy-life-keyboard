package com.easylife.keyboard.ime

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.inputmethodservice.InputMethodService
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.os.Build
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.TextUtils
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputConnection
import android.widget.FrameLayout
import androidx.lifecycle.lifecycleScope
import com.easylife.keyboard.R
import com.easylife.keyboard.data.AppDatabase
import com.easylife.keyboard.data.ClipboardItem
import com.easylife.keyboard.data.ClipboardRepository
import com.easylife.keyboard.ui.KeyboardViewManager
import kotlinx.coroutines.launch

class EasyLifeKeyboardService : InputMethodService(), KeyboardView.OnKeyboardActionListener {
    
    private lateinit var keyboardViewManager: KeyboardViewManager
    private lateinit var repository: ClipboardRepository
    private lateinit var vibrator: Vibrator
    private lateinit var clipboardManager: ClipboardManager
    
    private var currentKeyboard: Keyboard? = null
    private var isNumericMode = false
    private var isEmojiMode = false
    private var capsLock = false
    
    override fun onCreate() {
        super.onCreate()
        repository = ClipboardRepository(this)
        vibrator = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
    }
    
    override fun onCreateInputView(): View {
        keyboardViewManager = KeyboardViewManager(this)
        keyboardViewManager.setOnKeyboardActionListener(this)
        return keyboardViewManager.getView()
    }
    
    override fun onStartInput(attribute: EditorInfo?, restarting: Boolean) {
        super.onStartInput(attribute, restarting)
        isNumericMode = false
        isEmojiMode = false
        capsLock = false
        switchToQwertyKeyboard()
    }
    
    override fun onKey(primaryCode: Int, keyCodes: IntArray?) {
        val inputConnection = currentInputConnection ?: return
        
        when (primaryCode) {
            Keyboard.KEYCODE_DELETE -> {
                inputConnection.deleteSurroundingText(1, 0)
                playVibration()
            }
            Keyboard.KEYCODE_SHIFT -> {
                capsLock = !capsLock
                keyboardViewManager.setCapsLock(capsLock)
                playVibration()
            }
            KEYCODE_NUMERIC_TOGGLE -> {
                isNumericMode = !isNumericMode
                if (isNumericMode) {
                    switchToNumericKeyboard()
                } else {
                    switchToQwertyKeyboard()
                }
                playVibration()
            }
            KEYCODE_EMOJI_TOGGLE -> {
                isEmojiMode = !isEmojiMode
                if (isEmojiMode) {
                    switchToEmojiKeyboard()
                } else {
                    switchToQwertyKeyboard()
                }
                playVibration()
            }
            KEYCODE_EASY_LIFE_TAB -> {
                showClipboardManager()
                playVibration()
            }
            Keyboard.KEYCODE_DONE -> {
                inputConnection.sendKeyEvent(KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_ENTER))
                inputConnection.sendKeyEvent(KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_ENTER))
                playVibration()
            }
            else -> {
                if (primaryCode > 0) {
                    var character = primaryCode.toChar().toString()
                    if (capsLock && character.matches(Regex("[a-z]"))) {
                        character = character.uppercase()
                        capsLock = false
                        keyboardViewManager.setCapsLock(false)
                    }
                    inputConnection.commitText(character, 1)
                    playVibration()
                }
            }
        }
    }
    
    override fun onPress(primaryCode: Int) {
        // Haptic feedback on press
    }
    
    override fun onRelease(primaryCode: Int) {
        // Haptic feedback on release
    }
    
    override fun onText(text: CharSequence?) {
        currentInputConnection?.commitText(text, 1)
    }
    
    override fun swipeLeft() {
        // Optional: delete word
    }
    
    override fun swipeRight() {
        // Optional: add space
    }
    
    override fun swipeDown() {
        // Optional: dismiss keyboard
    }
    
    override fun swipeUp() {
        // Optional: show settings
    }
    
    private fun switchToQwertyKeyboard() {
        currentKeyboard = Keyboard(this, R.xml.qwerty)
        keyboardViewManager.setKeyboard(currentKeyboard!!)
        isNumericMode = false
        isEmojiMode = false
    }
    
    private fun switchToNumericKeyboard() {
        currentKeyboard = Keyboard(this, R.xml.numeric)
        keyboardViewManager.setKeyboard(currentKeyboard!!)
        isNumericMode = true
    }
    
    private fun switchToEmojiKeyboard() {
        // Emoji keyboard would be handled separately
        isEmojiMode = true
    }
    
    private fun showClipboardManager() {
        // Show clipboard manager UI
        lifecycleScope.launch {
            // Load clipboard items from database
            repository.getAllItems().collect { items ->
                // Display items in a UI overlay
            }
        }
    }
    
    private fun playVibration() {
        if (repository.isVibrationEnabled()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                vibrator.vibrate(VibrationEffect.createOneShot(30, VibrationEffect.DEFAULT_AMPLITUDE))
            } else {
                @Suppress("DEPRECATION")
                vibrator.vibrate(30)
            }
        }
    }
    
    companion object {
        private const val KEYCODE_NUMERIC_TOGGLE = -100
        private const val KEYCODE_EMOJI_TOGGLE = -101
        private const val KEYCODE_EASY_LIFE_TAB = -102
    }
}
