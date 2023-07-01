package com.example.myapplication3

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication3.databinding.FragmentFirstBinding
import com.example.myapplication3.databinding.FragmentMusicBinding
import com.example.myapplication3.databinding.FragmentSecondBinding

class MusicFragment : Fragment(R.layout.fragment_music) {

    private var binding: FragmentMusicBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMusicBinding.bind(view)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}