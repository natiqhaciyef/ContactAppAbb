package com.natiqhaciyef.contactappabb.room

import androidx.room.*
import com.natiqhaciyef.contactappabb.data.model.Person

@Dao
interface ContactDao {
    @Query("SELECT * FROM contact")
    suspend fun loadPersonFromDb():List<Person>

    @Query("SELECT * FROM contact WHERE name like '%'|| :searchText ||'%'")
    suspend fun search(searchText: String):List<Person>

    @Insert
    suspend fun saveData(person: Person)

    @Update
    suspend fun updateData(person: Person)

    @Delete
    suspend fun deleteData(person: Person)

}