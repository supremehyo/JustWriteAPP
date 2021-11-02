package com.supremehyo.justwriteapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.supremehyo.justwriteapp.BubbleApplication
import com.supremehyo.justwriteapp.R
import com.supremehyo.justwriteapp.databinding.MainFragmentBinding
import com.supremehyo.justwriteapp.extension.viewBindings

class MainFragment : Fragment() {
    companion object {
        fun newInstance() = MainFragment()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }
}
