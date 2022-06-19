package com.hogriders.data.storage.local.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "User")
data class UserDB(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val name: String = "asd",
    val age: Int = 0
)