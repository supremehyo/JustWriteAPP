package com.supremehyo.justwriteapp.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.supremehyo.justwriteapp.R
import com.supremehyo.justwriteapp.data.message.SimpleMessage
import com.supremehyo.justwriteapp.notification.BubbleNotification

class MainViewModel(application: Application, private val bubbleNotification: BubbleNotification) : AndroidViewModel(application) {

    fun showBubbleNotification() {
        bubbleNotification.showNotification(getRandomMessage())
    }

    private fun getRandomMessage(): SimpleMessage {
        return SimpleMessage(100, "James", "Hello", R.drawable.ic_base_person)
    }
}
