package com.easylife.keyboard.ui

import android.content.Context
import android.inputmethodservice.Keyboard
import android.inputmethodservice.KeyboardView
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import android.widget.LinearLayout
import android.widget.TabHost
import android.widget.TabWidget
import android.widget.TextView
import com.easylife.keyboard.R

class KeyboardViewManager(private val context: Context) {
    
    private val rootView: FrameLayout = FrameLayout(context)
    private lateinit var keyboardView: KeyboardView
    private lateinit var clipboardView: View
    private lateinit var tabHost: TabHost
    
    init {
        setupUI()
    }
    
    private fun setupUI() {
        // Create tab host
        tabHost = TabHost(context)
        tabHost.setup()
        
        // Create keyboard tab
        val keyboardContainer = LinearLayout(context)
        keyboardContainer.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
        keyboardView = KeyboardView(context)
        keyboardView.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        keyboardContainer.addView(keyboardView)
        
        // Create Easy Life tab (clipboard manager)
        clipboardView = createClipboardView()
        
        // Add tabs
        tabHost.addTab(
            tabHost.newTabSpec("keyboard")
                .setIndicator("Keyboard")
                .setContent(keyboardContainer)
        )
        
        tabHost.addTab(
            tabHost.newTabSpec("easylife")
                .setIndicator("Easy Life")
                .setContent(clipboardView)
        )
        
        rootView.addView(tabHost, FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        ))
    }
    
    private fun createClipboardView(): View {
        val container = LinearLayout(context)
        container.layoutParams = FrameLayout.LayoutParams(
            FrameLayout.LayoutParams.MATCH_PARENT,
            FrameLayout.LayoutParams.MATCH_PARENT
        )
        container.orientation = LinearLayout.VERTICAL
        
        // Placeholder for clipboard items
        val placeholder = TextView(context)
        placeholder.text = "Clipboard items will appear here"
        placeholder.layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.MATCH_PARENT
        )
        container.addView(placeholder)
        
        return container
    }
    
    fun setKeyboard(keyboard: Keyboard) {
        keyboardView.keyboard = keyboard
    }
    
    fun setCapsLock(enabled: Boolean) {
        keyboardView.isShifted = enabled
        keyboardView.invalidateAllKeys()
    }
    
    fun setOnKeyboardActionListener(listener: KeyboardView.OnKeyboardActionListener) {
        keyboardView.setOnKeyboardActionListener(listener)
    }
    
    fun getView(): View {
        return rootView
    }
}
