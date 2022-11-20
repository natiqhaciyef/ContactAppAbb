package com.natiqhaciyef.contactappabb.di

import com.natiqhaciyef.contactappabb.data.repository.PersonRepository
import com.natiqhaciyef.contactappabb.data.source.PersonDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
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
    fun createPersonDataSource() = PersonDataSource()
}