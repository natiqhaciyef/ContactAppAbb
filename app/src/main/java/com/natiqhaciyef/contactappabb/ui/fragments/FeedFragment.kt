package com.natiqhaciyef.contactappabb.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import com.natiqhaciyef.contactappabb.R
import com.natiqhaciyef.contactappabb.data.model.Person
import com.natiqhaciyef.contactappabb.databinding.FragmentFeedBinding
import com.natiqhaciyef.contactappabb.ui.MainActivity
import com.natiqhaciyef.contactappabb.ui.adapter.ContactAdapter
import com.natiqhaciyef.contactappabb.ui.viewmodel.FeedViewModel
import com.natiqhaciyef.contactappabb.util.go

class FeedFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentFeedBinding
    private lateinit var viewModel: FeedViewModel
    private var contactList = listOf<Person>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_feed ,container, false)
        binding.feedFragment = this
        binding.toolbarTitle = "Contacts"

        viewModel.personList.observe(viewLifecycleOwner, Observer {
            contactList = it
            val adapter = ContactAdapter(requireContext(), contactList, viewModel)
            binding.adapter = adapter
        })


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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val temp: FeedViewModel by viewModels()
        viewModel = temp
    }

    fun fabClick(view: View){
        Navigation.go(view,R.id.saveFragment)
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        viewModel.search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        viewModel.search(newText)
        return true
    }

    override fun onResume() {
        super.onResume()
        // Return to HomeFragment
    }
}