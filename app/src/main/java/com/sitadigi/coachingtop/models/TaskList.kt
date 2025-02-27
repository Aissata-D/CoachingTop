package com.sitadigi.coachingtop.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "task_list_table", foreignKeys = [
    androidx.room.ForeignKey(
    entity = User::class,
    parentColumns = arrayOf("user_id"),
    childColumns = arrayOf("fk_user_id"))
        ])
data class TaskList (
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "task_list_id")
    val id: Int,
    @ColumnInfo(name = "fk_user_id")
    var user_id: String
)
