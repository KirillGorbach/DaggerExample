package com.hogriders.daggerexample.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.hogriders.daggerexample.db.model.UserDB

@Dao
interface UsersDao {

    @Query("SELECT * FROM User")
    fun getAllUsers(): List<UserDB>

    @Query("SELECT * FROM User WHERE age >= :age ORDER BY age")
    fun getOldPeopleBeers(age: Int): List<UserDB>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: UserDB)

    @Query("DELETE FROM User")
    fun deleteAllUsers()
}