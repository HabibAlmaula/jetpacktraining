package com.klikfkam.academy.ui.bookmark

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.klikfkam.academy.R
import com.klikfkam.academy.data.CourseEntity
import com.klikfkam.academy.ui.detail.DetailCourseActivity


class BookmarkAdapter(val context: Context, val mCourses: List<CourseEntity> ) : RecyclerView.Adapter<BookmarkAdapter.BookmarkViewHolder>(){
    companion object{
        private val callback: BookmarkFragmentCallback? = null

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookmarkViewHolder {
        return BookmarkViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.items_bookmark, parent, false))
    }

    override fun getItemCount(): Int {
        return mCourses.size
    }

    override fun onBindViewHolder(holder: BookmarkViewHolder, position: Int) {
        holder.tvTitle?.text = mCourses[position].title
        holder.tvDate?.text = String.format("Deadline %s", mCourses[position].deadline)
        holder.tvDescription?.text = mCourses[position].description

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailCourseActivity::class.java)
            intent.putExtra(DetailCourseActivity.EXTRA_COURSE, mCourses[position].courseId)
            context.startActivity(intent)

        }
        holder.imgShare?.setOnClickListener {
            callback?.onShareClick(mCourses[holder.adapterPosition])
        }

        holder.imgPoster?.let {
            Glide.with(holder.itemView.getContext())
                .load(mCourses[position].imagePath)
                .apply(RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error))
                .into(it)
        }
    }

    class BookmarkViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val tvTitle: TextView? = itemView.findViewById(R.id.tv_item_title)
        val tvDescription: TextView? = itemView.findViewById(R.id.tv_item_description)
        val tvDate: TextView? = itemView.findViewById(R.id.tv_item_date)
        val imgShare: ImageButton? = itemView.findViewById(R.id.img_share)
        val imgPoster: ImageView? = itemView.findViewById(R.id.img_poster)
    }

}