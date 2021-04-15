package com.randhypi.academy.ui.bookmark

import com.randhypi.academy.data.CourseEntity

interface BookmarkFragmentCallback {
    fun onShareClick(course: CourseEntity)
}
