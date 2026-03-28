package com.easylife.keyboard.data

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "clipboard_items")
data class ClipboardItem(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val content: String = "",
    val type: String = "text", // text, image, video, document
    val filePath: String? = null,
    val fileName: String? = null,
    val fileSize: Long = 0,
    val mimeType: String? = null,
    val isPinned: Boolean = false,
    val folder: String? = null,
    val tags: String? = null, // comma-separated
    val createdAt: Long = System.currentTimeMillis(),
    val thumbnailPath: String? = null
) : Serializable
