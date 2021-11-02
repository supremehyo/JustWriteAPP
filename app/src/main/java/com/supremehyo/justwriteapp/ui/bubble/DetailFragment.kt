package com.supremehyo.justwriteapp.ui.bubble

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.supremehyo.justwriteapp.R
import com.supremehyo.justwriteapp.databinding.DetailFragmentBinding
import com.supremehyo.justwriteapp.extension.viewBindings

class DetailFragment : Fragment(R.layout.detail_fragment) {
    companion object {
        private const val ARG_MESSAGE = "message"

        fun newInstance(message: String) =
            DetailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_MESSAGE, message)
                }
            }
    }

    private val binding by viewBindings(DetailFragmentBinding::bind)


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val message = arguments?.getString(ARG_MESSAGE)

        binding.detailText.text = getString(R.string.hello_from, message)
    }
}
