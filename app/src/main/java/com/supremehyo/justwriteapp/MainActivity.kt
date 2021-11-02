package com.supremehyo.justwriteapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import com.supremehyo.justwriteapp.database.MemoDatabase
import kotlinx.android.synthetic.main.activity_main.*
import android.animation.Animator

import android.animation.AnimatorListenerAdapter
import android.content.Intent
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import androidx.fragment.app.viewModels
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.supremehyo.justwriteapp.ui.bubble.DetailFragment
import com.supremehyo.justwriteapp.ui.main.MainFragment
import com.supremehyo.justwriteapp.ui.main.MainViewModel
import com.supremehyo.justwriteapp.ui.main.MemoListFragment
import com.supremehyo.justwriteapp.ui.main.WriteFragment


class MainActivity : AppCompatActivity() {


    val memoListFragment = MemoListFragment()
    val writeFragment = WriteFragment()
    private val fragmentManager = supportFragmentManager

    private var activeFragment: Fragment = memoListFragment
    private lateinit var db: MemoDatabase
    private val viewModel: MainViewModel by viewModels {
        (applicationContext as BubbleApplication).bubbleViewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        fragmentManager.beginTransaction().apply {
            add(R.id.container, writeFragment, "").hide(writeFragment)
            add(R.id.container, memoListFragment, "")
        }.commit()


        //바텀시트
        val bottomSheetView = layoutInflater.inflate(R.layout.bottom_sheet_layout, null)
        val bottomSheetDialog = BottomSheetDialog(this)
        bottomSheetDialog.setContentView(bottomSheetView)
        bottomSheetDialog.behavior.state = BottomSheetBehavior.STATE_EXPANDED

        setSupportActionBar(bottomAppBar)//이거 안해서 계속 메뉴 선택이 안됐음
        //메뉴 생성
        fab_bt.setOnClickListener {
            viewModel.showBubbleNotification()
        }
        //db 선언
        db = MemoDatabase.getInstance(applicationContext)!!

        bottomAppBar.setNavigationOnClickListener(object  : View.OnClickListener{
            override fun onClick(p0: View?) {
                bottomSheetDialog.show()
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navigation_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
           when(item.itemId){
               R.id.email -> {
                   fragmentManager.beginTransaction().hide(activeFragment).show(memoListFragment).commit()
                   activeFragment = memoListFragment
                   true
               }

               R.id.trash -> {
                   fragmentManager.beginTransaction().hide(activeFragment).show(writeFragment).commit()
                   activeFragment = writeFragment
                   true
               }
               /*
               R.id.profileFragment -> {
                   fragmentManager.beginTransaction().hide(activeFragment).show(profileFragment).commit()
                   activeFragment = profileFragment
                   true
               }*/
           }
        return super.onOptionsItemSelected(item)
    }

    //  app_bar.fabAlignmentMode = BottomAppBar.FAB_ALIGNMENT_MODE_END


    fun rotateFab(v: View, rotate: Boolean): Boolean {
        v.animate().setDuration(200)
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                }
            })
            .rotation(if (rotate) 135f else 0f)
        return rotate
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        if (intent != null) {
            handleIntent(intent)
        }
    }

    private fun handleIntent(intent: Intent) {
        if (Intent.ACTION_VIEW == intent.action) {
            val message = intent.data?.lastPathSegment
            if (message != null) {
                openDetail(message)
            }
        }
    }

    private fun openDetail(message: String) {
        supportFragmentManager.commit {
            replace(R.id.container, DetailFragment.newInstance(message))
        }
    }
}