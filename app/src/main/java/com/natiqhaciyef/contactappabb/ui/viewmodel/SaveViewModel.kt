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
class SaveViewModel @Inject constructor(
    val p: PersonRepository
): ViewModel() {

    fun save(name: String, phone: String){
        CoroutineScope(Dispatchers.Main).launch {
            p.save(name, phone)
        }
    }
}