package com.supremehyo.justwriteapp.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date
import java.util.*

@Entity
data class Memo(
    var title : String,
    var content : String,
    var create_time : String,
    var alarm_flag : Boolean
){
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}