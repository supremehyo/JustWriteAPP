package com.supremehyo.justwriteapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commitNow
import com.supremehyo.justwriteapp.ui.bubble.DetailFragment

class BubbleActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.bubble_activity)

        val message = intent.data?.lastPathSegment ?: return

        if (savedInstanceState == null) {
            supportFragmentManager.commitNow {
                replace(R.id.container, DetailFragment.newInstance(message))
            }
        }
    }
}
