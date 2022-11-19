package com.natiqhaciyef.contactappabb.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.natiqhaciyef.contactappabb.R
import com.natiqhaciyef.contactappabb.databinding.FragmentDetailsBinding
import com.natiqhaciyef.contactappabb.ui.viewmodel.DetailsViewModel

class DetailsFragment : Fragment() {
    private lateinit var binding: FragmentDetailsBinding
    private lateinit var viewModel: DetailsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_details ,container, false)

        binding.toolbarTitle = "Person details"

        val data : DetailsFragmentArgs by navArgs()
        binding.person = data.person
        binding.fragmentDetails = this

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp : DetailsViewModel by viewModels()
        viewModel = temp
    }

    fun updateData(id: Int, name: String, phone: String){
        viewModel.update(id, name, phone)
    }
}