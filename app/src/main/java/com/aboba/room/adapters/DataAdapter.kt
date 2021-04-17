package com.aboba.room.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.aboba.room.R
import com.aboba.room.db.Data

class DataAdapter(private val dataSet:List<Data>) :
    RecyclerView.Adapter<DataAdapter.ViewHolder>() {
        class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            //Initialize design links
             val tvName:TextView
             val tvDesc:TextView
             val imgContainer:ImageView

            init {
                tvName=view.findViewById(R.id.tv_name_rv_item)
                tvDesc=view.findViewById(R.id.tv_desc_rv_item)
                imgContainer=view.findViewById(R.id.img_container_rv_item)
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context)
            .inflate(R.layout.data_recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvName.text=dataSet[position].name
        holder.tvDesc.text=dataSet[position].desc
        holder.imgContainer.load(dataSet[position].url){
            error(R.drawable.ic_baseline_error_outline_24)
        }
    }

    override fun getItemCount(): Int {
        return dataSet.size
    }
}