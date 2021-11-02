package com.supremehyo.justwriteapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.supremehyo.justwriteapp.R

//https://answer-id.com/ko/54429785
//쓰고 3초안에 새로운 글이 없다면 자동저장
//onTaskRemoved 강제종료 참고
class WriteFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var view = inflater.inflate(R.layout.fragment_write, container, false)
        return view
    }


}