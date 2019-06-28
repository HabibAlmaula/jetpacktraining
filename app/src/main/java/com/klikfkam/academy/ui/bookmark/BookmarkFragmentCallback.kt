package com.klikfkam.academy.ui.bookmark

import com.klikfkam.academy.data.CourseEntity


interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}