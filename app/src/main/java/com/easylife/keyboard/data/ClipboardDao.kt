package com.easylife.keyboard.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface ClipboardDao {
    
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: ClipboardItem): Long
    
    @Update
    suspend fun updateItem(item: ClipboardItem)
    
    @Delete
    suspend fun deleteItem(item: ClipboardItem)
    
    @Query("DELETE FROM clipboard_items WHERE id = :id")
    suspend fun deleteItemById(id: Int)
    
    @Query("SELECT * FROM clipboard_items ORDER BY createdAt DESC LIMIT :limit")
    fun getAllItems(limit: Int = 50): Flow<List<ClipboardItem>>
    
    @Query("SELECT * FROM clipboard_items WHERE isPinned = 1 ORDER BY createdAt DESC")
    fun getPinnedItems(): Flow<List<ClipboardItem>>
    
    @Query("SELECT * FROM clipboard_items WHERE type = :type ORDER BY createdAt DESC LIMIT :limit")
    fun getItemsByType(type: String, limit: Int = 50): Flow<List<ClipboardItem>>
    
    @Query("SELECT * FROM clipboard_items WHERE content LIKE '%' || :query || '%' OR fileName LIKE '%' || :query || '%' ORDER BY createdAt DESC")
    fun searchItems(query: String): Flow<List<ClipboardItem>>
    
    @Query("SELECT * FROM clipboard_items WHERE folder = :folder ORDER BY createdAt DESC")
    fun getItemsByFolder(folder: String): Flow<List<ClipboardItem>>
    
    @Query("SELECT * FROM clipboard_items WHERE tags LIKE '%' || :tag || '%' ORDER BY createdAt DESC")
    fun getItemsByTag(tag: String): Flow<List<ClipboardItem>>
    
    @Query("SELECT COUNT(*) FROM clipboard_items")
    suspend fun getItemCount(): Int
    
    @Query("DELETE FROM clipboard_items WHERE createdAt < :timestamp")
    suspend fun deleteOldItems(timestamp: Long)
    
    @Query("DELETE FROM clipboard_items")
    suspend fun clearAll()
    
    @Query("SELECT DISTINCT folder FROM clipboard_items WHERE folder IS NOT NULL")
    fun getAllFolders(): Flow<List<String>>
    
    @Query("UPDATE clipboard_items SET isPinned = :isPinned WHERE id = :id")
    suspend fun updatePinStatus(id: Int, isPinned: Boolean)
}
