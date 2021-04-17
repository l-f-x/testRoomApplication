package com.aboba.room

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import coil.load
import com.aboba.room.databinding.ActivityInsertDataBinding
import com.google.android.material.snackbar.Snackbar

class InsertDataActivity : AppCompatActivity() {
    lateinit var binding: ActivityInsertDataBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityInsertDataBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun push(view: View) {
        Snackbar.make(view,
            binding.etName.text.toString(),
            Snackbar.LENGTH_SHORT).show()
    }

    fun preload(view: View) {
        binding.preloadContainer.load(binding.etImageUrl.text.toString()){
            placeholder(R.drawable.ic_baseline_timer_128)
            error(R.drawable.ic_baseline_error_outline_24)
        }
    }
}