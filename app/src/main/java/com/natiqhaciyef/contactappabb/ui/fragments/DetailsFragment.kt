package com.natiqhaciyef.contactappabb.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.natiqhaciyef.contactappabb.R
import com.natiqhaciyef.contactappabb.databinding.FragmentDetailsBinding

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentDetailsBinding.inflate(inflater, container, false)

        binding.toolbar3.title = "Person details"

        val data : DetailsFragmentArgs by navArgs()
        val person = data.person

        binding.nameTextDetails.setText(person.name)
        binding.phoneTextDetails.setText(person.phone)

        binding.updateButton.setOnClickListener {
            val name = binding.nameTextDetails.text
            val phone = binding.phoneTextDetails.text
            updateData(person.id, name.toString(), phone.toString())
        }

        return binding.root
    }

    private fun updateData(id: Int, name: String, phone: String){
        Log.e("Save Tag","$name $phone")
    }
}