package com.hogriders.daggerexample

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.hogriders.daggerexample.db.model.UserDB
import com.hogriders.daggerexample.di.component.DaggerRoomDatabaseComponent
import com.hogriders.daggerexample.di.module.ContextModule
import com.hogriders.daggerexample.di.module.RoomDatabaseModule
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.schedulers.Schedulers

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val roomDB = DaggerRoomDatabaseComponent.builder()
            .roomDatabaseModule(RoomDatabaseModule())
            .contextModule(ContextModule(this))
            .build()

        Observable.fromCallable { roomDB.getRoomDatabase().getUsersDao().insertUser(UserDB()) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe()
        roomDB.getRoomDatabase().getUsersDao().getAllUsers()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe { users ->
                val sb = StringBuilder()
                users.forEach { sb.append(it.toString()); sb.append("\n") }
                findViewById<TextView>(R.id.text_view)?.text = sb.toString()
            }
    }
}















