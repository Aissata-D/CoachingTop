package com.sitadigi.coachingtop.DI

import android.content.Context
import androidx.room.Room
import com.sitadigi.coachingtop.data.dao.UserDao
import com.sitadigi.coachingtop.database.CoachingTopDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)

class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CoachingTopDatabase{

        return

        Room.databaseBuilder(context, CoachingTopDatabase::class.java,
            "CoachingTopDatabase").build()

    }

    @Provides
    fun provideUserDao(database: CoachingTopDatabase): UserDao = database.userDao()
}