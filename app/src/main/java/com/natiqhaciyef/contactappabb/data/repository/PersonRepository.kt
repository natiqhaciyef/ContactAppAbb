package com.natiqhaciyef.contactappabb.data.repository

import com.natiqhaciyef.contactappabb.data.source.PersonDataSource
import javax.inject.Inject

class PersonRepository @Inject constructor(
    var pds: PersonDataSource
){

    suspend fun save(name: String, phone: String) = pds.save(name, phone)

    suspend fun update(id: Int, name: String, phone: String) = pds.update(id, name, phone)

    suspend fun deleteItem(id: Int) = pds.deleteItem(id)

    suspend fun loadPerson() = pds.loadPerson()

    suspend fun search(text: String) = pds.search(text)
}