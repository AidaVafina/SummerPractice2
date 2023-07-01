package com.example.myapplication3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.example.myapplication3.databinding.FragmentFirstBinding
import com.example.myapplication3.databinding.FragmentSecondBinding
import com.google.android.material.snackbar.BaseTransientBottomBar
import com.google.android.material.snackbar.Snackbar

class SecondFragment : Fragment(R.layout.fragment_second) {

    private var binding: FragmentSecondBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentSecondBinding.bind(view)

        binding?.binToSettings?.setOnClickListener {
            Snackbar.make(view, "вы нажали на кнопку", Snackbar.LENGTH_SHORT).show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
