package com.natiqhaciyef.contactappabb.room

import androidx.room.Dao
import androidx.room.Query
import com.natiqhaciyef.contactappabb.data.model.Person

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    suspend fun loadPersonFromDb():List<Person>
}