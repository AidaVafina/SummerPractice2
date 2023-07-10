package com.example.myapplication3

import android.os.Bundle
import android.provider.ContactsContract.Profile
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication3.databinding.FragmentFirstBinding

class FirstFragment : Fragment(R.layout.fragment_first) {
    private var binding: FragmentFirstBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentFirstBinding.bind(view)

        binding?.run{
            binToSettings.setOnClickListener{
                findNavController().navigate(
                    R.id.action_firstFragment_to_secondFragment)
            }
            binToProfile.setOnClickListener{
                findNavController().navigate(
                    R.id.action_firstFragment_to_thirdFragment)
            }
            binToMusic.setOnClickListener{
                findNavController().navigate(
                    R.id.action_firstFragment_to_musicFragment)
            }
            binToPhoto.setOnClickListener{
                findNavController().navigate(
                    R.id.action_firstFragment_to_photoFragment)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
