package com.example.myapplication3

import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.myapplication3.databinding.FragmentDescriptionBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL


class DescriptionFragment : Fragment(R.layout.fragment_description) {

    private var binding: FragmentDescriptionBinding? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentDescriptionBinding.bind(view)
        val id = arguments?.getInt("KEY")
        println(id)

        val dog = DogRepository.list.find{ it.id == id}
        dog?.let{
            binding?.let { binding ->
                binding.tvName.text = it.name
                binding.tvBreed.text = it.breed

                loadImageFromUrl(it.url)
            }
        }

        binding?.run {
            binToBack.setOnClickListener {
                findNavController().navigate(
                    R.id.action_descriptionFragment_to_photoFragment
                )
            }
        }
    }
    private fun loadImageFromUrl(url: String) {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val inputStream = URL(url).openStream()
                val bitmap = BitmapFactory.decodeStream(inputStream)

                CoroutineScope(Dispatchers.Main).launch {
                    binding?.image2?.setImageBitmap(bitmap)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}