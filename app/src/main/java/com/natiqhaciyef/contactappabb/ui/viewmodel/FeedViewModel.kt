package com.natiqhaciyef.contactappabb.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.natiqhaciyef.contactappabb.data.repository.PersonRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FeedViewModel : ViewModel() {
    private val p = PersonRepository()

    fun deleteItem(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            p.deleteItem(id)
        }
    }
}