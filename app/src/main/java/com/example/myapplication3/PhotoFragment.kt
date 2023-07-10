package com.example.myapplication3

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.bumptech.glide.Glide
import com.example.myapplication3.DogRepository.list
import com.example.myapplication3.databinding.FragmentFirstBinding
import com.example.myapplication3.databinding.FragmentPhotoBinding
import com.example.myapplication3.databinding.FragmentSecondBinding
import com.example.myapplication3.utils.showSnackbar
import com.google.android.material.snackbar.Snackbar

class PhotoFragment : Fragment(R.layout.fragment_photo) {

    private var binding: FragmentPhotoBinding? = null
    private var adapter: DogAdapter ?= null
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentPhotoBinding.bind(view)

        val name = arguments?.getString(ARG_NAME)
        Log.e("ProfileFragment", name.orEmpty())

        initAdapter()
    }

    private fun initAdapter() {
        adapter = DogAdapter(
            list = DogRepository.list,
            glide = Glide.with(this),
            onItemClick = {
                id -> findNavController().navigate(
                R.id.action_photoFragment_to_descriptionFragment,
                PhotoFragment.createBundleWithCountryId(id)
                )
            }
        )
        binding?.dogs?.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

    companion object{

        fun createBundleWithCountryId(id: Int): Bundle {
            val bundle = Bundle()
            bundle.putInt("KEY", id)
            return bundle
        }

        private const val ARG_NAME = "ARG_NAME"
        private const val ARG_AGE = "ARG_AGE"
        fun createBundle(name: String, age: Int): Bundle {
            val bundle = Bundle()
            bundle.putString(ARG_NAME, name)
            bundle.putInt(ARG_AGE, age)
            return bundle
        }
    }
}