package com.sitadigi.coachingtop.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.sitadigi.coachingtop.models.Citation
import com.sitadigi.coachingtop.models.TaskList
import com.sitadigi.coachingtop.models.User
import com.sitadigi.coachingtop.models.Video
import java.util.concurrent.Executors
import kotlin.concurrent.Volatile

//@Database(entities = [User::class, Video::class,TaskList::class,Result::class, Citation::class],
  //  version = 1,
  //  exportSchema = false)
abstract class CoachingTopDatabase : RoomDatabase(){

        // --- DAO ---
       /* abstract fun userDao(): UserDao
        abstract fun videoDao(): VideoDao?
        abstract fun taskListDao(): TaskListDao?
        abstract fun resultDao(): ResultDao?
        abstract fun citationDao(): CitationDao?

        companion object {
            // --- SINGLETON ---
            @Volatile
            private var INSTANCE: CoachingTopDatabase? = null

            // --- INSTANCE ---
            fun getInstance(context: Context): CoachingTopDatabase? {
                if (INSTANCE == null) {
                    synchronized(CoachingTopDatabase::class.java) {
                        if (INSTANCE == null) {
                            INSTANCE = databaseBuilder(
                                context.applicationContext,

                                CoachingTopDatabase::class.java, "MyCoachingTopDatabase.db"
                            )

                                .addCallback(prepopulateDatabase())

                                .build()
                        }
                    }
                }

                return INSTANCE
            }

            private fun prepopulateDatabase(): Callback {
                return object : Callback() {
                    override fun onCreate(db: SupportSQLiteDatabase) {
                        super.onCreate(db)

                        Executors.newSingleThreadExecutor().execute {
                            INSTANCE!!.userDao().createUser(
                                User(
                                    1,
                                    "Philippe",
                                    "I'am a strong woman",
                                    "path 1",1,1,1,
                                )
                            )
                        }
                    }
                }
            }
        }
*/

}