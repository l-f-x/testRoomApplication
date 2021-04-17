package com.aboba.room.controllers

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.aboba.room.db.Data
import kotlinx.coroutines.flow.Flow

@Dao
interface DataDao {
    @Query("SELECT * FROM data")
    fun getAll(): List<Data>

    @Insert
    fun insertAll(vararg data: Data)
}
