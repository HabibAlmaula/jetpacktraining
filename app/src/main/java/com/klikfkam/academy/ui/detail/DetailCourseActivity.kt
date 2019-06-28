package com.klikfkam.academy.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.klikfkam.academy.utils.DataDummy
import kotlinx.android.synthetic.main.activity_detail_course.*
import kotlinx.android.synthetic.main.fragment_module_list.*


class DetailCourseActivity : AppCompatActivity() {

    private lateinit var detailCourseAdapter: DetailCourseAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(com.klikfkam.academy.R.layout.activity_detail_course)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extras = intent.extras

        if (extras!=null){
            val courseId = extras.getString(EXTRA_COURSE)

            detailCourseAdapter = DetailCourseAdapter(this,DataDummy.generateDummyModules(courseId))

        }

        rv_module.isNestedScrollingEnabled = false
        rv_module.layoutManager = LinearLayoutManager(this)
        rv_module.setHasFixedSize(true)
        rv_module.adapter = detailCourseAdapter






    }

    companion object {
        const val EXTRA_COURSE = "extra_course"
    }

}
