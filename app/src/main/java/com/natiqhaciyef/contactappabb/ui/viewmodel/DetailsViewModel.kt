package com.natiqhaciyef.contactappabb.ui.viewmodel

import androidx.lifecycle.ViewModel
import com.natiqhaciyef.contactappabb.data.repository.PersonRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    val p: PersonRepository
) : ViewModel(){

    fun update(id: Int, name: String, phone: String){
        CoroutineScope(Dispatchers.Main).launch{
            p.update(id,name,phone)
        }
    }
}