package com.aboba.room

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.aboba.room.adapters.DataAdapter
import com.aboba.room.databinding.ActivityMainBinding
import com.aboba.room.db.AppDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.dataRv.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
       loadData()
    }

    override fun onResume() {
        super.onResume()
        loadData()
        Log.d("TAG", "onResume: ")
    }
        private fun loadData(){
            GlobalScope.launch {
                val db = Room.databaseBuilder(
                        applicationContext,
                        AppDatabase::class.java, "db"
                )
                        .build()
                val dataDao = db.dataDao()
                val dataSet=dataDao.getAll()
                val adapter=DataAdapter(dataSet)
                runOnUiThread {
                    Log.d("UI", "loadData: ${dataSet.size}")
                    binding.dataRv.adapter=adapter
                }
                adapter.notifyDataSetChanged()
                Log.d("Coro", "adapter: ${adapter.itemCount}")
            }
        }
    fun goInsertActivity(view: View) {
        startActivity(Intent(this, InsertDataActivity::class.java))
    }


}