package com.klikfkam.academy.ui.academy

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.klikfkam.academy.R
import com.klikfkam.academy.data.CourseEntity
import com.klikfkam.academy.ui.detail.DetailCourseActivity


class AcademyAdapter(val context: Context, val mCourses: List<CourseEntity>) : RecyclerView.Adapter<AcademyAdapter.AcademyViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AcademyViewHolder {
        return AcademyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_academy, parent, false))
    }

    override fun getItemCount(): Int {
        return mCourses.size
    }


    override fun onBindViewHolder(holder: AcademyViewHolder, position: Int) {
        holder.tvTitle.text = mCourses[position].title
        holder.tvDescription.text = mCourses[position].description
        holder.tvDate.text = String.format("Deadline %s",mCourses[position].deadline)
        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailCourseActivity::class.java)
            intent.putExtra(DetailCourseActivity.EXTRA_COURSE, mCourses[position].courseId)
            context.startActivity(intent)
        }

        Glide.with(holder.itemView.context)
            .load(mCourses[position].imagePath)
            .apply(
                RequestOptions.placeholderOf(R.drawable.ic_loading)
                    .error(R.drawable.ic_error)
            )
            .into(holder.imgPoster)

    }

    class AcademyViewHolder (itemView : View) : RecyclerView.ViewHolder(itemView){

        val tvTitle: TextView = itemView.findViewById(R.id.tv_item_title)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)
        val tvDate: TextView = itemView.findViewById(R.id.tv_item_date)
        val imgPoster: ImageView = itemView.findViewById(R.id.img_poster)

    }



}