package com.sitadigi.coachingtop.data.repository

import com.sitadigi.coachingtop.data.dao.UserDao
import com.sitadigi.coachingtop.models.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserRepository @Inject constructor(private val userDao: UserDao) {



    suspend fun createUser(user: User) = userDao.createUser(user)
    suspend fun insertOrUpdateUser(user:User) = userDao.insertOrUpdateUser(user)
    suspend fun updateUser(user: User) = userDao.updateUser(user)
    suspend fun getUserById(userId: Int): User = userDao.getUserById(userId)
    fun getAllUsers(): Flow<List<User>> = userDao.getAllUsers()
    suspend fun deleteUser(user:User)= userDao.deleteUser(user)
    suspend fun deleteUserById(userId: Int) = userDao.deleteUserById(userId)



}