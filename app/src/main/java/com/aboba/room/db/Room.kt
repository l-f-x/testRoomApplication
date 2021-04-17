package com.aboba.room.db

import androidx.room.*
import com.aboba.room.controllers.DataDao

const val db_name="name"
const val db_description="description"
const val db_image_url="image_url"
@Entity
data class Data(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = db_name) val name: String,
    @ColumnInfo(name = db_description) val desc: String,
    @ColumnInfo(name = db_image_url) val url:String
)

@Database(entities = arrayOf(Data::class), version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataDao(): DataDao
}