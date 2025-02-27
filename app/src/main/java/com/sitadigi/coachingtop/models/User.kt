package com.sitadigi.coachingtop.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Data class that captures user information
 */
@Entity(tableName = "users_table",
    foreignKeys = [
        androidx.room.ForeignKey(
        entity = Video::class,
        parentColumns = arrayOf("video_id"),
        childColumns = arrayOf("fk_video_id"))
])
data class User(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "user_id")
    val id: Int,
    @ColumnInfo(name = "user_name")
    var name: String,
    @ColumnInfo(name = "user_description")
    var description: String,
    @ColumnInfo(name = "image_path_id")
    var imagePath: String,
    @ColumnInfo(name = "fk_video_id")
    var idVideo: Int )
