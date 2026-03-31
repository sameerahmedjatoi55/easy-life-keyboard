package com.easylife.keyboard.ime

import android.inputmethodservice.InputMethodService
import android.view.KeyEvent

class EasyLifeKeyboardService : InputMethodService() {
    override fun onStartInput(attribute: android.view.inputmethod.EditorInfo?, restarting: Boolean) {
        super.onStartInput(attribute, restarting)
    }
}
