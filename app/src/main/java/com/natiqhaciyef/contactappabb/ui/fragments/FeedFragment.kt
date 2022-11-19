package com.natiqhaciyef.contactappabb.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.natiqhaciyef.contactappabb.R
import com.natiqhaciyef.contactappabb.data.model.Person
import com.natiqhaciyef.contactappabb.databinding.FragmentFeedBinding
import com.natiqhaciyef.contactappabb.ui.MainActivity
import com.natiqhaciyef.contactappabb.ui.adapter.ContactAdapter

class FeedFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentFeedBinding
    private var contactList = arrayListOf(
        Person(1, "Natiq", "0553860054"),
        Person(2, "Sadiq", "0553820054"),
        Person(3, "Raul", "05594305452"),
        Person(4, "Ramal", "0559969502")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_feed ,container, false)
        binding.feedFragment = this
        binding.toolbarTitle = "Contacts"

        val adapter = ContactAdapter(requireContext(), contactList)
        binding.adapter = adapter

        (activity as MainActivity).setSupportActionBar(binding.toolbar)     // setting toolbar as main action bar
        requireActivity().addMenuProvider(object: MenuProvider{
            override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
                menuInflater.inflate(R.menu.options_menu, menu)
                val item = menu.findItem(R.id.actionToolbarSearch)
                val searcView = item.actionView as SearchView
                searcView.setOnQueryTextListener(this@FeedFragment)
            }

            override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
                return false
            }

        }, viewLifecycleOwner, Lifecycle.State.RESUMED)     // menu adding toolbar


        return binding.root
    }

    fun fabClick(view: View){
        Navigation.findNavController(view).navigate(R.id.to_Save)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    fun search(keyword: String){
        Log.e("MyTag","- $keyword")
    }
}