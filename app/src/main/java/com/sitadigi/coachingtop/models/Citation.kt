package com.sitadigi.coachingtop.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "citation_table")
data class Citation(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "citation_id")
    val id: Int,
    @ColumnInfo(name = "citation_content")
    var content: String)
