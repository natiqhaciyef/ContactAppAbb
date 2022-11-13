package com.natiqhaciyef.contactappabb.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.natiqhaciyef.contactappabb.R
import com.natiqhaciyef.contactappabb.data.model.Person
import com.natiqhaciyef.contactappabb.databinding.FragmentFeedBinding
import com.natiqhaciyef.contactappabb.databinding.FragmentSaveBinding
import com.natiqhaciyef.contactappabb.ui.MainActivity
import com.natiqhaciyef.contactappabb.ui.adapter.ContactAdapter

class FeedFragment : Fragment(), SearchView.OnQueryTextListener {
    private lateinit var binding: FragmentFeedBinding
    private var contactList = ArrayList<Person>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentFeedBinding.inflate(inflater, container, false)

        binding.recyclerContactView.layoutManager = LinearLayoutManager(requireContext())
        contactList.add(Person(1,"Natiq","21231213"))
        contactList.add(Person(2,"Sadiq","6590695"))
        contactList.add(Person(3,"Raul","109845902938"))
        val adapter = ContactAdapter(requireContext(), contactList)
        binding.recyclerContactView.adapter = adapter

        binding.toolbar.title = "Contacts"
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

        binding.fab.setOnClickListener {
//            Navigation.findNavController(it).navigate(R.id.to_Save)
            val action = FeedFragmentDirections.toDetails(Person(1,"Sadiq","0553820054"))
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }

    override fun onQueryTextSubmit(query: String): Boolean {
        search(query)
        return true
    }

    override fun onQueryTextChange(newText: String): Boolean {
        search(newText)
        return true
    }

    private fun search(keyword: String){
        Log.e("MyTag","- $keyword")
    }
}