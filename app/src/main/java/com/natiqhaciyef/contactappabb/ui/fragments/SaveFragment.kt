package com.natiqhaciyef.contactappabb.ui.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.natiqhaciyef.contactappabb.R
import com.natiqhaciyef.contactappabb.databinding.FragmentSaveBinding
import com.natiqhaciyef.contactappabb.ui.viewmodel.SaveViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SaveFragment : Fragment() {
    private lateinit var binding: FragmentSaveBinding
    private lateinit var viewModel: SaveViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_save ,container, false)

        binding.toolbarTitle = "Add person"
        binding.fragmentSaved = this

        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: SaveViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun saveData(name: String, phone: String){
        viewModel.save(name, phone)
    }
}