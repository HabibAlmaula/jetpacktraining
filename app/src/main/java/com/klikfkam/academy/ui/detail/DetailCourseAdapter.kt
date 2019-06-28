package com.klikfkam.academy.ui.detail

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.klikfkam.academy.R
import com.klikfkam.academy.data.ModuleEntity


class DetailCourseAdapter(val context: Context, val mModules : List<ModuleEntity>) :
    RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModuleViewHolder {
        return ModuleViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_module_list, parent, false))
    }

    override fun getItemCount(): Int {
        return mModules.size
    }

    override fun onBindViewHolder(holder: ModuleViewHolder, position: Int) {
        holder.bind(mModules[position].mTitle.toString())
    }

    class ModuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val textTitle: TextView = itemView.findViewById(R.id.text_module_title)
        fun bind(title: String) {
            textTitle.text = title
        }
    }
}
