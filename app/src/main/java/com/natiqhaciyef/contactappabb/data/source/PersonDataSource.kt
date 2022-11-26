package com.natiqhaciyef.contactappabb.data.source

import android.util.Log
import com.natiqhaciyef.contactappabb.data.model.Person
import com.natiqhaciyef.contactappabb.room.ContactDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class PersonDataSource @Inject constructor(var dao: ContactDao) {
    suspend fun save(name: String, phone: String) {
        val person = Person(0,name,phone)
        dao.saveData(person)
    }

    suspend fun update(id: Int, name: String, phone: String) {
        val person = Person(id, name, phone)
        dao.updateData(person)
    }

    suspend fun deleteItem(id: Int) {
        val person = Person(id,"","")
        dao.deleteData(person)
    }

    suspend fun loadPerson(): List<Person> = withContext(Dispatchers.IO){
        dao.loadPersonFromDb()
    }

    suspend fun search(text: String): List<Person> = withContext(Dispatchers.IO){
        dao.search(text)
    }
}