package com.easylife.keyboard.data

data class ClipboardItem(
    val id: Int = 0,
    val content: String = "",
    val type: String = "text",
    val timestamp: Long = 0,
    val isPinned: Boolean = false
)
