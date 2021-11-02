package com.supremehyo.justwriteapp.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface MemoDAO {

    @Query("SELECT * FROM Memo")
    fun getAll(): List<Memo>

    @Insert
    fun insert(memo: Memo)

    @Query("DELETE FROM Memo WHERE title = :title")
    fun deleteMemoByTitle(title: String)
}