package com.natiqhaciyef.contactappabb.data.source

import android.util.Log

class PersonDataSource {
    suspend fun save(name: String, phone: String){
        Log.e("MyTag","$name - $phone")
    }
}