package com.sitadigi.coachingtop.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "video_table")
data class Video(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "video_id")
    val id: Int,
    @ColumnInfo(name = "video_path")
    var video_path: String
)
