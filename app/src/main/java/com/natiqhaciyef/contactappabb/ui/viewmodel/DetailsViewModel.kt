package com.natiqhaciyef.contactappabb.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.natiqhaciyef.contactappabb.data.repository.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DetailsViewModel : ViewModel(){
    private val p = PersonRepository()

    fun update(id: Int, name: String, phone: String){
        CoroutineScope(Dispatchers.Main).launch{
            p.update(id,name,phone)
        }
    }
}