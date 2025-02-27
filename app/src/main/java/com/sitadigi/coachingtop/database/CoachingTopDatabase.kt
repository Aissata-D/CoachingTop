package com.sitadigi.coachingtop.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.sitadigi.coachingtop.dao.CitationDao
import com.sitadigi.coachingtop.dao.ResultDao
import com.sitadigi.coachingtop.dao.TaskListDao
import com.sitadigi.coachingtop.dao.UserDao
import com.sitadigi.coachingtop.dao.VideoDao
import com.sitadigi.coachingtop.models.Citation
import com.sitadigi.coachingtop.models.Result
import com.sitadigi.coachingtop.models.TaskList
import com.sitadigi.coachingtop.models.User
import com.sitadigi.coachingtop.models.Video
import kotlin.concurrent.Volatile
import kotlin.coroutines.coroutineContext


@Database( entities = [User::class, Citation::class,Result::class,TaskList::class, Video::class],
    version = 1,
    exportSchema = true)
//@TypeConverters(Converters::class)  Converters à definir
abstract class CoachingTopDatabase: RoomDatabase() {

    companion object {
        @Volatile
        private var Instance: CoachingTopDatabase? = null

        fun getDatabase(context: Context): CoachingTopDatabase{
        // if the Instance is not null, return it, otherwise create a new database instance.

            return Instance?: synchronized(this){
                Room.databaseBuilder(context,CoachingTopDatabase::class.java, "CoachingTopDatabase")
                    .build()
                    .also { Instance= it }
            }
        }
    }
    abstract fun userDao(): UserDao
    abstract fun citationDao(): CitationDao
    abstract fun resultDao(): ResultDao
    abstract fun taskListDan(): TaskListDao
    abstract fun videoDao(): VideoDao
    
}