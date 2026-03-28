package com.easylife.keyboard.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.easylife.keyboard.R
import com.easylife.keyboard.data.ClipboardItem
import com.easylife.keyboard.data.ClipboardRepository
import kotlinx.coroutines.launch
import java.io.File
import java.io.FileOutputStream

class UploadManagerActivity : AppCompatActivity() {
    
    private lateinit var repository: ClipboardRepository
    private var selectedFileUri: Uri? = null
    private var selectedFileType: String = "text"
    
    private val REQUEST_IMAGE = 1
    private val REQUEST_VIDEO = 2
    private val REQUEST_DOCUMENT = 3
    
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_upload_manager)
        
        repository = ClipboardRepository(this)
        setupUI()
    }
    
    private fun setupUI() {
        // Photo button
        findViewById<Button>(R.id.btn_photo).setOnClickListener {
            pickImage()
        }
        
        // Video button
        findViewById<Button>(R.id.btn_video).setOnClickListener {
            pickVideo()
        }
        
        // Document button
        findViewById<Button>(R.id.btn_document).setOnClickListener {
            pickDocument()
        }
        
        // Upload button
        findViewById<Button>(R.id.btn_upload).setOnClickListener {
            uploadFile()
        }
    }
    
    private fun pickImage() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_IMAGE)
    }
    
    private fun pickVideo() {
        val intent = Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI)
        startActivityForResult(intent, REQUEST_VIDEO)
    }
    
    private fun pickDocument() {
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "*/*"
        intent.putExtra(Intent.EXTRA_MIME_TYPES, arrayOf("application/pdf", "application/msword", "application/vnd.ms-excel"))
        startActivityForResult(intent, REQUEST_DOCUMENT)
    }
    
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        
        if (resultCode == RESULT_OK && data != null) {
            selectedFileUri = data.data
            
            when (requestCode) {
                REQUEST_IMAGE -> {
                    selectedFileType = "image"
                    displayPreview()
                }
                REQUEST_VIDEO -> {
                    selectedFileType = "video"
                    displayPreview()
                }
                REQUEST_DOCUMENT -> {
                    selectedFileType = "document"
                    displayPreview()
                }
            }
        }
    }
    
    private fun displayPreview() {
        val previewImageView = findViewById<ImageView>(R.id.iv_preview)
        val previewTextView = findViewById<TextView>(R.id.tv_preview_info)
        
        if (selectedFileUri != null) {
            try {
                when (selectedFileType) {
                    "image" -> {
                        previewImageView.setImageURI(selectedFileUri)
                        previewTextView.text = "Image selected: ${selectedFileUri?.lastPathSegment}"
                    }
                    "video" -> {
                        previewTextView.text = "Video selected: ${selectedFileUri?.lastPathSegment}"
                    }
                    "document" -> {
                        previewTextView.text = "Document selected: ${selectedFileUri?.lastPathSegment}"
                    }
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Error loading preview: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun uploadFile() {
        if (selectedFileUri == null) {
            Toast.makeText(this, getString(R.string.msg_upload_error), Toast.LENGTH_SHORT).show()
            return
        }
        
        val folder = findViewById<Spinner>(R.id.spinner_folder).selectedItem.toString()
        val tags = findViewById<EditText>(R.id.et_tags).text.toString()
        
        lifecycleScope.launch {
            try {
                val fileName = selectedFileUri?.lastPathSegment ?: "file"
                val filePath = copyFileToAppStorage(selectedFileUri!!)
                
                val item = ClipboardItem(
                    content = fileName,
                    type = selectedFileType,
                    filePath = filePath,
                    fileName = fileName,
                    fileSize = File(filePath).length(),
                    mimeType = getMimeType(selectedFileType),
                    folder = folder.takeIf { it.isNotEmpty() },
                    tags = tags.takeIf { it.isNotEmpty() }
                )
                
                repository.addItem(item)
                Toast.makeText(this@UploadManagerActivity, getString(R.string.msg_upload_success), Toast.LENGTH_SHORT).show()
                
                // Clear UI
                selectedFileUri = null
                findViewById<EditText>(R.id.et_tags).text.clear()
                
            } catch (e: Exception) {
                Toast.makeText(this@UploadManagerActivity, "Error: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
    
    private fun copyFileToAppStorage(uri: Uri): String {
        val fileName = uri.lastPathSegment ?: "file_${System.currentTimeMillis()}"
        val appStorageDir = File(filesDir, "clipboard_items")
        appStorageDir.mkdirs()
        
        val outputFile = File(appStorageDir, fileName)
        val inputStream = contentResolver.openInputStream(uri)
        val outputStream = FileOutputStream(outputFile)
        
        inputStream?.copyTo(outputStream)
        inputStream?.close()
        outputStream.close()
        
        return outputFile.absolutePath
    }
    
    private fun getMimeType(type: String): String {
        return when (type) {
            "image" -> "image/*"
            "video" -> "video/*"
            "document" -> "application/*"
            else -> "text/plain"
        }
    }
}
