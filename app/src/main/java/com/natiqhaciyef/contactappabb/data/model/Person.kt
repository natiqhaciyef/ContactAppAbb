package com.natiqhaciyef.contactappabb.data.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity("contact")
data class Person(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo("id") @NotNull  var id: Int,
    @ColumnInfo("name") @NotNull var name: String,
    @ColumnInfo("phone") @NotNull var phone: String
): Serializable
