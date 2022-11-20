package com.natiqhaciyef.contactappabb.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.natiqhaciyef.contactappabb.R
import com.natiqhaciyef.contactappabb.data.model.Person
import com.natiqhaciyef.contactappabb.databinding.RecyclerItemPersonBinding
import com.natiqhaciyef.contactappabb.ui.fragments.FeedFragmentDirections
import com.natiqhaciyef.contactappabb.ui.viewmodel.FeedViewModel
import com.natiqhaciyef.contactappabb.util.go


class ContactAdapter(var mContext: Context, private val list: List<Person>,private val viewModel: FeedViewModel):
    RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    inner class ContactHolder(var binding: RecyclerItemPersonBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val binding: RecyclerItemPersonBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context),
            R.layout.recycler_item_person ,parent, false)
        return ContactHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val person = list[position]
        val itemView = holder.binding

        itemView.person = person
        itemView.cardViewRecycler.setOnClickListener {
            val action = FeedFragmentDirections.toDetails(person = person)
            Navigation.go(it,action)
        }

        itemView.deleteImage.setOnClickListener {
            Snackbar.make(it,"Do you want delete ${person.name}?",Snackbar.LENGTH_LONG)
                .setAction("Yes"){
                    deleteItem(person.id)
                }.show()
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    private fun deleteItem(id: Int){
        viewModel.deleteItem(id)
    }
}