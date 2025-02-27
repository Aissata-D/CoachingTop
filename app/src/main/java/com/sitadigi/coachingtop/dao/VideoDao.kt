package com.sitadigi.coachingtop.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.sitadigi.coachingtop.models.User
import com.sitadigi.coachingtop.models.Video

@Dao

interface VideoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun createVideo(video: Video)
}