package com.supremehyo.justwriteapp.notification

import com.supremehyo.justwriteapp.data.message.SimpleMessage

interface BubbleNotification {
    fun showNotification(simpleMessage: SimpleMessage)
}
