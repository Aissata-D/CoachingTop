package com.sitadigi.coachingtop.data.dao

import android.database.Cursor
import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import androidx.room.Upsert
import com.sitadigi.coachingtop.models.User
import kotlinx.coroutines.flow.Flow


@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createUser(user: User)

    @Upsert
    suspend fun insertOrUpdateUser(user:User)  //evite les effet de bord

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateUser(user: User)

    @Query("SELECT * FROM users_table WHERE user_id = :userId")
    suspend fun getUserById(userId: Int): User

    @Query("SELECT * FROM users_table")
    fun getAllUsers(): Flow<List<User>>

   // @Query("SELECT * FROM users_table WHERE user_id = :userId")
    //suspend fun getUserWithCursor(userId: Long): Cursor?

    @Delete
    suspend fun deleteUser(user:User)

    @Query("DELETE FROM users_table WHERE user_id = :userId")
    suspend fun deleteUserById(userId: Int)

}






