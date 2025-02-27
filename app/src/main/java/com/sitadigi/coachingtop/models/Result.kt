package com.sitadigi.coachingtop.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "result_table", foreignKeys = [
    androidx.room.ForeignKey(
    entity = User::class,
    parentColumns = arrayOf("user_id"),
    childColumns = arrayOf("fk_user_id"))])
    data class Result(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "result_id")
    val id: Int,
    @ColumnInfo(name= "fk_user_id")
    val user_id: Int
)
