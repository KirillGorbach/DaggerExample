package com.hogriders.daggerexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.hogriders.daggerexample.db.model.UserDB
import com.hogriders.daggerexample.di.component.DaggerRoomDatabaseComponent
import com.hogriders.daggerexample.di.module.ContextModule
import com.hogriders.daggerexample.di.module.RoomDatabaseModule

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roomDB = DaggerRoomDatabaseComponent.builder()
            .roomDatabaseModule(RoomDatabaseModule())
            .contextModule(ContextModule(this))
            .build()

        roomDB.getRoomDatabase().getUsersDao().insertUser(UserDB())
        val user = roomDB.getRoomDatabase().getUsersDao().getAllUsers()[0]

        println(user.toString())
    }
}















