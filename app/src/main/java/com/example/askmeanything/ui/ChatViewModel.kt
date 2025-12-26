package com.example.askmeanything.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.askmeanything.Constants
import com.google.firebase.ai.GenerativeModel
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {

    private val generativeModel = GenerativeModel(
        modelName = "gemini-1.5-flash",
        apiKey = Constants.apiKey
    )

    fun sendMessage(question: String) {
        viewModelScope.launch {
            try {
                val chat = generativeModel.startChat()
                val response = chat.sendMessage(question)
                Log.d("ChatViewModel", "Response: ${response.text}")
            } catch (e: Exception) {
                Log.e("ChatViewModel", "Error sending message", e)
            }
        }
    }
}
