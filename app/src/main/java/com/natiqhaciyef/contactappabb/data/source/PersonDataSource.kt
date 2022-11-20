package com.natiqhaciyef.contactappabb.data.source

import android.util.Log

class PersonDataSource {
    suspend fun save(name: String, phone: String){
        Log.e("MyTag","$name - $phone saved")
    }

    suspend fun update(id: Int, name: String, phone: String){
        Log.e("MyTag","$name $phone updated")
    }

    suspend fun deleteItem(id: Int){
        Log.e("MyTag","Delete $id person")
    }

}