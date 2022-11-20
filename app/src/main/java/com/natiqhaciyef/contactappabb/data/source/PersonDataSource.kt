package com.natiqhaciyef.contactappabb.data.source

import android.util.Log
import com.natiqhaciyef.contactappabb.data.model.Person
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class PersonDataSource {
    suspend fun save(name: String, phone: String) {
        Log.e("MyTag", "$name - $phone saved")
    }

    suspend fun update(id: Int, name: String, phone: String) {
        Log.e("MyTag", "$name $phone updated")
    }

    suspend fun deleteItem(id: Int) {
        Log.e("MyTag", "Delete $id person")
    }

    suspend fun loadPerson(): List<Person> = withContext(Dispatchers.IO) {
        return@withContext arrayListOf(
            Person(1, "Natiq", "0553860054"),
            Person(2, "Sadiq", "0553820054"),
            Person(3, "Raul", "05594305452"),
            Person(4, "Ramal", "0559969502")
        )
    }

    suspend fun search(text: String): List<Person> = withContext(Dispatchers.IO) {
        return@withContext arrayListOf(Person(1, "Natiq", "0553860054"))
    }
}