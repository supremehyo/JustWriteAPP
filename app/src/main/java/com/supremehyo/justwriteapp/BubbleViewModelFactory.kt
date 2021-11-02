package com.supremehyo.justwriteapp

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.supremehyo.justwriteapp.notification.BubbleNotification
import com.supremehyo.justwriteapp.ui.main.MainViewModel

class BubbleViewModelFactory(
    private val application: Application,
    private val bubbleNotification: BubbleNotification
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application, bubbleNotification) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}
