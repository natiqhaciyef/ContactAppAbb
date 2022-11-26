package com.natiqhaciyef.contactappabb.data.source

import android.util.Log
import com.natiqhaciyef.contactappabb.data.model.Person
import com.natiqhaciyef.contactappabb.room.ContactDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PersonDataSource @Inject constructor(var dao: ContactDao) {
    suspend fun save(name: String, phone: String) {
        Log.e("MyTag", "$name - $phone saved")
    }

    suspend fun update(id: Int, name: String, phone: String) {
        Log.e("MyTag", "$name $phone updated")
    }

    suspend fun deleteItem(id: Int) {
        Log.e("MyTag", "Delete $id person")
    }

    suspend fun loadPerson(): List<Person> = withContext(Dispatchers.IO){
        dao.loadPersonFromDb()
    }

    suspend fun search(text: String): List<Person> = withContext(Dispatchers.IO) {
        return@withContext arrayListOf(Person(1, "Natiq", "0553860054"))
    }
}