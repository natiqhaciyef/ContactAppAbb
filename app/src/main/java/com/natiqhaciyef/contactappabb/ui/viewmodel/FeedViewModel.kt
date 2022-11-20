package com.natiqhaciyef.contactappabb.ui.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natiqhaciyef.contactappabb.data.model.Person
import com.natiqhaciyef.contactappabb.data.repository.PersonRepository
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    val p: PersonRepository
) : ViewModel() {
    val personList = MutableLiveData<List<Person>>()

    init {
        loadPerson()
    }

    fun deleteItem(id: Int){
        CoroutineScope(Dispatchers.Main).launch {
            p.deleteItem(id)
        }
    }

    private fun loadPerson(){
        CoroutineScope(Dispatchers.Main).launch {
            personList.value = p.loadPerson()
        }
    }

    fun search(text: String){
        CoroutineScope(Dispatchers.Main).launch {
            personList.value = p.search(text)
        }
    }
}