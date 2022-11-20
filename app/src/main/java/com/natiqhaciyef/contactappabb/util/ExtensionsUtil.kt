package com.natiqhaciyef.contactappabb.util

import android.view.View
import androidx.navigation.NavDirections
import androidx.navigation.Navigation

fun Navigation.go(view: View, id: Int){
    Navigation.findNavController(view).navigate(id)
}

fun Navigation.go(view: View, id: NavDirections){
    Navigation.findNavController(view).navigate(id)
}