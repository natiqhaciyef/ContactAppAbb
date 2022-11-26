package com.natiqhaciyef.contactappabb.di

import android.content.Context
import androidx.room.Room
import com.natiqhaciyef.contactappabb.data.repository.PersonRepository
import com.natiqhaciyef.contactappabb.data.source.PersonDataSource
import com.natiqhaciyef.contactappabb.room.ContactDao
import com.natiqhaciyef.contactappabb.room.ContactDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule  {

    @Provides
    @Singleton
    fun createPersonRepository(pds: PersonDataSource) = PersonRepository(pds)

    @Provides
    @Singleton
    fun createPersonDataSource(dao: ContactDao) = PersonDataSource(dao)

    @Provides
    @Singleton
    fun createContactDao(@ApplicationContext context: Context) : ContactDao {
        val db = Room.databaseBuilder(context, ContactDatabase::class.java,"database_contact_app.db")
            .createFromAsset("database_contact_app.db").build()
        return db.getContactDao()
    }
}