package com.aboba.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.aboba.room.databinding.ActivityInsertDataBinding

class InsertDataActivity : AppCompatActivity() {
    lateinit var binding: ActivityInsertDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInsertDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
}