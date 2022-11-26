package com.natiqhaciyef.contactappabb.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.natiqhaciyef.contactappabb.data.model.Person

@Database(entities = [Person::class], version = 1)
abstract class ContactDatabase : RoomDatabase(){
    abstract fun getContactDao(): ContactDao
}