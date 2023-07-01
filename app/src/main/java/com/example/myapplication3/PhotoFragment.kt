package com.example.myapplication3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication3.databinding.FragmentFirstBinding
import com.example.myapplication3.databinding.FragmentPhotoBinding
import com.example.myapplication3.databinding.FragmentSecondBinding

class PhotoFragment : Fragment(R.layout.fragment_photo) {

    private var binding: FragmentPhotoBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhotoBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}