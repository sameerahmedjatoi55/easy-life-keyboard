package com.easylife.keyboard.data

import android.content.Context
import android.content.SharedPreferences
import androidx.preference.PreferenceManager
import kotlinx.coroutines.flow.Flow

class ClipboardRepository(private val context: Context) {
    
    private val database = AppDatabase.getDatabase(context)
    private val clipboardDao = database.clipboardDao()
    private val preferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    
    // Clipboard operations
    suspend fun addItem(item: ClipboardItem): Long {
        val maxItems = preferences.getInt("clipboard_limit", 50)
        val currentCount = clipboardDao.getItemCount()
        
        if (currentCount >= maxItems) {
            // Delete oldest item
            val allItems = clipboardDao.getAllItems(maxItems + 1).collect { items ->
                if (items.size > maxItems) {
                    clipboardDao.deleteItem(items.last())
                }
            }
        }
        
        return clipboardDao.insertItem(item)
    }
    
    suspend fun updateItem(item: ClipboardItem) {
        clipboardDao.updateItem(item)
    }
    
    suspend fun deleteItem(item: ClipboardItem) {
        clipboardDao.deleteItem(item)
    }
    
    suspend fun deleteItemById(id: Int) {
        clipboardDao.deleteItemById(id)
    }
    
    fun getAllItems(limit: Int = 50): Flow<List<ClipboardItem>> {
        return clipboardDao.getAllItems(limit)
    }
    
    fun getPinnedItems(): Flow<List<ClipboardItem>> {
        return clipboardDao.getPinnedItems()
    }
    
    fun getItemsByType(type: String, limit: Int = 50): Flow<List<ClipboardItem>> {
        return clipboardDao.getItemsByType(type, limit)
    }
    
    fun searchItems(query: String): Flow<List<ClipboardItem>> {
        return clipboardDao.searchItems(query)
    }
    
    fun getItemsByFolder(folder: String): Flow<List<ClipboardItem>> {
        return clipboardDao.getItemsByFolder(folder)
    }
    
    fun getItemsByTag(tag: String): Flow<List<ClipboardItem>> {
        return clipboardDao.getItemsByTag(tag)
    }
    
    suspend fun updatePinStatus(id: Int, isPinned: Boolean) {
        clipboardDao.updatePinStatus(id, isPinned)
    }
    
    fun getAllFolders(): Flow<List<String>> {
        return clipboardDao.getAllFolders()
    }
    
    suspend fun clearHistory() {
        clipboardDao.clearAll()
    }
    
    // Preferences
    fun getKeyboardHeight(): String {
        return preferences.getString("keyboard_height", "medium") ?: "medium"
    }
    
    fun setKeyboardHeight(height: String) {
        preferences.edit().putString("keyboard_height", height).apply()
    }
    
    fun getKeySize(): String {
        return preferences.getString("key_size", "normal") ?: "normal"
    }
    
    fun setKeySize(size: String) {
        preferences.edit().putString("key_size", size).apply()
    }
    
    fun isPredictiveTextEnabled(): Boolean {
        return preferences.getBoolean("predictive_text", true)
    }
    
    fun setPredictiveText(enabled: Boolean) {
        preferences.edit().putBoolean("predictive_text", enabled).apply()
    }
    
    fun isEmojiSuggestionsEnabled(): Boolean {
        return preferences.getBoolean("emoji_suggestions", true)
    }
    
    fun setEmojiSuggestions(enabled: Boolean) {
        preferences.edit().putBoolean("emoji_suggestions", enabled).apply()
    }
    
    fun isVibrationEnabled(): Boolean {
        return preferences.getBoolean("vibration", true)
    }
    
    fun setVibration(enabled: Boolean) {
        preferences.edit().putBoolean("vibration", enabled).apply()
    }
    
    fun isSoundEnabled(): Boolean {
        return preferences.getBoolean("sound", false)
    }
    
    fun setSound(enabled: Boolean) {
        preferences.edit().putBoolean("sound", enabled).apply()
    }
    
    fun getTheme(): String {
        return preferences.getString("theme", "auto") ?: "auto"
    }
    
    fun setTheme(theme: String) {
        preferences.edit().putString("theme", theme).apply()
    }
    
    fun getClipboardLimit(): Int {
        return preferences.getInt("clipboard_limit", 50)
    }
    
    fun setClipboardLimit(limit: Int) {
        preferences.edit().putInt("clipboard_limit", limit).apply()
    }
}
