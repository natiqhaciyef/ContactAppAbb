package com.natiqhaciyef.contactappabb.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.natiqhaciyef.contactappabb.data.repository.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SaveViewModel: ViewModel() {
    private val p = PersonRepository()

    fun save(name: String, phone: String){
        CoroutineScope(Dispatchers.Main).launch {
            p.save(name, phone)
        }
    }
}