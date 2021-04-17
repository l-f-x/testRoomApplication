package com.aboba.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.room.Room
import androidx.room.RoomDatabase
import coil.load
import com.aboba.room.controllers.DataDao
import com.aboba.room.databinding.ActivityInsertDataBinding
import com.aboba.room.db.AppDatabase
import com.aboba.room.db.Data
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class InsertDataActivity : AppCompatActivity() {
    lateinit var binding: ActivityInsertDataBinding
    lateinit var dataDao: DataDao
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInsertDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "db"
        ).build()
        dataDao = db.dataDao()
    }

    fun push(view: View) {
        GlobalScope.launch {
                insertData(Data(
                        0,
                        binding.etName.text.toString(),
                        binding.etDesc.text.toString(),
                        binding.etImageUrl.text.toString()
                ), view)
        }
    }



    private fun insertData(data: Data, view: View){
        dataDao.insertAll(data)
        Snackbar.make(view,
                "Элемент успешно добавлен!",
                Snackbar.LENGTH_SHORT).show()
    }

    fun preload(view: View) {
        binding.preloadContainer.load(binding.etImageUrl.text.toString()){
            placeholder(R.drawable.ic_baseline_timer_128)
            error(R.drawable.ic_baseline_error_outline_24)
        }
    }
}