package com.natiqhaciyef.contactappabb.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.natiqhaciyef.contactappabb.R
import com.natiqhaciyef.contactappabb.databinding.FragmentDetailsBinding
import com.natiqhaciyef.contactappabb.databinding.FragmentSaveBinding

class SaveFragment : Fragment() {
    private lateinit var binding: FragmentSaveBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentSaveBinding.inflate(inflater, container, false)

        binding.toolbar2.title = "Add person"

        binding.saveButton.setOnClickListener {
            val name = binding.nameText.text
            val phone = binding.phoneText.text

            saveData(name.toString(), phone.toString())
        }

        return binding.root
    }

    private fun saveData(name: String, phone: String){
        Log.e("Save Tag","$name $phone")
    }
}