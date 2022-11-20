package com.natiqhaciyef.contactappabb.data.repository

import com.natiqhaciyef.contactappabb.data.source.PersonDataSource

class PersonRepository {
    private val pds = PersonDataSource()

    suspend fun save(name: String, phone: String) = pds.save(name, phone)

    suspend fun update(id: Int, name: String, phone: String) = pds.update(id, name, phone)

    suspend fun deleteItem(id: Int) = pds.deleteItem(id)
}