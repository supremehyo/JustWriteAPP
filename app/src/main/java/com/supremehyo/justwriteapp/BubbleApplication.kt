package com.supremehyo.justwriteapp

import android.app.Application
import android.app.NotificationManager
import android.content.pm.ShortcutManager
import com.supremehyo.justwriteapp.notification.AndroidBubbleNotificationView
import com.supremehyo.justwriteapp.notification.BubbleNotification

class BubbleApplication : Application() {
    private val bubbleNotification: BubbleNotification by lazy {
        AndroidBubbleNotificationView(
            this,
            getSystemService(NOTIFICATION_SERVICE) as NotificationManager,
            getSystemService(SHORTCUT_SERVICE) as ShortcutManager
        )
    }

    val bubbleViewModelFactory: BubbleViewModelFactory by lazy {
        BubbleViewModelFactory(this, bubbleNotification)
    }
}
