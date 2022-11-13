package com.natiqhaciyef.contactappabb.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.natiqhaciyef.contactappabb.data.model.Person
import com.natiqhaciyef.contactappabb.databinding.RecyclerItemPersonBinding


class ContactAdapter(var mContext: Context, private val list: List<Person>): RecyclerView.Adapter<ContactAdapter.ContactHolder>() {

    inner class ContactHolder(var binding: RecyclerItemPersonBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactHolder {
        val binding = RecyclerItemPersonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactHolder, position: Int) {
        val person = list[position]
        val itemView = holder.binding

        itemView.recyclerNameText.text = "${person.name} - ${person.phone}"
    }

    override fun getItemCount(): Int {
        return list.size
    }
}